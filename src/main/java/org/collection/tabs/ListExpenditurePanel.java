package org.collection.tabs;

import org.collection.Main.MainFrame;
import org.collection.dao.ExpenditureDAO;
import org.collection.entity.Expenditure;
import org.collection.util.MessageBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListExpenditurePanel extends Component {
    private JTable tblList;
    private JPanel panelListExpenditure;
    private JButton btnDelete;
    private JButton btnEdit;
    private JButton btnViewDetail;

    private DefaultTableModel model;
    private MainFrame mainFrame;

    public ListExpenditurePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initTable();
        loadAll();
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (MessageBox.showConfirmMessage(null, "Do you want to delete?")==JOptionPane.NO_OPTION) {
                        return;
                    }
                    ExpenditureDAO dao = new ExpenditureDAO();
                    int selectedRow = tblList.getSelectedRow();
                    Object idObj = tblList.getValueAt(selectedRow, 0);
                    if (idObj != null) {
                        int id = Integer.parseInt(idObj.toString());
                        if (dao.delete(id)) {
                            MessageBox.showInfomationMessage(null, "Infomation","Expenditure is deleted!");
                            loadAll();
                        }
                        else  {
                            MessageBox.showErrorMessage(null, "Error", "Expenditure can not be deleted!");
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
                if (idObj != null) {
                    int id = Integer.parseInt(idObj.toString());
                    mainFrame.showEditExpenditure(id);
                }
            }
        });
        btnViewDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblList.getSelectedRow();
                Object idObj = tblList.getValueAt(selectedRow, 0);
                if (idObj != null) {
                    int id = Integer.parseInt(idObj.toString());
                    mainFrame.showDetailExpenditure(id);
                }
            }
        });
    }

    private void initTable() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[] {"ID","Name","Amount","Date","Type"});

        tblList.setModel(model);
    }

    private void loadAll() {
        try {
            ExpenditureDAO dao = new ExpenditureDAO();
            var list = dao.findAll();
            model.setRowCount(0);
            for (Expenditure item : list) {
                Object[] row = new Object[] {
                        item.getId(),
                        item.getName(),
                        item.getAmount(),
                        item.getExpenditureDate(),
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

    public JTable getTblList() {
        return tblList;
    }

    public void setTblList(JTable tblList) {
        this.tblList = tblList;
    }

    public JPanel getPanelListExpenditure() {
        return panelListExpenditure;
    }

    public void setPanelListExpenditure(JPanel panelListExpenditure) {
        this.panelListExpenditure = panelListExpenditure;
    }
}
