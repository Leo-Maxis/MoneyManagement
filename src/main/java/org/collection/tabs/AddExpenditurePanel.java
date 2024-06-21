package org.collection.tabs;

import org.collection.Main.validator.ExpenditureTypeValidator;
import org.collection.Main.validator.ExpenditureValidator;
import org.collection.dao.ExpenditureDAO;
import org.collection.dao.ExpenditureTypeDAO;
import org.collection.entity.Expenditure;
import org.collection.entity.ExpenditureType;
import org.collection.util.DateUtil;
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

    private void changFieldStates(boolean isEditable) {
        txtName.setEditable(isEditable);
        ftfAmount.setEditable(isEditable);
        ftfDate.setEditable(isEditable);
        txaNote.setEditable(isEditable);
        cbType.setEditable(isEditable);
    }

    public AddExpenditurePanel() {
        loadType();
        changeButtonState(false, true, false, false);
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String valid = ExpenditureValidator.validate(txtName,ftfAmount, ftfDate, cbType);
                    if (valid!=null) {
                        MessageBox.showErrorMessage(null, "Error", valid);
                        return;
                    }
                    Expenditure entity = new Expenditure();
                    entity.setName(txtName.getText());
                    entity.setAmount(Double.parseDouble(ftfAmount.getText()));
                    DateUtil dateUtil = new DateUtil();
                    entity.setExpenditureDate(dateUtil.toDate(ftfDate.getText()));
                    entity.setNote(txaNote.getText());
                    ExpenditureType ext = (ExpenditureType) cbType.getSelectedItem();
                    entity.setType(ext.getId());
                    ExpenditureDAO dao = new ExpenditureDAO();
                    entity = dao.insert(entity);
                    txtID.setText("" + entity.getId());
                    changFieldStates(false);
                    changeButtonState(true, false, true, true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                    MessageBox.showErrorMessage(null, "Error", exception.getMessage());
                }
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
