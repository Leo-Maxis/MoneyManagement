package org.collection.tabs;

import javax.swing.*;

public class AddReceiptTypePanel {
    private JPanel panelAddReceiptType;
    private JTextField txtID;
    private JTextField txtName;
    private JButton btnNew;
    private JButton btnSave;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnList;

    public JPanel getPanelAddReceiptType() {
        return panelAddReceiptType;
    }

    public void setPanelAddReceiptType(JPanel panelAddReceiptType) {
        this.panelAddReceiptType = panelAddReceiptType;
    }
}
