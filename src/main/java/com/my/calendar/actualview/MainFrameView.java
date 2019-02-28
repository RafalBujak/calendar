package com.my.calendar.actualview;

import com.my.calendar.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainFrameView extends JFrame {

    public MainFrameView() {

        JFrame calendarFrame = new JFrame("Calendar");
        calendarFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        calendarFrame.setSize(900, 600);
        calendarFrame.setLocation(50, 50);
        calendarFrame.setLayout(new BorderLayout());

        NavigationView navigationButtonView = new NavigationView();
        calendarFrame.getContentPane().add(navigationButtonView, BorderLayout.PAGE_START);
        CurrentDaysView buttonsView = new CurrentDaysView();
        buttonsView.currentViewDays(Controller.getInstance().setCurrentDaysView());
        calendarFrame.getContentPane().add(buttonsView, BorderLayout.CENTER);
        calendarFrame.setVisible(true);
    }
}
