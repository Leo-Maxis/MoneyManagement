package org.collection.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AboutUsDialog {
    private JButton closeButton;
    private JPanel panelAboutUs;
    JFrame frameAboutUs = new JFrame("About Us");


    public AboutUsDialog() {
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                frameAboutUs.setContentPane(new AboutUsDialog().panelAboutUs);
//                frameAboutUs.setVisible(false);
                frameAboutUs.dispose();
            }
        });
//        closeButton.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if(e.getClickCount() == 1) {
//                    frameAboutUs.dispose();
//                    frameAboutUs.setVisible(false);
//                }
//            }
//        });
    }

    public void getAboutUsDialog() {
        frameAboutUs.setContentPane(new AboutUsDialog().panelAboutUs);
        frameAboutUs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameAboutUs.pack();
        frameAboutUs.setVisible(true);
        frameAboutUs.setLocationRelativeTo(null);
        frameAboutUs.setSize(500, 250);
    }

//    public JButton getCloseButton() {
//        return closeButton;
//    }
//
//    public void setCloseButton(JButton closeButton) {
//        this.closeButton = closeButton;
//    }
//
//    public JPanel getPanelAboutUs() {
//        return panelAboutUs;
//    }
//
//    public void setPanelAboutUs(JPanel panelAboutUs) {
//        this.panelAboutUs = panelAboutUs;
//    }
}
