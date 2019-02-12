package com.my.calendar;


import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class CalendarNavigationView extends JFrame {


    public CalendarNavigationView() {
        super("Calendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocation(50, 50);
        calendarView();
    }

    public void calendarView() {

        setLayout(new FlowLayout());
        //TODO
        /*
        zmienic na border layout
         */
        add(new PreviousButton(" < "));
        add(Controller.getInstance().textViewButton);
        add(new NextButton(" > "));
        add(new ComboBoxFrame());
        setVisible(true);
    }



}
