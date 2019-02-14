package com.my.calendar.frameview;


import com.my.calendar.ChangeView;
import com.my.calendar.comboboxframe.ComboBoxFrame;
import com.my.calendar.controller.Controller;
import com.my.calendar.buttons.NextButton;
import com.my.calendar.buttons.PreviousButton;

import javax.swing.*;
import java.awt.*;

public class CalendarMainFrame extends JFrame {

    private Controller controller = Controller.getInstance();
    public CalendarMainFrame() {
        super("Calendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocation(50, 50);
        calendarView();
    }

    public void calendarView() {

        ViewDaysButtons weekView = new ViewDaysButtons(Controller.getInstance().getMonthDays());
        setLayout(new FlowLayout());

        NextButton buttonNext = new NextButton(" > ");
        PreviousButton previousButton = new PreviousButton(" < ");


        add(previousButton);
        controller.addChangeDateObservers(previousButton);
        add(controller.textViewField);
        controller.addChangeDateObservers(controller.textViewField);
        add(buttonNext);
        controller.addChangeDateObservers(buttonNext);
        add(new ComboBoxFrame());
        getContentPane().add(weekView);
        controller.addViewObservers(weekView);

        setVisible(true);
    }

}
