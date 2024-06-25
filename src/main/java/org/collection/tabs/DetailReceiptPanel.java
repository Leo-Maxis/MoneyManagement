package org.collection.tabs;

import org.collection.dao.ReceiptDAO;
import org.collection.dao.ReceiptTypeDAO;
import org.collection.entity.Receipt;
import org.collection.entity.ReceiptType;
import org.collection.util.DateUtil;
import org.collection.util.MessageBox;

import javax.swing.*;

public class DetailReceiptPanel {
    private JPanel panelDetail;
    private JLabel lblID;
    private JLabel lblName;
    private JLabel lblAmount;
    private JLabel lblReceiptDate;
    private JLabel lblType;
    private JTextArea txaNote;

    public DetailReceiptPanel(int id) {
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
            ReceiptTypeDAO dao = new ReceiptTypeDAO();
            var list = dao.findAll();
            for(ReceiptType item : list) {
                lblType.setText(String.valueOf(item));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            MessageBox.showErrorMessage(null, ex.getMessage());
        }
    }

    private void loadByID(int id) {
        try {
            ReceiptDAO dao = new ReceiptDAO();
            Receipt entity = dao.findById(id);
            lblID.setText("" + entity.getId());
            lblName.setText(entity.getName());
            lblAmount.setText("" + entity.getAmount());
            DateUtil dateUtil = new DateUtil();
            lblReceiptDate.setText(dateUtil.toString(entity.getReceiptDate()));
            txaNote.setText(entity.getNote());
            lblType.setText(String.valueOf(entity.getType()));
        } catch (Exception e) {
            MessageBox.showErrorMessage(null,"Error", e.getMessage());
        }
    }
}
