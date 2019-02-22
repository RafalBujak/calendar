package com.my.calendar.controller;

import com.my.calendar.DateObserver;
import com.my.calendar.ViewObserver;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.*;

public final class Controller {

    private static final int DEFAULT_NUMBER_OF_DAYS = 7;

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

    public void setLocalDateFromInputDialog() {
        try {
            String receiveDate = JOptionPane.showInputDialog("Input the date in the format \"yyyy-mm-dd\"",
                    localDate.toString());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.localDate = LocalDate.parse(receiveDate, formatter);
            notifyChangeDate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Incorrect date format. The correct format is yyyy-mm-dd");
        }
    }

    public void setLocalDateFromMouse(String dateFromMouse) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date;
            date = parse(dateFromMouse, formatter);
            this.localDate = date;
            notifyChangeDate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Incorrect date format.");
        }
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

    private void setLocalDayByUsingJButtons(LocalDate date) {
        this.localDate = date;
    }

    public void updateDateViewNextButton() {
        if (currentDayValue == 7) {
            setLocalDayByUsingJButtons(localDate.plusWeeks(1));
            notifyChangeView();
        } else {
            setLocalDayByUsingJButtons(localDate.plusMonths(1));
            notifyChangeView();
        }
    }

    public void updateDateViewPreviousButton() {
        if (currentDayValue == 7) {
            setLocalDayByUsingJButtons(localDate.minusWeeks(1));
            notifyChangeView();
        } else {
            setLocalDayByUsingJButtons(localDate.minusMonths(1));
            notifyChangeView();
        }
    }
}
