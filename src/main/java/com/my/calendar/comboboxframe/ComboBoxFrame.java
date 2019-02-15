package com.my.calendar.comboboxframe;


import com.my.calendar.ChangeView;
import com.my.calendar.controller.Controller;
import com.my.calendar.frameview.DaysButtonsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;


public class ComboBoxFrame extends JComboBox implements ChangeView, ActionListener {


    private int localDate = LocalDate.now().getDayOfMonth();

    private enum changeView {
        WEEK, MONTH
    }

    public ComboBoxFrame() {


        addItem(changeView.WEEK);
        addItem(changeView.MONTH);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(getSelectedItem().toString());
                if (getSelectedItem().toString().equals("WEEK")) {

                    System.out.println("tydzien");
                    System.out.println(Controller.getInstance().getMonthDays());
                    add(new Button("test"));
                } else if (getSelectedItem().toString().equals("MONTH")) {

                    System.out.println("miesiac");
                    System.out.println(Controller.getInstance().getMonthDays());
                    add(new Button("test2"), FlowLayout.CENTER);
                    updateUI();
                }
            }
        });

    }


    @Override
    public void updateView() {
        // Controller.getInstance().setMonthDays(7);
    }

}
