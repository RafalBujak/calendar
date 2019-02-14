package com.my.calendar.frameview;

import com.my.calendar.ChangeView;
import com.my.calendar.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class ViewDaysButtons extends JPanel implements ChangeView {

    private int days;

    public ViewDaysButtons(int days) {
        this.days = days;

        setLayout(new GridLayout(5, 7));
        for (int i = 0; i <= days; i++) {
            LocalDate localDate = Controller.getInstance().localDate;
            add(new JButton(String.valueOf(localDate.plusDays(i))));
        }
    }

    @Override
    public void updateView() {

    }
}
