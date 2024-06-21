package org.collection.tabs;

import org.collection.Main.validator.ExpenditureTypeValidator;
import org.collection.Main.validator.ExpenditureValidator;
import org.collection.dao.ExpenditureTypeDAO;
import org.collection.entity.ExpenditureType;
import org.collection.util.MessageBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddExpenditurePanel extends Component {
    private JTextField txtID;
    private JTextField txtName;
    private JFormattedTextField ftfAmount;
    private JComboBox<ExpenditureType> cbType;
    private JTextArea txaNote;
    private JFormattedTextField ftfDate;
    private JPanel panelAddExpenditure;
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

    public AddExpenditurePanel() {
        loadType();
        changeButtonState(false, true, false, false);
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String valid = ExpenditureValidator.validate(txtName);
                    if (valid!=null) {
                        MessageBox.showErrorMessage(null, "Error", valid);
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
                    exception.printStackTrace();
                    MessageBox.showErrorMessage(null, "Error", exception.getMessage());
                }
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getPanelAddExpenditure() {
        return panelAddExpenditure;
    }

    public void setPanelAddExpenditure(JPanel panelAddExpenditure) {
        this.panelAddExpenditure = panelAddExpenditure;
    }

    private void loadType() {
        try {
            ExpenditureTypeDAO dao = new ExpenditureTypeDAO();
            var list = dao.findAll();
            for(ExpenditureType item : list) {
                cbType.addItem(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            MessageBox.showErrorMessage(AddExpenditurePanel.this, ex.getMessage());
        }
    }

}
