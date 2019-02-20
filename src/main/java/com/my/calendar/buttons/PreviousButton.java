package com.my.calendar.buttons;

import com.my.calendar.ChangeDate;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.my.calendar.controller.Controller.*;

public class PreviousButton extends JButton implements ChangeDate, ActionListener {

    public PreviousButton(String name) {
        super(name);
        addActionListener(this);
    }

    @Override
    public void updateDate() {
        getInstance().textViewField.setText(getInstance().localDate.toString());
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this) {
            getInstance().localDate = getInstance().localDate.minusDays(1);
            getInstance().notifyChangeDate();

            //background.buttonPreviousCreatingBackgroundOfButtons();
            updateDate();
        }
    }
}
