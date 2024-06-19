package org.collection.Main;

import org.collection.dialogform.AboutUsDialog;
import org.collection.dialogform.LoginDialog;
import org.collection.dialogform.SettingsDialog;
import org.collection.tabs.AddExpenditurePanel;
import org.collection.tabs.AddNewReceiptPanel;
import org.collection.tabs.ListExpenditurePanel;
import org.collection.tabs.ListReceiptPanel;

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

    static JFrame frame = new JFrame("Mainframe");

    public MainFrame() {
        addExpenditureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel addExpenditurePanel = new AddExpenditurePanel().getPanelAddExpenditure();
                tpnBoard.addTab("Add Expenditure", addExpenditurePanel);
                tpnBoard.setSelectedComponent(addExpenditurePanel);
            }
        });

        mnAddNewExpenditure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel addExpenditurePanel = new AddExpenditurePanel().getPanelAddExpenditure();
                tpnBoard.addTab("Add Expenditure", addExpenditurePanel);
                tpnBoard.setSelectedComponent(addExpenditurePanel);
            }
        });
        listExpenditureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel listExpenditurePanel = new ListExpenditurePanel().getPanelListExpenditure();
                tpnBoard.addTab("List Expenditure", listExpenditurePanel);
                tpnBoard.setSelectedComponent(listExpenditurePanel);
            }
        });
        mnListExpenditure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel listExpenditurePanel = new ListExpenditurePanel().getPanelListExpenditure();
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
