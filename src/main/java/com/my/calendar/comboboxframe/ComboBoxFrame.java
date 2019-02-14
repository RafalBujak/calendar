package com.my.calendar.comboboxframe;


import com.my.calendar.ChangeView;
import com.my.calendar.controller.Controller;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class ComboBoxFrame extends JComboBox implements ChangeView, ItemListener {


    private enum changeView {
        WEEK, MONTH
    }

    public ComboBoxFrame() {
        addItem(changeView.WEEK);
        addItem(changeView.MONTH);
        addItemListener(this);
    }


    @Override
    public void updateView() {
        Controller.getInstance().setMonthDays(7);
    }

    @Override
    public void itemStateChanged(ItemEvent event) {

        if (event.getItem().equals(changeView.WEEK)) {
            System.out.println("czy dziala");
        } else if (event.getItem() == changeView.MONTH){
            System.out.println(" nie działa");
        }

    }
}
