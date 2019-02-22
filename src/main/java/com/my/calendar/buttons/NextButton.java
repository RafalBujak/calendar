package com.my.calendar.buttons;

import com.my.calendar.DateObserver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.my.calendar.controller.Controller.*;

public class NextButton extends JButton implements DateObserver, ActionListener {

    public NextButton(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void updateDate() {

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == this) {

            //getInstance().textViewField.setText(getInstance().getLocalDate().plusWeeks(1).toString());
           // textViewField.setTextViewField(getInstance().getLocalDate().plusWeeks(1).toString());
            getInstance().notifyChangeDate();
            updateDate();
        }
    }
}
