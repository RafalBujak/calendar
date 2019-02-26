package com.my.calendar.textfields;

import com.my.calendar.DateObserver;
import com.my.calendar.ViewObserver;
import com.my.calendar.controller.Controller;
import com.my.calendar.date.DateFormatter;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

public class TextViewField extends JTextField implements ViewObserver, DateObserver, MouseListener {

    private Controller controller = Controller.getInstance();
    private DateFormatter formatter = new DateFormatter();
    public TextViewField(LocalDate localDate) {
        super(localDate.toString());
        addMouseListener(this);
        controller.addChangeDateObservers(this);
        controller.addViewObservers(this);
    }

    @Override
    public void updateDate() {
        setText(controller.getLocalDate().toString());
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if (event.getSource() == this) {
            formatter.setLocalDateFromInputDialog();
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

    @Override
    public void updateView(int days) {

    }
}
