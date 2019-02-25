package com.my.calendar.controller;

import com.my.calendar.DateObserver;
import com.my.calendar.ViewObserver;
import com.my.calendar.enumclasses.ChoiceOfView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.my.calendar.enumclasses.ChoiceOfView.MONTH;
import static com.my.calendar.enumclasses.ChoiceOfView.WEEK;
import static java.time.LocalDate.*;

public final class Controller {

    private final int DEFAULT_NUMBER_OF_DAYS = 7;

    //to change name of this variable
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

    //do zmiany
    public void updateViewByNextButton() {
        if (currentDayValue == DEFAULT_NUMBER_OF_DAYS) {
            setLocalDayByUsingJButtons(addWeek());
            notifyDateAndView();
        } else {
            setLocalDayByUsingJButtons(addMonth());
            notifyDateAndView();
        }
    }

    // do zmiany
    public void updateViewByPreviousButton() {
        if (currentDayValue == DEFAULT_NUMBER_OF_DAYS) {
            setLocalDayByUsingJButtons(subtractWeek());
            notifyDateAndView();
        } else {
            setLocalDayByUsingJButtons(subtractMonth());
            notifyDateAndView();
        }
    }

    // do wywalenia
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

    public LocalDate getLocalDate() {
        return localDate;
    }

    public int getCurrentDayValue() {
        return currentDayValue;
    }

    public void setActualView(String choiceOfView) {
        if (WEEK.name().equals(choiceOfView)) {
            this.currentDayValue = DEFAULT_NUMBER_OF_DAYS;
            notifyChangeView();
        } else if (MONTH.name().equals(choiceOfView)) {
            this.currentDayValue = localDate.lengthOfMonth();
            notifyChangeView();
        }
    }

    private void setLocalDayByUsingJButtons(LocalDate date) {
        this.localDate = date;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
        notifyChangeDate();
    }

}
