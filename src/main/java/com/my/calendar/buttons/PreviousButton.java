package com.my.calendar.buttons;

import com.my.calendar.ChangeDate;
import com.my.calendar.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PreviousButton extends JButton implements ChangeDate, ActionListener {

    public PreviousButton(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void updateDate() {
        Controller.getInstance().textViewField.setText(Controller.getInstance().localDate.toString());
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this) {
            Controller.getInstance().localDate = Controller.getInstance().localDate.minusDays(1);
            Controller.getInstance().notifyChangeDate();
            updateDate();
        }
    }
}
