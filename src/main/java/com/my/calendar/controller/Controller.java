package com.my.calendar.controller;

import com.my.calendar.DateObserver;
import com.my.calendar.ViewObserver;
import com.my.calendar.textfields.TextViewField;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public final class Controller {

    private int currentDayValue = 7;
    //TODO
    //Make localdate private
    public LocalDate localDate = LocalDate.now();
    //TODO
    //remove this textViewField from controller
    public TextViewField textViewField = new TextViewField(localDate);
    private List<DateObserver> dateObservers = new ArrayList<>();
    private List<ViewObserver> viewObservers = new ArrayList<>();

    private static Controller controllerInstance;

    private Controller() { }

    public static synchronized Controller getInstance() {
        if (controllerInstance == null) {
            controllerInstance = new Controller();
        }
        return controllerInstance;
    }

    public void addChangeDateObservers(DateObserver dateObserver) {
        dateObservers.add(dateObserver);
    }

    public void addViewObservers(ViewObserver viewObserver) {
        viewObservers.add(viewObserver);
    }

    public void notifyChangeDate() {
        dateObservers.forEach(DateObserver::updateDate);
    }

    public void notifyChangeView() {
        viewObservers.forEach(ViewObserver::updateView);
    }

    public void setLocalDate(LocalDate localDate) {
        String receiveDate = JOptionPane.showInputDialog("Input the date in the format \"yyyy-mm-dd\"",
                getInstance().localDate.toString());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(receiveDate, formatter);
        this.localDate = date;
        getInstance().notifyChangeDate();
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    /*
    public void setTextViewField(TextViewField textViewField) {
        this.textViewField = textViewField;
    }
    */

    public int getCurrentDayValue() {
        return currentDayValue;
    }

    public void setCurrentDayValue(int currentDayValue) {
        this.currentDayValue = currentDayValue;
        notifyChangeView();
    }
}
