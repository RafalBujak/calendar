package com.MyCalendar;


import javax.swing.*;

public class ComboBoxFrame extends JComboBox implements ChangeView {

    private String[] changeView = {"Week", "month"};

    public JComboBox createComboBox() {
        JComboBox comboBox = new JComboBox(changeView);
        return comboBox;
    }

    @Override
    public void updateView() {

    }
}
