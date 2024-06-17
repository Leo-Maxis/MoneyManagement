package org.collection.tabs;

import javax.swing.*;
import java.awt.*;

public class AddExpenditurePanel extends Component {
    private JTextField textField1;
    private JTextField textField2;
    private JFormattedTextField formattedTextField1;
    private JComboBox comboBox1;
    private JTextArea textArea1;
    private JFormattedTextField formattedTextField2;
    private JPanel panelAddExpenditure;

    public void frameLayout() {
        JFrame frame = new JFrame("AddExpenditure");
        frame.setContentPane(new AddExpenditurePanel().panelAddExpenditure);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 350);
    }

}
