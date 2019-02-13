package com.my.calendar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NextButton extends JButton implements ChangeDate, ActionListener {

    public NextButton(String name) {
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
            Controller.getInstance().localDate = Controller.getInstance().localDate.plusDays(1);

            Controller.getInstance().notifyChangeDate();
            updateDate();
        }
    }
}
