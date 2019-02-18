package com.my.calendar.buttons;

import com.my.calendar.additionalfunctions.ButtonBackgroundWizard;
import com.my.calendar.ChangeDate;
import com.my.calendar.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NextButton extends JButton implements ChangeDate, ActionListener {

    private ButtonBackgroundWizard background = new ButtonBackgroundWizard();

    public NextButton(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void updateDate() {
        Controller.getInstance().textViewField.setText(Controller.getInstance().localDate.toString());
    }

    //TODO
    //
    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == this) {
            Controller.getInstance().localDate = Controller.getInstance().localDate.plusDays(1);

            Controller.getInstance().notifyChangeDate();

            background.buttonNextCreatingBackgroundOfButtons();


            updateDate();

        }
    }
}
