package com.my.calendar.textfields;

import com.my.calendar.DateObserver;
import com.my.calendar.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class TextViewField extends JTextField implements DateObserver, ActionListener {

    public TextViewField(LocalDate localDate) {
        super(localDate.toString());
        addActionListener(this);
        Controller.getInstance().addChangeDateObservers(this);
    }

    @Override
    public void updateDate() { inputNewDate(); }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this) {
            Controller.getInstance().setLocalDateFromInputDialog();
            Controller.getInstance().notifyChangeView();
        }
    }

    private void inputNewDate() {
        setText(Controller.getInstance().getLocalDate().toString());
    }
}
