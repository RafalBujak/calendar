package com.my.calendar.frameview;


import com.my.calendar.comboboxframe.ComboBoxFrame;
import com.my.calendar.controller.Controller;
import com.my.calendar.buttons.NextButton;
import com.my.calendar.buttons.PreviousButton;

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

        //TODO
        /*
        dodaj przyciski.
        Container buttonLayout = new Container();
        JButton[] buttons = new JButton[8];
        for (JButton button : buttons) {
            button = new JButton();
            buttonLayout.add(button);
            setVisible(true);
        }

        */
        setVisible(true);
    }

}
