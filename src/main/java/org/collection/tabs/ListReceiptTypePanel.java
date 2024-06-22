package org.collection.tabs;

import org.collection.Main.MainFrame;
import org.collection.dao.ExpenditureTypeDAO;
import org.collection.dao.ReceiptTypeDAO;
import org.collection.entity.ReceiptType;
import org.collection.util.MessageBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListReceiptTypePanel {
    private JPanel panelListReceiptType;
    private JTable tblList;
    private JButton btnDelete;
    private JButton btnEdit;
    private MainFrame mainFrame;
    private DefaultTableModel model;

    public JPanel getPanelListReceiptType() {
        return panelListReceiptType;
    }

    public void setPanelListReceiptType(JPanel panelListReceiptType) {
        this.panelListReceiptType = panelListReceiptType;
    }

    public ListReceiptTypePanel(MainFrame mainFrame) {
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
                    ReceiptTypeDAO dao = new ReceiptTypeDAO();
                    int selectedRow = tblList.getSelectedRow();
                    Object idObj = tblList.getValueAt(selectedRow, 0);
                    if (idObj != null) {
                        int id = Integer.parseInt(idObj.toString());
                        if (dao.delete(id)) {
                            MessageBox.showInfomationMessage(null, "Infomation","Type is deleted!");
                            loadData();
                        }
                        else  {
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
                Object idObj = tblList.getValueAt(selectedRow, 0);
                mainFrame.showEditReceiptTypes(Integer.parseInt(idObj.toString()));
            }
        });
    }

    private void initTable() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[] {"ID","Name"});

        tblList.setModel(model);
    }

    private void loadData() {
        try {
            ReceiptTypeDAO dao = new ReceiptTypeDAO();
            List<ReceiptType> list = dao.findAll();
            model.setRowCount(0);
            for (ReceiptType item : list) {
                Object[] row = new Object[]{item.getId(), item.getName()};
                model.addRow(row);
            }
            model.fireTableDataChanged();
        } catch (Exception e) {
            MessageBox.showErrorMessage(null, "Error", e.getMessage());
        }
    }
}
