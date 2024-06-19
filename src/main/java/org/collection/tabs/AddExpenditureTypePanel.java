package org.collection.tabs;

import org.collection.dao.ExpenditureTypeDAO;
import org.collection.entity.ExpenditureType;
import org.collection.util.MessageBox;

import javax.swing.*;
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


    public AddExpenditureTypePanel() {
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ExpenditureType entity = new ExpenditureType();
                    entity.setName(txtName.getText());
                    ExpenditureTypeDAO dao = new ExpenditureTypeDAO();
                    entity = dao.insert(entity);
                    txtID.setText("" + entity.getId());
                    MessageBox.showInfomationMessage(null, "Infomation","Type is saved");
                    txtID.setEditable(false);
                    txtName.setEditable(false);
                } catch (Exception exception) {
//                    JOptionPane.showMessageDialog(null, "Error: " + exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                    MessageBox.showErrorMessage(null, "Error", exception.getMessage());
                }
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
