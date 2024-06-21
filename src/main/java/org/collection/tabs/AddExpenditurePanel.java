package org.collection.tabs;

import org.collection.Main.MainFrame;
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

    private MainFrame mainFrame;

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

    public AddExpenditurePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        loadType();
        changeButtonState(false, true, false, false);
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtID.setText("");
                txtName.setText("");
                ftfAmount.setText("");
                ftfDate.setText("");
                txaNote.setText("");
                changFieldStates(true);
                changeButtonState(false,true,false,false);
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
                    MessageBox.showInfomationMessage(null, "Infomation","Type is saved");
                    changFieldStates(false);
                    changeButtonState(true, false, true, true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                    MessageBox.showErrorMessage(null, "Error", exception.getMessage());
                }
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeButtonState(true,false,true,true);
                changFieldStates(true);
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (MessageBox.showConfirmMessage(null, "Do you want to update?")==JOptionPane.NO_OPTION) {
                        return;
                    }
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
                    entity.setId(Integer.parseInt(txtID.getText()));
                    ExpenditureDAO dao = new ExpenditureDAO();
                    var result = dao.update(entity);
                    if (result) {
                        MessageBox.showInfomationMessage(null, "Infomation","Expenditure is updated!!");
                    } else  {
                        MessageBox.showErrorMessage(null, "Expenditure cannot be updated!!");
                    }
                    changFieldStates(false);
                    changeButtonState(true, false, false, true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                    MessageBox.showErrorMessage(null, "Error", exception.getMessage());
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                if (MessageBox.showConfirmMessage(null, "Do you want to delete?")==JOptionPane.NO_OPTION) {
                    return;
                }
                int id = Integer.parseInt(txtID.getText());
                ExpenditureDAO dao = new ExpenditureDAO();
                var result = dao.delete(id);
                if (result) {
                    MessageBox.showInfomationMessage(null, "Infomation","Expenditure is deleted!!");
                    txtID.setText("");
                    txtName.setText("");
                    ftfAmount.setText("");
                    ftfDate.setText("");
                    txaNote.setText("");
                } else  {
                    MessageBox.showErrorMessage(null, "Expenditure cannot be deleted!!");
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                MessageBox.showErrorMessage(null, "Error", exception.getMessage());
            }
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showListExpenditure();
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
