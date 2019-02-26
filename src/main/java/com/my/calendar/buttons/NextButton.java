package com.my.calendar.buttons;

import com.my.calendar.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButton extends JButton implements ActionListener {

    public NextButton(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this) {
            Controller.getInstance().setLocalDate(Controller.getInstance().getLocalDate().plusWeeks(1));
        }
    }
}
