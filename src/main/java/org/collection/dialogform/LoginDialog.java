package org.collection.dialogform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDialog extends JDialog {
    private JButton btnClose;
    private JButton btnLogin;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JCheckBox chbRememberMe;
    private JPanel loginPanel;

    private  static JDialog loginDialog = new LoginDialog();


    public LoginDialog() {
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void getLoginDialog() {
        loginDialog.getContentPane().add(loginPanel);
        loginDialog.pack();
        loginDialog.setVisible(true);
        loginDialog.setSize(400, 250);
        loginDialog.setLocationRelativeTo(null);
    }
}
