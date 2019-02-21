package com.my.calendar.textfields;

import com.my.calendar.DateObserver;
import com.my.calendar.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import static com.my.calendar.controller.Controller.getInstance;

public class TextViewField extends JTextField implements DateObserver, ActionListener {
    
    public TextViewField(LocalDate date) {
        super(date.toString());
        addActionListener(this);
        getInstance().addChangeDateObservers(this);
    }

    @Override
    public void updateDate() { }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this) {
            Controller.getInstance().setLocalDate();
        }
    }
}
