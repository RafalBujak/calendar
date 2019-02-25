package com.my.calendar.controller;

import com.my.calendar.DateObserver;
import com.my.calendar.ViewObserver;
import com.my.calendar.date.DateFormatter;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.*;

public final class Controller {

    private final int DEFAULT_NUMBER_OF_DAYS = 7;

    private DateFormatter formatter = new DateFormatter();
    private JTextArea textArea = new JTextArea();
    private int currentDayValue = DEFAULT_NUMBER_OF_DAYS;
    private LocalDate localDate = now();
    private List<DateObserver> dateObservers = new ArrayList<>();
    private List<ViewObserver> viewObservers = new ArrayList<>();

    private static Controller controllerInstance;

    private Controller() {
    }

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

    public void updateDateViewNextButton() {
        if (currentDayValue == DEFAULT_NUMBER_OF_DAYS) {
            setLocalDayByUsingJButtons(addWeek());
            notifyDateAndView();
        } else {
            setLocalDayByUsingJButtons(addMonth());
            notifyDateAndView();
        }
    }

    public void updateDateViewPreviousButton() {
        if (currentDayValue == DEFAULT_NUMBER_OF_DAYS) {
            setLocalDayByUsingJButtons(subtractWeek());
            notifyDateAndView();
        } else {
            setLocalDayByUsingJButtons(subtractMonth());
            notifyDateAndView();
        }
    }

    private void notifyDateAndView() {
        notifyChangeView();
        notifyChangeDate();
    }

    private LocalDate addWeek() {
        return localDate.plusWeeks(1);
    }
    private LocalDate addMonth() {
        return localDate.plusMonths(1);
    }

    private LocalDate subtractWeek() {
        return localDate.minusWeeks(1);
    }

    private LocalDate subtractMonth() {
        return localDate.minusMonths(1);
    }

    public DateFormatter getFormatter() {
        return formatter;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public int getCurrentDayValue() {
        return currentDayValue;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setDate(int currentDayValue) {
        this.currentDayValue = currentDayValue;
        notifyChangeView();
    }

    private void setLocalDayByUsingJButtons(LocalDate date) {
        this.localDate = date;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

}
