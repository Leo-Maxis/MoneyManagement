package org.collection.tabs;

import javax.swing.*;
import java.awt.*;

public class ListExpenditurePanel extends Component {
    private JTable tblList;
    private JPanel panelListExpenditure;

    public JTable getTblList() {
        return tblList;
    }

    public void setTblList(JTable tblList) {
        this.tblList = tblList;
    }

    public JPanel getPanelListExpenditure() {
        return panelListExpenditure;
    }

    public void setPanelListExpenditure(JPanel panelListExpenditure) {
        this.panelListExpenditure = panelListExpenditure;
    }
}
