package org.collection.tabs;

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

    public ListExpenditureTypePanel() {
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
//                    JOptionPane.showMessageDialog(null, "Error: " + exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                    MessageBox.showErrorMessage(null, "Error", exception.getMessage());
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
