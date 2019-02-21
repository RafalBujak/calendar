package com.my.calendar.comboboxframe;

import com.my.calendar.ViewObserver;

import javax.swing.*;
import java.awt.event.ActionListener;

import static com.my.calendar.additionalfunctions.CurrentView.*;
import static com.my.calendar.controller.Controller.*;

public class ComboBoxFrame extends JComboBox implements ViewObserver, ActionListener {

    public ComboBoxFrame() {

        addItem(WEEK);
        addItem(MONTH);

        addActionListener(event -> {
            if (WEEK.name().equals(getSelectedItem().toString())) {
                getInstance().setCurrentDayValue(7);
            } else if (MONTH.name().equals(getSelectedItem().toString())) {
                getInstance().setCurrentDayValue(getInstance().getLocalDate().lengthOfMonth());
            }
        });
    }

    @Override
    public void updateView() {  }
}
