package com.MyCalendar;


import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class CalendarNavigationView extends JFrame {


    private ComboBoxFrame comboBoxFrame = new ComboBoxFrame();
    private NextButton nextButton = new NextButton();
    private PreviusButton previusButton = new PreviusButton();
    private TextViewButton textViewButton = new TextViewButton();


    public CalendarNavigationView() {
        super("Calendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocation(50, 50);
        calendarView();
    }

    public void calendarView() {

        setLayout(new FlowLayout());

        add(previusButton.createButtonPrevius());
        add(textViewButton.createTextField(LocalDate.now()));
        add(nextButton.createButtonNext());
        add(comboBoxFrame.createComboBox());
        setVisible(true);
    }



}
