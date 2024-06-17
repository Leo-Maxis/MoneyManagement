package org.collection.tabs;

import javax.swing.*;
import java.awt.*;

public class AddExpenditurePanel extends Component {
    private JTextField txtID;
    private JTextField txtName;
    private JFormattedTextField ftfAmount;
    private JComboBox cbType;
    private JTextArea txaNote;
    private JFormattedTextField ftfDate;
    private JPanel panelAddExpenditure;
    private JButton btnNew;
    private JButton btnSave;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnList;

    public JTextField getTextField1() {
        return txtID;
    }

    public void setTextField1(JTextField textField1) {
        this.txtID = textField1;
    }

    public JTextField getTextField2() {
        return txtName;
    }

    public void setTextField2(JTextField textField2) {
        this.txtName = textField2;
    }

    public JFormattedTextField getFormattedTextField1() {
        return ftfAmount;
    }

    public void setFormattedTextField1(JFormattedTextField formattedTextField1) {
        this.ftfAmount = formattedTextField1;
    }

    public JComboBox getComboBox1() {
        return cbType;
    }

    public void setComboBox1(JComboBox comboBox1) {
        this.cbType = comboBox1;
    }

    public JTextArea getTextArea1() {
        return txaNote;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.txaNote = textArea1;
    }

    public JFormattedTextField getFormattedTextField2() {
        return ftfDate;
    }

    public void setFormattedTextField2(JFormattedTextField formattedTextField2) {
        this.ftfDate = formattedTextField2;
    }

    public JPanel getPanelAddExpenditure() {
        return panelAddExpenditure;
    }

    public void setPanelAddExpenditure(JPanel panelAddExpenditure) {
        this.panelAddExpenditure = panelAddExpenditure;
    }

    public JButton getNewButton() {
        return btnNew;
    }

    public void setNewButton(JButton newButton) {
        this.btnNew = newButton;
    }

    public JButton getSaveButton() {
        return btnSave;
    }

    public void setSaveButton(JButton saveButton) {
        this.btnSave = saveButton;
    }

    public JButton getUpdateButton() {
        return btnUpdate;
    }

    public void setUpdateButton(JButton updateButton) {
        this.btnUpdate = updateButton;
    }

    public JButton getDeleteButton() {
        return btnDelete;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.btnDelete = deleteButton;
    }

//    public AddExpenditurePanel frameLayout() {
//        JFrame frame = new JFrame("AddExpenditure");
//        frame.setContentPane(new AddExpenditurePanel().panelAddExpenditure);
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//        frame.setLocationRelativeTo(null);
//        frame.setSize(600, 350);
//        return null;
//    }

}
