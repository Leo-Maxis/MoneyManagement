package org.collection.Main.validator;

import javax.swing.*;
import java.awt.*;

public class Validator {
    public static boolean isEmpty(JComponent component) {
        if (component instanceof JTextField) {
            JTextField txt = (JTextField) component;
            if (txt.getText().equals("")) {
                txt.setBackground(Color.YELLOW);
                return true;
            }
            else {
                txt.setBackground(Color.WHITE);
            }
        }
        return  false;
    }
}
