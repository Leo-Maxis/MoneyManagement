package org.collection;

import org.collection.tabs.AddExpenditurePanel;

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
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mainframe");
        frame.setContentPane(new MainFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(650, 450);
    }
}
