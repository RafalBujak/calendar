package com.my.calendar.comboboxframe;

import com.my.calendar.ChangeView;
import com.my.calendar.frameview.DaysButtonsView;

import javax.swing.*;
import java.awt.event.ActionListener;

import static com.my.calendar.controller.Controller.*;

public class ComboBoxFrame extends JComboBox implements ChangeView, ActionListener {

    private DaysButtonsView daysButtonsView = new DaysButtonsView();

    public enum changeView {
        WEEK, MONTH
    }

    public ComboBoxFrame() {

        addItem(changeView.WEEK);
        addItem(changeView.MONTH);

        addActionListener(e -> {
            if (getSelectedItem().toString().equals("WEEK")) {
                getInstance().setMonthDays(7);
                getInstance().notifyChangeView();
            } else if (getSelectedItem().toString().equals("MONTH")) {
                getInstance().setMonthDays(getInstance().localDate.lengthOfMonth());
                getInstance().notifyChangeView();
            }
        });
    }

    @Override
    public void updateView() {

    }
}
