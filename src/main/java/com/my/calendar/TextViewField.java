package com.my.calendar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TextViewField extends JTextField implements ChangeDate, ActionListener {


    private String reciveDate;

    public TextViewField(LocalDate date) {
        super(date.toString());
        addActionListener(this);
    }

    @Override
    public void updateDate() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            //LocalDate date = LocalDate.parse(listenerList.toString());
            //date.toString();
            //TODO
            /*
            try move logic to updateDate method
             */
            reciveDate = JOptionPane.showInputDialog("Ask?", Controller.getInstance().localDate.toString());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(reciveDate, formatter);
            Controller.getInstance().setLocalDate(date);
            Controller.getInstance().notifyChangeDate();
            updateDate();
        }
    }
}
