package org.collection.tabs;

import org.collection.Main.MainFrame;
import org.collection.dao.ReceiptDAO;
import org.collection.entity.Receipt;
import org.collection.util.MessageBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListReceiptPanel extends Component {
    private JPanel panelListReceipt;
    private JTable tblList;
    private JButton btnDelete;
    private JButton btnEdit;
    private JButton btnViewDetail;

    private DefaultTableModel model;
    private MainFrame mainFrame;

    public ListReceiptPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initTable();
        loadAll();

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getPanelListReceipt() {
        return panelListReceipt;
    }

    public void setPanelListReceipt(JPanel panelListExpenditure) {
        this.panelListReceipt = panelListExpenditure;
    }

    public JTable getTblList() {
        return tblList;
    }

    public void setTblList(JTable tblList) {
        this.tblList = tblList;
    }

    private void initTable() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[] {"ID","Name","Amount","Date","Type"});
        tblList.setModel(model);
    }

    private void loadAll() {
        try {
            ReceiptDAO dao = new ReceiptDAO();
            var list = dao.findAll();
            model.setRowCount(0);
            for (Receipt item : list) {
                Object[] row = new Object[] {
                        item.getId(),
                        item.getName(),
                        item.getAmount(),
                        item.getReceiptDate(),
                        item.getType(),
                };
                model.addRow(row);
            }
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
            MessageBox.showErrorMessage(this, ex.getMessage());
        }
    }

}
