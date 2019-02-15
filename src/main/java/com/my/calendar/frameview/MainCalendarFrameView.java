package com.my.calendar.frameview;

import javax.swing.*;
import java.awt.*;

public class MainCalendarFrameView extends JFrame {

    private ViewDaysButtons viewDaysButtons = new ViewDaysButtons(7);
    private NaviButtonView naviButtonView = new NaviButtonView();
    public MainCalendarFrameView() {
        JFrame calendarFrame = new JFrame("Calendar");
        calendarFrame.setDefaultCloseOperation(calendarFrame.EXIT_ON_CLOSE);
        calendarFrame.setSize(900, 600);
        calendarFrame.setLocation(50, 50);
        calendarFrame.getContentPane().add(naviButtonView, BorderLayout.CENTER);
        calendarFrame.getContentPane().add(viewDaysButtons, BorderLayout.WEST);
        calendarFrame.setVisible(true);
    }

}
