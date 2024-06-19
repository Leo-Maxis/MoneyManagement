package org.collection.tabs;

import javax.swing.*;

public class AddExpenditureTypePanel {
    private JPanel panelAddExpenditureType;
    private JTextField txtID;
    private JTextField txtName;
    private JButton btnNew;
    private JButton btnSave;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnList;


    public JPanel getPanelAddExpenditureType() {
        return panelAddExpenditureType;
    }

    public void setPanelAddExpenditureType(JPanel panelAddExpenditureType) {
        this.panelAddExpenditureType = panelAddExpenditureType;
    }
}
