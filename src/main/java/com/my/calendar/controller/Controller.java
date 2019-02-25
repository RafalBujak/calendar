package com.my.calendar.controller;

import com.my.calendar.DateObserver;
import com.my.calendar.ViewObserver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.my.calendar.enumclasses.ChoiceOfView.MONTH;
import static com.my.calendar.enumclasses.ChoiceOfView.WEEK;
import static java.time.LocalDate.*;

public final class Controller {

    private final int LENGTH_OF_WEEK = 7;
    private final int LENGTH_OF_MONTH = LocalDate.now().lengthOfMonth();

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
        for (DateObserver date : dateObservers) {
            date.updateDate();
        }

    }

    public void notifyChangeView(int days) {
        for (ViewObserver view : viewObservers) {
            view.updateView(days);
        }
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    //TODO
    //I'm not sure if this is a good practice
    public int getLENGTH_OF_WEEK() {
        return LENGTH_OF_WEEK;
    }

    //TODO
    //I'm not sure if this is a good practice
    public int getLENGTH_OF_MONTH() {
        return LENGTH_OF_MONTH;
    }

    public void setActualView(String choiceOfView) {
        if (WEEK.name().equals(choiceOfView)) {
            notifyChangeView(LENGTH_OF_WEEK);
        } else if (MONTH.name().equals(choiceOfView)) {
            notifyChangeView(LENGTH_OF_MONTH);
        }
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
        notifyChangeDate();
    }

}
