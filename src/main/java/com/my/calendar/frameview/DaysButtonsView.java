package com.my.calendar.frameview;

import com.my.calendar.ChangeView;
import com.my.calendar.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;


public class DaysButtonsView extends JPanel implements ChangeView, ActionListener, MouseListener {

    public DaysButtonsView() {
    }

    @Override
    public void updateView() {

    }


    private JButton[] buttons = Controller.getInstance().buttons;

    //TODO
    //add new methods which make week array of button and month array of buttons

    public void createButtonOnStartApplication() {


        revalidate();
        LocalDate localDate = Controller.getInstance().localDate;
        for (int i = 0; i < buttons.length; i++)
        {
            JButton btn = new JButton(String.valueOf(localDate.plusDays(i)));
            btn.addActionListener(event -> btn.setBackground(Color.red));
            add(btn);
            buttons[i] = btn;
        }
        buttons[0].setBackground(Color.gray);


        repaint();
        updateUI();
    }

    public void buttonWeek() {
        JButton week = new JButton("week");
        add(week);
        week.setVisible(true);

    }

    public void buttonMonth() {
        add(new JButton("Month"));
    }

    @Override
    public void actionPerformed(ActionEvent event) {

    }


    @Override
    public void mouseClicked(MouseEvent event) {

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
