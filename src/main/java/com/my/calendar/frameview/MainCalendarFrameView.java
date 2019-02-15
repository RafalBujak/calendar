package com.my.calendar.frameview;

import javax.swing.*;
import java.awt.*;

public class MainCalendarFrameView extends JFrame {

    public MainCalendarFrameView() {
        JFrame calendarFrame = new JFrame("Calendar");
        calendarFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        calendarFrame.setSize(900, 600);
        calendarFrame.setLocation(50, 50);


        NavigationButtonView navigationButtonView = new NavigationButtonView();
        calendarFrame.getContentPane().add(navigationButtonView, BorderLayout.CENTER);
        DaysButtonsView viewDaysButtons = new DaysButtonsView(7);
        calendarFrame.getContentPane().add(viewDaysButtons, BorderLayout.WEST);
        calendarFrame.setVisible(true);
    }

}
