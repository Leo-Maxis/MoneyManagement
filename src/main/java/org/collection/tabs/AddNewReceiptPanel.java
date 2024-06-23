package org.collection.tabs;

import org.collection.Main.validator.ExpenditureValidator;
import org.collection.dao.ExpenditureTypeDAO;
import org.collection.dao.ReceiptDAO;
import org.collection.dao.ReceiptTypeDAO;
import org.collection.entity.ExpenditureType;
import org.collection.entity.Receipt;
import org.collection.entity.ReceiptType;
import org.collection.util.DateUtil;
import org.collection.util.MessageBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewReceiptPanel extends Component {
    private JPanel panelAddReceipt;
    private JTextField txtID;
    private JTextField txtName;
    private JFormattedTextField ftfAmount;
    private JComboBox cbType;
    private JFormattedTextField ftfDate;
    private JTextArea txaNote;
    private JButton btnNew;
    private JButton btnSave;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnList;
    private JButton btnEdit;

    private void newEditable() {
        txtID.setText("");
        txtName.setText("");
        ftfAmount.setText("");
        ftfDate.setText("");
        txaNote.setText("");
    }
    private void changeButtonState(boolean edit, boolean save, boolean update, boolean delete) {
        btnEdit.setEnabled(edit);
        btnSave.setEnabled(save);
        btnUpdate.setEnabled(update);
        btnDelete.setEnabled(delete);
    }

    private void changFieldStates(boolean isEditable) {
        txtName.setEditable(isEditable);
        ftfAmount.setEditable(isEditable);
        ftfDate.setEditable(isEditable);
        txaNote.setEditable(isEditable);
        cbType.setEditable(isEditable);
        cbType.setEnabled(isEditable);
    }

    private void loadType() {
        try {
            ReceiptTypeDAO dao = new ReceiptTypeDAO();
            var list = dao.findAll();
            for(ReceiptType item : list) {
                cbType.addItem(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            MessageBox.showErrorMessage(AddNewReceiptPanel.this, ex.getMessage());
        }
    }

    public AddNewReceiptPanel() {
        loadType();
        changeButtonState(false, true,false,false);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String valid = ExpenditureValidator.validate(txtName,ftfAmount,ftfDate,cbType);
                    if (valid!=null) {
                        MessageBox.showErrorMessage(null, valid);
                        return;
                    }
                    Receipt entity = new Receipt();
                    entity.setName(txtName.getText());
                    entity.setAmount(Double.parseDouble(ftfAmount.getText()));
                    DateUtil date = new DateUtil();
                    entity.setReceiptDate(date.toDate(ftfDate.getText()));
                    entity.setNote(txaNote.getText());
                    ReceiptType rec = (ReceiptType) cbType.getSelectedItem();
                    entity.setType(rec.getId());
                    ReceiptDAO dao = new ReceiptDAO();
                    entity = dao.insert(entity);
                    txtID.setText("" + entity.getId());
                    MessageBox.showInfomationMessage(null, "Infomation","Receipt is saved");
                    changeButtonState(true, false,true,true);
                    changFieldStates(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    MessageBox.showErrorMessage(null, ex.getMessage());
                }
            }
        });
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newEditable();
            }
        });
    }

    public JPanel getPanelAddReceipt() {
        return panelAddReceipt;
    }

    public void setPanelAddReceipt(JPanel panelAddExpenditure) {
        this.panelAddReceipt = panelAddExpenditure;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

}
