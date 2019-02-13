package com.my.calendar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class PreviousButton extends JButton implements ChangeDate, ActionListener {

    private LocalDate date = LocalDate.now();
    public PreviousButton(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void updateDate() {
        Controller.getInstance().textViewField.setText(Controller.getInstance().localDate.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            Controller.getInstance().localDate = Controller.getInstance().localDate.minusDays(1);
            Controller.getInstance().notifyChangeDate();
            updateDate();
        }
    }
}
