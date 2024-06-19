package org.collection.Main.validator;

import org.collection.util.MessageBox;

import javax.swing.*;
import java.awt.*;

public class ExpenditureTypeValidator {
    public static String validate(JTextField txtName) {
        StringBuilder sb = new StringBuilder();
        if (Validator.isEmpty(txtName)) {
            sb.append("Name must be entered");
        }
        return sb.isEmpty() ? null : sb.toString();
    }
}
