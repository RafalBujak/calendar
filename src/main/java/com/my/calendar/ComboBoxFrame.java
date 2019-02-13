package com.my.calendar;


import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboBoxFrame extends JComboBox implements ChangeView, ItemListener {

    private String[] changeView = {"Week", "month"};

    public ComboBoxFrame() {
       addItem(changeView[0]);
       addItem(changeView[1]);
       addItemListener(this);
    }

    @Override
    public void updateView() {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.equals(changeView[0].equals("Week"))) {
            //TODO
            //implement new view when is ready
        } else {

        }
    }
}
