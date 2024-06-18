package org.collection.tabs;

import javax.swing.*;
import java.awt.*;

public class ListReceiptPanel extends Component {
    private JPanel panelListReceipt;
    private JTable tblList;

    public JPanel getPanelListReceipt() {
        return panelListReceipt;
    }

    public void setPanelListReceipt(JPanel panelListExpenditure) {
        this.panelListReceipt = panelListExpenditure;
    }

    public JTable getTblList() {
        return tblList;
    }

    public void setTblList(JTable tblList) {
        this.tblList = tblList;
    }
}
