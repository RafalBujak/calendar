package com.my.calendar.frameview;
import com.my.calendar.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainCalendarFrameView extends JFrame {

    public MainCalendarFrameView() {
        JFrame calendarFrame = new JFrame("Calendar");
        calendarFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        calendarFrame.setSize(900, 600);
        calendarFrame.setLocation(50, 50);
        calendarFrame.setLayout(new BorderLayout());

        NoteView noteView = new NoteView(Controller.getInstance().getLocalDate());
        NavigationButtonView navigationButtonView = new NavigationButtonView();
        calendarFrame.getContentPane().add(navigationButtonView, BorderLayout.PAGE_START);
        DaysButtonsView buttonsView = new DaysButtonsView();
        buttonsView.actualView();
        calendarFrame.getContentPane().add(buttonsView, BorderLayout.CENTER);
        calendarFrame.getContentPane().add(noteView, BorderLayout.PAGE_END);
        calendarFrame.setVisible(true);



    }
}
