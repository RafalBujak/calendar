package com.my.calendar.textfields;

import com.my.calendar.DateObserver;
import com.my.calendar.controller.Controller;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

public class TextViewField extends JTextField implements DateObserver, MouseListener {

    public TextViewField(LocalDate localDate) {
        super(localDate.toString());
        addMouseListener(this);
        Controller.getInstance().addChangeDateObservers(this);
    }

    @Override
    public void updateDate() {
        inputNewDate();
    }

    private void inputNewDate() {
        setText(Controller.getInstance().getLocalDate().toString());
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if (event.getSource() == this) {
            Controller.getInstance().getFormatter().setLocalDateFromInputDialog();
            Controller.getInstance().notifyChangeView();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
