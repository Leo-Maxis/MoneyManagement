package org.collection.tabs;

import org.collection.dao.ExpenditureTypeDAO;
import org.collection.entity.ExpenditureType;
import org.collection.util.MessageBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ComponentAdapter;
import java.util.List;


public class ListExpenditureTypePanel {
    private JPanel panelListExpenditureType;
    private JTable tblList;
    private DefaultTableModel model = null;

    public ListExpenditureTypePanel() {
        initTable();
        loadData();
//        panelListExpenditureType.addComponentListener(new ComponentAdapter() {
//        });
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
