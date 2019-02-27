package com.my.calendar.buttons;

import com.my.calendar.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviousButton extends JButton implements ActionListener {

    private Controller controller = Controller.getInstance();
    public PreviousButton(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        controller.getCurrentView().previousButtonFunctionality();
    }
}
