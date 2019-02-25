package com.my.calendar.frameview;

import javax.swing.*;
import java.awt.*;

public class MainCalendarFrameView extends JFrame {

    private final int DEFAULT_WEEK_VALUE_BY_START_APP = 7;

    public MainCalendarFrameView() {

        JFrame calendarFrame = new JFrame("Calendar");
        calendarFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        calendarFrame.setSize(900, 600);
        calendarFrame.setLocation(50, 50);
        calendarFrame.setLayout(new BorderLayout());

        NavigationButtonView navigationButtonView = new NavigationButtonView();
        calendarFrame.getContentPane().add(navigationButtonView, BorderLayout.PAGE_START);
        DaysButtonsView buttonsView = new DaysButtonsView();
        buttonsView.currentView(DEFAULT_WEEK_VALUE_BY_START_APP);
        calendarFrame.getContentPane().add(buttonsView, BorderLayout.CENTER);
        calendarFrame.getContentPane().add(new JTextArea(), BorderLayout.AFTER_LAST_LINE);
        calendarFrame.setVisible(true);
    }
}
