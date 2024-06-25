package org.collection.tabs;

import org.collection.Main.MainFrame;
import org.collection.Main.validator.ExpenditureValidator;
import org.collection.Main.validator.ReceiptValidator;
import org.collection.dao.ExpenditureDAO;
import org.collection.dao.ExpenditureTypeDAO;
import org.collection.dao.ReceiptDAO;
import org.collection.dao.ReceiptTypeDAO;
import org.collection.entity.Expenditure;
import org.collection.entity.ExpenditureType;
import org.collection.entity.Receipt;
import org.collection.entity.ReceiptType;
import org.collection.util.DateUtil;
import org.collection.util.MessageBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewReceiptPanel extends Component {
    private JPanel panelAddReceipt;
    private JTextField txtID;
    private JTextField txtName;
    private JFormattedTextField ftfAmount;
    private JComboBox<ReceiptType> cbType;
    private JFormattedTextField ftfDate;
    private JTextArea txaNote;
    private JButton btnNew;
    private JButton btnSave;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnList;
    private JButton btnEdit;

    private MainFrame mainFrame;

    private void newEditable() {
        txtID.setText("");
        txtName.setText("");
        ftfAmount.setText("");
        ftfDate.setText("");
        txaNote.setText("");
    }
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

    private void loadType() {
        try {
            ReceiptTypeDAO dao = new ReceiptTypeDAO();
            var list = dao.findAll();
            for(ReceiptType item : list) {
                cbType.addItem(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            MessageBox.showErrorMessage(AddNewReceiptPanel.this, ex.getMessage());
        }
    }

    private void loadByID(int id) {
        try {
            ReceiptDAO dao = new ReceiptDAO();
            Receipt entity = dao.findById(id);
            txtID.setText("" + entity.getId());
            txtName.setText(entity.getName());
            ftfAmount.setText("" + entity.getAmount());
            DateUtil dateUtil = new DateUtil();
            ftfDate.setText(dateUtil.toString(entity.getReceiptDate()));
            txaNote.setText(entity.getNote());
            for (int i = 0; i < cbType.getItemCount(); i++) {
                var item = cbType.getItemAt(i);
                if (item.getId() == entity.getType()) {
                    cbType.setSelectedItem(item);
                    break;
                }
            }
            changFieldStates(true);
            changeButtonState(true, false, true, true);
        } catch (Exception e) {
            MessageBox.showErrorMessage(null,"Error", e.getMessage());
        }
    }

    public AddNewReceiptPanel(MainFrame mainFrame) {
        loadType();
        changeButtonState(false, true,false,false);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String valid = ReceiptValidator.validate(txtName,ftfAmount,ftfDate,cbType);
                    if (valid!=null) {
                        MessageBox.showErrorMessage(null, valid);
                        return;
                    }
                    Receipt entity = new Receipt();
                    entity.setName(txtName.getText());
                    entity.setAmount(Double.parseDouble(ftfAmount.getText()));
                    DateUtil date = new DateUtil();
                    entity.setReceiptDate(date.toDate(ftfDate.getText()));
                    entity.setNote(txaNote.getText());
                    ReceiptType rec = (ReceiptType) cbType.getSelectedItem();
                    entity.setType(rec.getId());
                    ReceiptDAO dao = new ReceiptDAO();
                    entity = dao.insert(entity);
                    txtID.setText("" + entity.getId());
                    MessageBox.showInfomationMessage(null, "Infomation","Receipt is saved");
                    changeButtonState(true, false,true,true);
                    changFieldStates(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    MessageBox.showErrorMessage(null, ex.getMessage());
                }
            }
        });
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newEditable();
                changeButtonState(false,true,false,false);
                changFieldStates(true);
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (MessageBox.showConfirmMessage(null,"Do you want to update?")==JOptionPane.NO_OPTION) {
                        return;
                    }
                    String valid = ReceiptValidator.validate(txtName,ftfAmount,ftfDate,cbType);
                    if (valid!=null) {
                        MessageBox.showErrorMessage(null, valid);
                        return;
                    }
                    Receipt entity = new Receipt();
                    entity.setName(txtName.getText());
                    entity.setAmount(Double.parseDouble(ftfAmount.getText()));
                    DateUtil date = new DateUtil();
                    entity.setReceiptDate(date.toDate(ftfDate.getText()));
                    entity.setNote(txaNote.getText());
                    ReceiptType rec = (ReceiptType) cbType.getSelectedItem();
                    entity.setType(rec.getId());
                    entity.setId(Integer.parseInt(txtID.getText()));
                    ReceiptDAO dao = new ReceiptDAO();
                    var result = dao.update(entity);
                    if (result) {
                        MessageBox.showInfomationMessage(null, "Infomation","Receipt is updated");
                    } else  {
                        MessageBox.showErrorMessage(null, "Receipt cannot be updated");
                    }
                    changeButtonState(true, false,false,true);
                    changFieldStates(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    MessageBox.showErrorMessage(null, ex.getMessage());
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

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (MessageBox.showConfirmMessage(null, "Do you want to delete?")==JOptionPane.NO_OPTION) {
                        return;
                    }
                    int id = Integer.parseInt(txtID.getText());
                    ReceiptDAO dao = new ReceiptDAO();
                    var result = dao.delete(id);
                    if (result) {
                        MessageBox.showInfomationMessage(null, "Infomation","Receipts is deleted!!");
                        txtID.setText("");
                        txtName.setText("");
                        ftfAmount.setText("");
                        ftfDate.setText("");
                        txaNote.setText("");
                    } else  {
                        MessageBox.showErrorMessage(null, "Recepits cannot be deleted!!");
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
                mainFrame.showListReceipt();
            }
        });
    }
    public AddNewReceiptPanel(MainFrame mainFrame, int id) {
        loadByID(id);
        loadType();
        changeButtonState(false, true,false,false);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String valid = ReceiptValidator.validate(txtName,ftfAmount,ftfDate,cbType);
                    if (valid!=null) {
                        MessageBox.showErrorMessage(null, valid);
                        return;
                    }
                    Receipt entity = new Receipt();
                    entity.setName(txtName.getText());
                    entity.setAmount(Double.parseDouble(ftfAmount.getText()));
                    DateUtil date = new DateUtil();
                    entity.setReceiptDate(date.toDate(ftfDate.getText()));
                    entity.setNote(txaNote.getText());
                    ReceiptType rec = (ReceiptType) cbType.getSelectedItem();
                    entity.setType(rec.getId());
                    ReceiptDAO dao = new ReceiptDAO();
                    entity = dao.insert(entity);
                    txtID.setText("" + entity.getId());
                    MessageBox.showInfomationMessage(null, "Infomation","Receipt is saved");
                    changeButtonState(true, false,true,true);
                    changFieldStates(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    MessageBox.showErrorMessage(null, ex.getMessage());
                }
            }
        });
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newEditable();
                changeButtonState(false,true,false,false);
                changFieldStates(true);
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (MessageBox.showConfirmMessage(null,"Do you want to update?")==JOptionPane.NO_OPTION) {
                        return;
                    }
                    String valid = ReceiptValidator.validate(txtName,ftfAmount,ftfDate,cbType);
                    if (valid!=null) {
                        MessageBox.showErrorMessage(null, valid);
                        return;
                    }
                    Receipt entity = new Receipt();
                    entity.setName(txtName.getText());
                    entity.setAmount(Double.parseDouble(ftfAmount.getText()));
                    DateUtil date = new DateUtil();
                    entity.setReceiptDate(date.toDate(ftfDate.getText()));
                    entity.setNote(txaNote.getText());
                    ReceiptType rec = (ReceiptType) cbType.getSelectedItem();
                    entity.setType(rec.getId());
                    entity.setId(Integer.parseInt(txtID.getText()));
                    ReceiptDAO dao = new ReceiptDAO();
                    var result = dao.update(entity);
                    if (result) {
                        MessageBox.showInfomationMessage(null, "Infomation","Receipt is updated");
                    } else  {
                        MessageBox.showErrorMessage(null, "Receipt cannot be updated");
                    }
                    changeButtonState(true, false,false,true);
                    changFieldStates(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    MessageBox.showErrorMessage(null, ex.getMessage());
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

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (MessageBox.showConfirmMessage(null, "Do you want to delete?")==JOptionPane.NO_OPTION) {
                        return;
                    }
                    int id = Integer.parseInt(txtID.getText());
                    ReceiptDAO dao = new ReceiptDAO();
                    var result = dao.delete(id);
                    if (result) {
                        MessageBox.showInfomationMessage(null, "Infomation","Receipts is deleted!!");
                        txtID.setText("");
                        txtName.setText("");
                        ftfAmount.setText("");
                        ftfDate.setText("");
                        txaNote.setText("");
                    } else  {
                        MessageBox.showErrorMessage(null, "Recepits cannot be deleted!!");
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
                mainFrame.showListReceipt();
            }
        });
    }

    public JPanel getPanelAddReceipt() {
        return panelAddReceipt;
    }

    public void setPanelAddReceipt(JPanel panelAddExpenditure) {
        this.panelAddReceipt = panelAddExpenditure;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

}
