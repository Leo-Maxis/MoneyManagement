package org.collection.tabs;

import org.collection.Main.MainFrame;
import org.collection.dao.ExpenditureTypeDAO;
import org.collection.dao.ReceiptTypeDAO;
import org.collection.entity.ExpenditureType;
import org.collection.entity.ReceiptType;
import org.collection.util.MessageBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListReceiptTypePanel {
    private JPanel panelListReceiptType;
    private JTable tblList;
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
