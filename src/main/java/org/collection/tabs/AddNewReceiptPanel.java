package org.collection.tabs;

import javax.swing.*;
import java.awt.*;

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

    public JPanel getPanelAddReceipt() {
        return panelAddReceipt;
    }

    public void setPanelAddReceipt(JPanel panelAddExpenditure) {
        this.panelAddReceipt = panelAddExpenditure;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JFormattedTextField getFtfAmount() {
        return ftfAmount;
    }

    public void setFtfAmount(JFormattedTextField ftfAmount) {
        this.ftfAmount = ftfAmount;
    }

    public JComboBox getCbType() {
        return cbType;
    }

    public void setCbType(JComboBox cbType) {
        this.cbType = cbType;
    }

    public JFormattedTextField getFtfDate() {
        return ftfDate;
    }

    public void setFtfDate(JFormattedTextField ftfDate) {
        this.ftfDate = ftfDate;
    }

    public JTextArea getTxaNote() {
        return txaNote;
    }

    public void setTxaNote(JTextArea txaNote) {
        this.txaNote = txaNote;
    }

    public JButton getBtnNew() {
        return btnNew;
    }

    public void setBtnNew(JButton btnNew) {
        this.btnNew = btnNew;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(JButton btnSave) {
        this.btnSave = btnSave;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(JButton btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JButton getBtnList() {
        return btnList;
    }

    public void setBtnList(JButton btnList) {
        this.btnList = btnList;
    }
}
