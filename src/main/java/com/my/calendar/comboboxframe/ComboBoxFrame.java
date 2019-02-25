package com.my.calendar.comboboxframe;

import javax.swing.*;
import java.awt.event.ActionListener;

import static com.my.calendar.enumclasses.CurrentView.*;
import static com.my.calendar.controller.Controller.*;

public class ComboBoxFrame extends JComboBox implements ActionListener {

    public ComboBoxFrame() {

        addItem(WEEK);
        addItem(MONTH);

        addActionListener(event -> {
            if (WEEK.name().equals(getSelectedItem().toString())) {
                getInstance().setDate(7);
            } else if (MONTH.name().equals(getSelectedItem().toString())) {
                getInstance().setDate(getInstance().getLocalDate().lengthOfMonth());
            }
        });
    }
}
