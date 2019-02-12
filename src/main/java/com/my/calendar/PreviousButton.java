package com.my.calendar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class PreviousButton extends JButton implements ChangeDate, ActionListener {

    LocalDate date = LocalDate.now();
    public PreviousButton(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void updateDate() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            date = date.minusDays(1);
            Controller.getInstance().textViewButton.setText(date.toString());
        }
    }
}
