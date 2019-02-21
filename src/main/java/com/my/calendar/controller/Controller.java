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

    public TextViewField getTextViewField() {
        return textViewField;
    }

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

    public void setLocalDate() {
        String receiveDate = JOptionPane.showInputDialog("Input the date in the format \"yyyy-mm-dd\"",
                localDate.toString());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(receiveDate, formatter);
        this.localDate = date;
        notifyChangeDate();
    }

    public void setLocalDateFromMouse(String dateFromMouse) {
        String receiveDateFromLeftClick = dateFromMouse;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(receiveDateFromLeftClick, formatter);
        this.localDate = date;
        notifyChangeDate();
    }
    public LocalDate getLocalDate() {
        return localDate;
    }

    public int getCurrentDayValue() {
        return currentDayValue;
    }

    public void setCurrentDayValue(int currentDayValue) {
        this.currentDayValue = currentDayValue;
        notifyChangeView();
    }
}
