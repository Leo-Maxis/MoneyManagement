package org.collection.tabs;

import javax.swing.*;
import java.awt.*;

public class AddExpenditurePanel extends Component {
    private JTextField textField1;
    private JTextField textField2;
    private JFormattedTextField formattedTextField1;
    private JComboBox comboBox1;
    private JTextArea textArea1;
    private JFormattedTextField formattedTextField2;
    private JPanel panelAddExpenditure;
    private JButton newButton;
    private JButton saveButton;
    private JButton updateButton;
    private JButton deleteButton;

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JFormattedTextField getFormattedTextField1() {
        return formattedTextField1;
    }

    public void setFormattedTextField1(JFormattedTextField formattedTextField1) {
        this.formattedTextField1 = formattedTextField1;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public void setComboBox1(JComboBox comboBox1) {
        this.comboBox1 = comboBox1;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

    public JFormattedTextField getFormattedTextField2() {
        return formattedTextField2;
    }

    public void setFormattedTextField2(JFormattedTextField formattedTextField2) {
        this.formattedTextField2 = formattedTextField2;
    }

    public JPanel getPanelAddExpenditure() {
        return panelAddExpenditure;
    }

    public void setPanelAddExpenditure(JPanel panelAddExpenditure) {
        this.panelAddExpenditure = panelAddExpenditure;
    }

    public JButton getNewButton() {
        return newButton;
    }

    public void setNewButton(JButton newButton) {
        this.newButton = newButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
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
