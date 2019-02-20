package com.my.calendar.controller;

import com.my.calendar.ChangeDate;
import com.my.calendar.ChangeView;
import com.my.calendar.buttons.NextButton;
import com.my.calendar.frameview.DaysButtonsView;
import com.my.calendar.textfields.TextViewField;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Controller {




    private int iterator = 1;
    private int monthDays = 31;
    public LocalDate localDate = LocalDate.now();
    public TextViewField textViewField = new TextViewField(localDate);
    public JButton[] buttons = new JButton[monthDays];
    private List<ChangeDate> changeDates = new ArrayList<>();
    private List<ChangeView> changeViews = new ArrayList<>();

    private static Controller controllerInstance = null;

    private Controller() {

    }

    public static Controller getInstance() {

        if (controllerInstance == null) {
            controllerInstance = new Controller();
        }
        return controllerInstance;
    }

    public void addChangeDateObservers(ChangeDate changeDate) {
        changeDates.add(changeDate);
    }

    public void addViewObservers(ChangeView changeView) {
        changeViews.add(changeView);
    }

    public void notifyChangeDate() {
        changeDates.forEach(ChangeDate::updateDate);
    }

    public void notifyChangeView() {
        changeViews.forEach(ChangeView::updateView);
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }


    public int getMonthDays() {
        return monthDays;
    }

    public void setMonthDays(int monthDays) {
        this.monthDays = monthDays;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }


    public int getIterator() {
        return iterator;
    }

    public void setIteratorForNextButton() {
        this.iterator++;
    }

    public void setIteratorForPreviousButton() {
        this.iterator--;
    }


    public void setTextViewField(TextViewField textViewField) {
        this.textViewField = textViewField;
    }

    public void createWeekButton() {
        //daysButtonsView.buttonWeek();
    }

}
