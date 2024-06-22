package org.collection.tabs;

import org.collection.Main.MainFrame;
import org.collection.Main.validator.ExpenditureTypeValidator;
import org.collection.dao.ReceiptTypeDAO;
import org.collection.entity.ReceiptType;
import org.collection.util.MessageBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddReceiptTypePanel {
    private JPanel panelAddReceiptType;
    private JTextField txtID;
    private JTextField txtName;
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
    private void loadById(int id) {
        try {
            ReceiptTypeDAO dao = new ReceiptTypeDAO();
            ReceiptType entity = dao.findById(id);
            txtID.setText("" + entity.getId());
            txtName.setText(entity.getName());
            changeButtonState(true, false, true, true);
        } catch (Exception ex) {
            ex.printStackTrace();
            MessageBox.showErrorMessage(null, ex.getMessage());
        }
    }

    public AddReceiptTypePanel(MainFrame mainFrame, int id) {
        loadById(id);
        this.mainFrame = mainFrame;
        changeButtonState(false, true, false, false);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String valid = ExpenditureTypeValidator.validate(txtName);
                    if ((valid != null)) {
                        MessageBox.showErrorMessage(null,  "Error", valid);
                        return;
                    }
                    ReceiptType entity = new ReceiptType();
                    entity.setName(txtName.getText());
                    ReceiptTypeDAO dao = new ReceiptTypeDAO();
                    entity = dao.insert(entity);
                    txtID.setText("" + entity.getId());
                    MessageBox.showInfomationMessage(null, "Infomation", "Type is saved!");
                    txtID.setEditable(false);
                    txtName.setEditable(false);
                    changeButtonState(true, false, true,true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    MessageBox.showErrorMessage(null, "Error", ex.getMessage());
                }
            }
        });
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtID.setText("");
                txtName.setText("");
                changeButtonState(false, true, false, false);
                txtName.setEditable(true);
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtName.setEditable(true);
                changeButtonState(true, false,true,true);
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (MessageBox.showConfirmMessage(null, "Do you want to update?")==JOptionPane.NO_OPTION) {
                        return;
                    }
                    String valid = ExpenditureTypeValidator.validate(txtName);
                    if ((valid != null)) {
                        MessageBox.showErrorMessage(null,  "Error", valid);
                        return;
                    }
                    ReceiptType entity = new ReceiptType();
                    entity.setId(Integer.parseInt(txtID.getText()));
                    entity.setName(txtName.getText());
                    ReceiptTypeDAO dao = new ReceiptTypeDAO();
                    entity = dao.update(entity);
                    txtID.setText("" + entity.getId());
                    MessageBox.showInfomationMessage(null, "Infomation", "Type is updated!");
                    txtID.setEditable(false);
                    txtName.setEditable(false);
                    changeButtonState(true, false, false,false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    MessageBox.showErrorMessage(null, "Error", ex.getMessage());
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
                    String valid = ExpenditureTypeValidator.validate(txtName);
                    if ((valid != null)) {
                        MessageBox.showErrorMessage(null,  "Error", valid);
                        return;
                    }
                    int id = Integer.parseInt(txtID.getText());
                    ReceiptTypeDAO dao = new ReceiptTypeDAO();
                    if (dao.delete(id)) {
                        MessageBox.showInfomationMessage(null, "Infomation", "Type is deleted!");
                    }
                    else {
                        MessageBox.showErrorMessage(null, "Infomation", "Type cannot deleted!");
                    }
                    txtID.setText("");
                    txtName.setText("");
                    txtName.setEditable(true);
                    changeButtonState(false, true, false,false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    MessageBox.showErrorMessage(null, "Error", ex.getMessage());
                }
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showListReceiptType();
            }
        });
    }

    public AddReceiptTypePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        changeButtonState(false, true, false, false);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String valid = ExpenditureTypeValidator.validate(txtName);
                    if ((valid != null)) {
                        MessageBox.showErrorMessage(null,  "Error", valid);
                        return;
                    }
                    ReceiptType entity = new ReceiptType();
                    entity.setName(txtName.getText());
                    ReceiptTypeDAO dao = new ReceiptTypeDAO();
                    entity = dao.insert(entity);
                    txtID.setText("" + entity.getId());
                    MessageBox.showInfomationMessage(null, "Infomation", "Type is saved!");
                    txtID.setEditable(false);
                    txtName.setEditable(false);
                    changeButtonState(true, false, true,true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    MessageBox.showErrorMessage(null, "Error", ex.getMessage());
                }
            }
        });
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtID.setText("");
                txtName.setText("");
                changeButtonState(false, true, false, false);
                txtName.setEditable(true);
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtName.setEditable(true);
                changeButtonState(true, false,true,true);
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (MessageBox.showConfirmMessage(null, "Do you want to update?")==JOptionPane.NO_OPTION) {
                        return;
                    }
                    String valid = ExpenditureTypeValidator.validate(txtName);
                    if ((valid != null)) {
                        MessageBox.showErrorMessage(null,  "Error", valid);
                        return;
                    }
                    ReceiptType entity = new ReceiptType();
                    entity.setId(Integer.parseInt(txtID.getText()));
                    entity.setName(txtName.getText());
                    ReceiptTypeDAO dao = new ReceiptTypeDAO();
                    entity = dao.update(entity);
                    txtID.setText("" + entity.getId());
                    MessageBox.showInfomationMessage(null, "Infomation", "Type is updated!");
                    txtID.setEditable(false);
                    txtName.setEditable(false);
                    changeButtonState(true, false, false,false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    MessageBox.showErrorMessage(null, "Error", ex.getMessage());
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
                    String valid = ExpenditureTypeValidator.validate(txtName);
                    if ((valid != null)) {
                        MessageBox.showErrorMessage(null,  "Error", valid);
                        return;
                    }
                    int id = Integer.parseInt(txtID.getText());
                    ReceiptTypeDAO dao = new ReceiptTypeDAO();
                    if (dao.delete(id)) {
                        MessageBox.showInfomationMessage(null, "Infomation", "Type is deleted!");
                    }
                    else {
                        MessageBox.showErrorMessage(null, "Infomation", "Type cannot deleted!");
                    }
                    txtID.setText("");
                    txtName.setText("");
                    txtName.setEditable(true);
                    changeButtonState(false, true, false,false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    MessageBox.showErrorMessage(null, "Error", ex.getMessage());
                }
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showListReceiptType();
            }
        });
    }
    public JPanel getPanelAddReceiptType() {
        return panelAddReceiptType;
    }

    public void setPanelAddReceiptType(JPanel panelAddReceiptType) {
        this.panelAddReceiptType = panelAddReceiptType;
    }


}
