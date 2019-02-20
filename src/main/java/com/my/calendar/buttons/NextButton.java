package com.my.calendar.buttons;

import com.my.calendar.additionalfunctions.ButtonBackgroundWizard;
import com.my.calendar.ChangeDate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.my.calendar.controller.Controller.*;


public class NextButton extends JButton implements ChangeDate, ActionListener {

    //private ButtonBackgroundWizard background = new ButtonBackgroundWizard();

    public NextButton(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void updateDate() {
        getInstance().textViewField.setText(getInstance().localDate.toString());
    }

    //TODO
    //
    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == this) {
            getInstance().localDate = getInstance().localDate.plusDays(1);

            getInstance().notifyChangeDate();

            //background.buttonNextCreatingBackgroundOfButtons();


            updateDate();

        }
    }
}
