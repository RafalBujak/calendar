package com.my.calendar.comboboxframe;


import com.my.calendar.ChangeView;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboBoxFrame extends JComboBox implements ChangeView, ItemListener {

    private enum changeView{
       WEEK, MONTH
    }
    public ComboBoxFrame() {
        addItem(changeView.WEEK);
        addItem(changeView.MONTH);
        addItemListener(this);
    }

    @Override
    public void updateView() {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (changeView.WEEK.equals(changeView.WEEK)) {
            //TODO
            //implement new view when is ready
        } else {

        }

    }
}
