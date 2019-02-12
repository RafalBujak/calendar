package com.my.calendar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class TextViewButton extends JTextField implements ChangeDate, ActionListener {


    public TextViewButton(LocalDate date) {
        super(date.toString());
        addActionListener(this);
    }

    @Override
    public void updateDate() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            LocalDate date = LocalDate.parse(listenerList.toString());
            date.toString();
        }
    }
}
