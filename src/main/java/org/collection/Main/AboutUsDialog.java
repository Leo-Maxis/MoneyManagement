package org.collection.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AboutUsDialog extends Component {
    private JButton closeButton;
    private JPanel panelAboutUs;
    JFrame frame = new JFrame("About Us");


    public AboutUsDialog() {
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new AboutUsDialog().panelAboutUs);
//               frame.setContentPane(closeButton);
//               frame.dispose();
               frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSED));
            }
        });
    }

    public void AboutUsDialog() {
        frame.setContentPane(new AboutUsDialog().panelAboutUs);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 250);
    }

    public JButton getCloseButton() {
        return closeButton;
    }

    public void setCloseButton(JButton closeButton) {
        this.closeButton = closeButton;
    }

    public JPanel getPanelAboutUs() {
        return panelAboutUs;
    }

    public void setPanelAboutUs(JPanel panelAboutUs) {
        this.panelAboutUs = panelAboutUs;
    }
}
