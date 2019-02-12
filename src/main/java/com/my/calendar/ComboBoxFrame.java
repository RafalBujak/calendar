package com.my.calendar;


import javax.swing.*;

public class ComboBoxFrame extends JComboBox implements ChangeView {

    private String[] changeView = {"Week", "month"};

    public ComboBoxFrame() {
       addItem(changeView[0]);
       addItem(changeView[1]);
    }

    @Override
    public void updateView() {

    }
}
