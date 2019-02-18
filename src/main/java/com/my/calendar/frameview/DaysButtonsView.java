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


    private int days = 31;
    public DaysButtonsView() {
    }

    @Override
    public void updateView() {

    }

    JButton[] buttons = Controller.getInstance().buttons;

    //TODO
    //add value to argument from controller
    public void createButton(int days) {

        this.days = days;

        System.out.println("teraz jestem w metodzie create button");

        LocalDate localDate = Controller.getInstance().localDate;
        for (int i = 0; i < buttons.length; ++i)
        {
            JButton btn = new JButton(String.valueOf(localDate.plusDays(i)));

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    btn.setBackground(Color.red);
                }
            });
            add(btn);
            buttons[i] = btn;
        }
        buttons[0].setBackground(Color.gray);
        revalidate();
        repaint();
        updateUI();
        System.out.println("teraz koncze prace z ta metoda");
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
