package com.my.calendar.frameview;

import com.my.calendar.ChangeView;
import com.my.calendar.comboboxframe.ComboBoxFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.my.calendar.controller.Controller.*;


public class DaysButtonsView extends JPanel implements ChangeView, ActionListener, MouseListener {
    private List<JButton> weekView = new ArrayList<>();

    public DaysButtonsView() {
    }

    public void createWeekOrMonthButtonsView() {

        removeAll();
        revalidate();
        weekView.clear();

        LocalDate localDate = getInstance().localDate;

        int days = getInstance().getMonthDays();
        System.out.println(days);
        for (int i = 0; i < days; i++) {
            System.out.println("jestem w for " + i);
            weekView.add(new JButton(String.valueOf(localDate.plusDays(i))));
//            int finalI = i;
//            weekView.get(i).addActionListener(e -> weekView.get(finalI).setBackground(Color.red));
        }
        weekView.forEach(this::add);
        weekView.get(0).setBackground(Color.gray);
        updateUI();
        revalidate();

    }



    @Override
    public void updateView() {

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
