package com.my.calendar.frameview;

import javax.swing.*;
import java.awt.*;

public class MainCalendarFrameView extends JFrame {


    public MainCalendarFrameView() {
        JFrame calendarFrame = new JFrame("Calendar");
        calendarFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        calendarFrame.setSize(900, 600);
        calendarFrame.setLocation(50, 50);
        calendarFrame.setLayout(new BorderLayout());


        NavigationButtonView navigationButtonView = new NavigationButtonView();
        calendarFrame.getContentPane().add(navigationButtonView, BorderLayout.PAGE_START);

        DaysButtonsView viewDaysButtons = new DaysButtonsView();
        viewDaysButtons.createButtonOnStartApplication();
        calendarFrame.getContentPane().add(viewDaysButtons, BorderLayout.CENTER);


        calendarFrame.setVisible(true);
    }

}
