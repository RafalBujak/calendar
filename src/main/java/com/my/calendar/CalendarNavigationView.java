package com.my.calendar;


import javax.swing.*;
import java.awt.*;

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
        NextButton buttonNext = new NextButton(" > ");
        PreviousButton previousButton = new PreviousButton(" < ");



        add(previousButton);
        Controller.getInstance().addChangeDateObservers(previousButton);
        add(Controller.getInstance().textViewField);
        Controller.getInstance().addChangeDateObservers(Controller.getInstance().textViewField);
        add(buttonNext);
        Controller.getInstance().addChangeDateObservers(buttonNext);
        add(new ComboBoxFrame());


        setVisible(true);
    }

}
