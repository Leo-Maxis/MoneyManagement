package org.collection.tabs;

import org.collection.dao.ExpenditureTypeDAO;
import org.collection.entity.ExpenditureType;
import org.collection.util.MessageBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddExpenditureTypePanel {
    private JPanel panelAddExpenditureType;
    private JTextField txtID;
    private JTextField txtName;
    private JButton btnNew;
    private JButton btnSave;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnList;
    private JButton btnEdit;


    private void changeButtonState(boolean edit, boolean save, boolean update, boolean delete) {
        btnEdit.setEnabled(edit);
        btnSave.setEnabled(save);
        btnUpdate.setEnabled(update);
        btnDelete.setEnabled(delete);
    }

    public AddExpenditureTypePanel() {
        changeButtonState(false, true, false, false);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StringBuilder sb = new StringBuilder();
                    if (txtName.getText().equals("")) {
                        sb.append("Name must be entered");
                        txtName.setBackground(Color.yellow);
                        txtName.setEditable(true);
                    }
                    else {
                        txtName.setBackground(Color.white);
                    }
                    if (!sb.isEmpty()) {
                        MessageBox.showErrorMessage(null, "Error", sb.toString());
                        return;
                    }
                    ExpenditureType entity = new ExpenditureType();
                    entity.setName(txtName.getText());
                    ExpenditureTypeDAO dao = new ExpenditureTypeDAO();
                    entity = dao.insert(entity);
                    txtID.setText("" + entity.getId());
                    MessageBox.showInfomationMessage(null, "Infomation","Type is saved");
                    txtID.setEditable(false);
                    txtName.setEditable(false);
                    changeButtonState(true, false, true, true);
                } catch (Exception exception) {
//                    JOptionPane.showMessageDialog(null, "Error: " + exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                    MessageBox.showErrorMessage(null, "Error", exception.getMessage());
                }
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtName.setEditable(true);
            }
        });
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtID.setText("");
                txtName.setText("");
                changeButtonState(false, true, false, false);
            }
        });
    }

    public JPanel getPanelAddExpenditureType() {
        return panelAddExpenditureType;
    }

    public void setPanelAddExpenditureType(JPanel panelAddExpenditureType) {
        this.panelAddExpenditureType = panelAddExpenditureType;
    }
}
