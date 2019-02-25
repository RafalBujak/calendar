package com.my.calendar.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.my.calendar.controller.Controller.*;

public class PreviousButton extends JButton implements ActionListener {

    public PreviousButton(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this) {
            getInstance().updateDateViewPreviousButton();
        }
    }
}
