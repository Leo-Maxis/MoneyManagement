package org.collection.tabs;

import org.collection.Main.MainFrame;
import org.collection.dao.ExpenditureTypeDAO;
import org.collection.entity.ExpenditureType;
import org.collection.util.MessageBox;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class ListExpenditureTypePanel {
    private JPanel panelListExpenditureType;
    private JTable tblList;
    private JButton btnDelete;
    private JButton btnEdit;
    private DefaultTableModel model = null;

    private MainFrame mainFrame;

    public ListExpenditureTypePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initTable();
        loadData();
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (MessageBox.showConfirmMessage(null, "Do you want to delete?")==JOptionPane.NO_OPTION) {
                        return;
                    }
                    ExpenditureTypeDAO dao = new ExpenditureTypeDAO();
                    int selectedRow = tblList.getSelectedRow();
                    if (selectedRow == -1) {
                        MessageBox.showErrorMessage(null, "Please choose atleast one row to delete!");
                        return;
                    }
                    Object idObj = tblList.getValueAt(selectedRow, 0);
                    if (idObj != null) {
                        int id = Integer.parseInt(idObj.toString());
                        if (dao.delete(id)) {
                                MessageBox.showInfomationMessage(null, "Infomation", "Type is deleted!");
                                loadData();
                        } else {
                                MessageBox.showErrorMessage(null, "Error", "Typed can not be deleted!");
                        }
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                    MessageBox.showErrorMessage(null, "Error", exception.getMessage());
                }
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblList.getSelectedRow();
                if(selectedRow != -1) {
                    Object idObj = tblList.getValueAt(selectedRow, 0);
                    mainFrame.showEditExpenditureTypes(Integer.parseInt(idObj.toString()));
                } else {
                    MessageBox.showErrorMessage(null, "Please choose atleast one row to edit!");
                }
            }
        });
    }

    public JPanel getPanelListExpenditureType() {
        return panelListExpenditureType;
    }

    public void setPanelListExpenditureType(JPanel panelListExpenditureType) {
        this.panelListExpenditureType = panelListExpenditureType;
    }

    private void initTable() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[] {"ID","Name"});

        tblList.setModel(model);
    }

    private void loadData() {
        try {
            ExpenditureTypeDAO dao = new ExpenditureTypeDAO();
            List<ExpenditureType> list = dao.findAll();
            model.setRowCount(0);
            for (ExpenditureType item : list) {
                Object[] row = new Object[]{item.getId(), item.getName()};
                model.addRow(row);
            }
            model.fireTableDataChanged();
        } catch (Exception e) {
            MessageBox.showErrorMessage(null, "Error", e.getMessage());
        }
    }
}
