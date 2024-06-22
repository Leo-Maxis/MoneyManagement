package org.collection.tabs;

import org.collection.dao.ExpenditureDAO;
import org.collection.dao.ExpenditureTypeDAO;
import org.collection.entity.Expenditure;
import org.collection.entity.ExpenditureType;
import org.collection.util.DateUtil;
import org.collection.util.MessageBox;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class DetailExpenditurePanel {
    private JTextArea txaNote;
    private JLabel lblID;
    private JLabel lblName;
    private JLabel lblAmount;
    private JLabel lblType;
    private JLabel lblExpenditureDate;
    private JPanel panelDetail;
    private JComboBox cbType;

    public DetailExpenditurePanel(int id) {
        loadType();
        loadByID(id);
    }

    public JPanel getPanelDetail() {
        return panelDetail;
    }

    public void setPanelDetail(JPanel panelDetail) {
        this.panelDetail = panelDetail;
    }

    private void loadType() {
        try {
            ExpenditureTypeDAO dao = new ExpenditureTypeDAO();
            var list = dao.findAll();
            for(ExpenditureType item : list) {
                lblType.setText(String.valueOf(item));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            MessageBox.showErrorMessage(null, ex.getMessage());
        }
    }

    private void loadByID(int id) {
        try {
            ExpenditureDAO dao = new ExpenditureDAO();
            Expenditure entity = dao.findById(id);
            lblID.setText("" + entity.getId());
            lblName.setText(entity.getName());
            lblAmount.setText("" + entity.getAmount());
            DateUtil dateUtil = new DateUtil();
            lblExpenditureDate.setText(dateUtil.toString(entity.getExpenditureDate()));
            txaNote.setText(entity.getNote());
            lblType.setText(String.valueOf(entity.getType()));
        } catch (Exception e) {
            MessageBox.showErrorMessage(null,"Error", e.getMessage());
        }
    }
}
