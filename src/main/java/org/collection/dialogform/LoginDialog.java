package org.collection.dialogform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDialog {
    private JButton btnClose;
    private JButton btnLogin;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JCheckBox chbRememberMe;
    private JPanel loginPanel;

    private  static JFrame loginDialog = new JFrame();

    public JButton getBtnClose() {
        return btnClose;
    }

    public void setBtnClose(JButton btnClose) {
        this.btnClose = btnClose;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(JButton btnLogin) {
        this.btnLogin = btnLogin;
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(JTextField txtUsername) {
        this.txtUsername = txtUsername;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(JPasswordField txtPassword) {
        this.txtPassword = txtPassword;
    }

    public JCheckBox getChbRememberMe() {
        return chbRememberMe;
    }

    public void setChbRememberMe(JCheckBox chbRememberMe) {
        this.chbRememberMe = chbRememberMe;
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }

    public void setLoginPanel(JPanel loginPanel) {
        this.loginPanel = loginPanel;
    }

    public static void setLoginDialog(JFrame loginDialog) {
        LoginDialog.loginDialog = loginDialog;
    }

    public LoginDialog() {
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = txtPassword.getText();
                if(username.equals("admin") && password.equals("123")) {
                    loginDialog.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void getLoginDialog() {
        JDialog frameLogin = new JDialog(loginDialog,"Login", Dialog.ModalityType.APPLICATION_MODAL);
        frameLogin.getContentPane().add(loginPanel);
        frameLogin.pack();
        frameLogin.setVisible(true);
        frameLogin.setLocationRelativeTo(null);
        frameLogin.setSize(400,250);
    }

}
