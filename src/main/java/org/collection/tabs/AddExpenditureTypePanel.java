package org.collection.tabs;

import org.collection.Main.MainFrame;
import org.collection.Main.validator.ExpenditureTypeValidator;
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

    private MainFrame mainFrame;

    private void changeButtonState(boolean edit, boolean save, boolean update, boolean delete) {
        btnEdit.setEnabled(edit);
        btnSave.setEnabled(save);
        btnUpdate.setEnabled(update);
        btnDelete.setEnabled(delete);
    }

    private void loadByID(int id) {
        try {
            ExpenditureTypeDAO dao = new ExpenditureTypeDAO();
            ExpenditureType entity = dao.findById(id);
            txtID.setText("" + entity.getId());
            txtName.setText(entity.getName());
            changeButtonState(true, false, true, true);
        } catch (Exception e) {
            MessageBox.showErrorMessage(null,"Error", e.getMessage());
        }
    }
    public AddExpenditureTypePanel(MainFrame mainFrame, int id) {
        this.mainFrame = mainFrame;
        loadByID(id);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String valid = ExpenditureTypeValidator.validate(txtName);
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
                changeButtonState(true, false,true,true);
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
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (MessageBox.showConfirmMessage(null, "Do you want to update?")==JOptionPane.NO_OPTION) {
                        return;
                    }
                    String valid = ExpenditureTypeValidator.validate(txtName);
                    if (valid!=null) {
                        MessageBox.showErrorMessage(null, "Error", valid);
                        return;
                    }
                    ExpenditureType entity = new ExpenditureType();
                    entity.setId(Integer.parseInt(txtID.getText()));
                    entity.setName(txtName.getText());
                    ExpenditureTypeDAO dao = new ExpenditureTypeDAO();
                    entity = dao.update(entity);
                    MessageBox.showInfomationMessage(null, "Infomation","Type is updated!!");
                    txtID.setEditable(false);
                    txtName.setEditable(false);
                    changeButtonState(true, false, false, true);
                } catch (Exception exception) {
//                    JOptionPane.showMessageDialog(null, "Error: " + exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                    ExpenditureTypeDAO dao = new ExpenditureTypeDAO();
                    int id = Integer.parseInt(txtID.getText());
                    if (dao.delete(id)) {
                        MessageBox.showInfomationMessage(null, "Infomation","Type is deleted!");
                    }
                    else  {
                        MessageBox.showErrorMessage(null, "Error", "Typed can not be deleted!");
                    }
                    txtID.setText("");
                    txtName.setText("");
                    changeButtonState(false, true, false, false);
                    txtName.setEditable(true);
                } catch (Exception exception) {
//                    JOptionPane.showMessageDialog(null, "Error: " + exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                    MessageBox.showErrorMessage(null, "Error", exception.getMessage());
                }
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showListExpenditureTypes();
            }
        });
    }

    public AddExpenditureTypePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        changeButtonState(false, true, false, false);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String valid = ExpenditureTypeValidator.validate(txtName);
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
                changeButtonState(true, false,true,true);
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
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (MessageBox.showConfirmMessage(null, "Do you want to update?")==JOptionPane.NO_OPTION) {
                        return;
                    }
                    String valid = ExpenditureTypeValidator.validate(txtName);
                    if (valid!=null) {
                        MessageBox.showErrorMessage(null, "Error", valid);
                        return;
                    }
                    ExpenditureType entity = new ExpenditureType();
                    entity.setId(Integer.parseInt(txtID.getText()));
                    entity.setName(txtName.getText());
                    ExpenditureTypeDAO dao = new ExpenditureTypeDAO();
                    entity = dao.update(entity);
                    MessageBox.showInfomationMessage(null, "Infomation","Type is updated!!");
                    txtID.setEditable(false);
                    txtName.setEditable(false);
                    changeButtonState(true, false, false, true);
                } catch (Exception exception) {
//                    JOptionPane.showMessageDialog(null, "Error: " + exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                    ExpenditureTypeDAO dao = new ExpenditureTypeDAO();
                    int id = Integer.parseInt(txtID.getText());
                    if (dao.delete(id)) {
                        MessageBox.showInfomationMessage(null, "Infomation","Type is deleted!");
                    }
                    else  {
                        MessageBox.showErrorMessage(null, "Error", "Typed can not be deleted!");
                    }
                    txtID.setText("");
                    txtName.setText("");
                    changeButtonState(false, true, false, false);
                    txtName.setEditable(true);
                } catch (Exception exception) {
//                    JOptionPane.showMessageDialog(null, "Error: " + exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                    MessageBox.showErrorMessage(null, "Error", exception.getMessage());
                }
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showListExpenditureTypes();
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
