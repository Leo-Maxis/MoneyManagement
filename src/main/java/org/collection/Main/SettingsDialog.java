package org.collection.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsDialog {
    private JTabbedPane tabbedPane1;
    private JButton closeButton;
    private JComboBox comboBox1;
    private JTextField localhostTextField;
    private JTextField saTextField;
    private JPasswordField a123qwePasswordField;
    private JPanel panelSettings;

    private static JFrame settingsFrame = new JFrame("Settings");

    public SettingsDialog() {
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsFrame.dispose();
            }
        });
    }

    public void getSettingsDialog() {
        settingsFrame.setContentPane(new SettingsDialog().panelSettings);
        settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settingsFrame.setVisible(true);
        settingsFrame.pack();
        settingsFrame.setLocationRelativeTo(null);
        settingsFrame.setSize(500, 250);
    }

}
