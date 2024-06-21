package org.collection.Main;

import org.collection.dialogform.AboutUsDialog;
import org.collection.dialogform.LoginDialog;
import org.collection.dialogform.SettingsDialog;
import org.collection.tabs.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    private JButton addExpenditureButton;
    private JButton listExpenditureButton;
    private JButton addReceiptButton;
    private JButton listReceiptButton;
    private JButton lockButton;
    private JTabbedPane tpnBoard;
    private JMenuItem mnContent;
    private JMenuItem mnAboutus;
    private JMenuItem mnAddNewExpenditure;
    private JMenuItem mnListExpenditure;
    private JMenuItem mnAddNewReceipt;
    private JMenuItem mnListReceipt;
    private JMenuItem mnLogin;
    private JMenuItem mnLogout;
    private JMenuItem mnLockup;
    private JMenuItem mnSettings;
    private JMenuItem mnExit;
    private JPanel mainPanel;
    private JButton btnCloseTab;
    private JMenuItem mnAddExpenditureType;
    private JMenuItem mnListExpendiureType;
    private JMenuItem mnAddReceiptType;
    private JMenuItem mnListReceiptType;

    static JFrame frame = new JFrame("Mainframe");

    public MainFrame() {
        addExpenditureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel addExpenditurePanel = new AddExpenditurePanel(MainFrame.this).getPanelAddExpenditure();
                tpnBoard.addTab("Add Expenditure", addExpenditurePanel);
                tpnBoard.setSelectedComponent(addExpenditurePanel);
            }
        });

        mnAddNewExpenditure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel addExpenditurePanel = new AddExpenditurePanel(MainFrame.this).getPanelAddExpenditure();
                tpnBoard.addTab("Add Expenditure", addExpenditurePanel);
                tpnBoard.setSelectedComponent(addExpenditurePanel);
            }
        });
        listExpenditureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel listExpenditurePanel = new ListExpenditurePanel(MainFrame.this).getPanelListExpenditure();
                tpnBoard.addTab("List Expenditure", listExpenditurePanel);
                tpnBoard.setSelectedComponent(listExpenditurePanel);
            }
        });
        mnListExpenditure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel listExpenditurePanel = new ListExpenditurePanel(MainFrame.this).getPanelListExpenditure();
                tpnBoard.addTab("List Expenditure", listExpenditurePanel);
                tpnBoard.setSelectedComponent(listExpenditurePanel);
            }
        });
        addReceiptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel addNewReceiptPanel = new AddNewReceiptPanel().getPanelAddReceipt();
                tpnBoard.addTab("Add New Receipt", addNewReceiptPanel);
                tpnBoard.setSelectedComponent(addNewReceiptPanel);
            }
        });
        mnAddNewReceipt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel addNewReceiptPanel = new AddNewReceiptPanel().getPanelAddReceipt();
                tpnBoard.addTab("Add New Receipt", addNewReceiptPanel);
                tpnBoard.setSelectedComponent(addNewReceiptPanel);
            }
        });
        listReceiptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel listReceiptPanel = new ListReceiptPanel().getPanelListReceipt();
                tpnBoard.addTab("Add New Receipt", listReceiptPanel);
                tpnBoard.setSelectedComponent(listReceiptPanel);
            }
        });
        mnListReceipt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel listReceiptPanel = new ListReceiptPanel().getPanelListReceipt();
                tpnBoard.addTab("Add New Receipt", listReceiptPanel);
                tpnBoard.setSelectedComponent(listReceiptPanel);
            }
        });
        btnCloseTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = tpnBoard.getSelectedIndex();
                if (selectedIndex > 0) {
                    tpnBoard.remove(selectedIndex);
                }
            }
        });
        mnAboutus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               AboutUsDialog aboutUsDialog = new AboutUsDialog();
               aboutUsDialog.getAboutUsDialog();
            }
        });
        mnSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SettingsDialog settingsDialog = new SettingsDialog();
                settingsDialog.getSettingsDialog();
            }
        });
        mnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginDialog loginDialog = new LoginDialog();
                loginDialog.getLoginDialog();

            }
        });
        mnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginDialog loginDialog = new LoginDialog();
                loginDialog.getLoginDialog();
            }
        });
        mnLockup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginDialog loginDialog = new LoginDialog();
                loginDialog.getLoginDialog();
            }
        });
        lockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginDialog loginDialog = new LoginDialog();
                loginDialog.getLoginDialog();
            }
        });
        mnAddExpenditureType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelAddExpenditureType = new AddExpenditureTypePanel(MainFrame.this).getPanelAddExpenditureType();
                tpnBoard.addTab("Add Expenditure Type",panelAddExpenditureType);
                tpnBoard.setSelectedComponent(panelAddExpenditureType);
            }
        });

        mnListExpendiureType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelListExpenditureType = new ListExpenditureTypePanel(MainFrame.this).getPanelListExpenditureType();
                tpnBoard.addTab("List Expenditure Type", panelListExpenditureType);
                tpnBoard.setSelectedComponent(panelListExpenditureType);
            }
        });
        mnAddReceiptType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelAddReceiptType = new AddReceiptTypePanel().getPanelAddReceiptType();
                tpnBoard.addTab("Add Receipt Type", panelAddReceiptType);
                tpnBoard.setSelectedComponent(panelAddReceiptType);
            }
        });
        mnListReceiptType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelListReceiptType = new ListReceiptTypePanel().getPanelListReceiptType();
                tpnBoard.addTab("List Receipt Type", panelListReceiptType);
                tpnBoard.setSelectedComponent(panelListReceiptType);
            }
        });
    }
    public void showListExpenditureTypes() {
        JPanel panelListExpenditureType = new ListExpenditureTypePanel(MainFrame.this).getPanelListExpenditureType();
        tpnBoard.addTab("List Expenditure Type", panelListExpenditureType);
        tpnBoard.setSelectedComponent(panelListExpenditureType);
    }

    public void showEditExpenditureTypes(int id) {
        JPanel panelAddExpenditureType = new AddExpenditureTypePanel(this, id).getPanelAddExpenditureType();
        tpnBoard.addTab("Edit Expenditure Type", panelAddExpenditureType);
        tpnBoard.setSelectedComponent(panelAddExpenditureType);
    }
    public void showListExpenditure() {
        JPanel listExpenditurePanel = new ListExpenditurePanel(MainFrame.this).getPanelListExpenditure();
        tpnBoard.addTab("List Expenditure", listExpenditurePanel);
        tpnBoard.setSelectedComponent(listExpenditurePanel);
    }
    public void showEditExpenditure(int id) {
        JPanel panelAddExpenditure = new AddExpenditurePanel(this, id).getPanelAddExpenditure();
        tpnBoard.addTab("Edit Expenditure Type", panelAddExpenditure);
        tpnBoard.setSelectedComponent(panelAddExpenditure);
    }

    public static void main(String[] args) {
        frame.setContentPane(new MainFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(950, 500);
        //Login form
        LoginDialog loginDialog = new LoginDialog();
        loginDialog.getLoginDialog();
    }
}
