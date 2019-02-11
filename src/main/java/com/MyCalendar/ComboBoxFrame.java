package com.MyCalendar;


import javax.swing.*;

public class ComboBoxFrame extends JComboBox {

    private String[] changeView = {"Week", "month"};

    public JComboBox createComboBox() {
        JComboBox comboBox = new JComboBox(changeView);
        return comboBox;
    }

}
