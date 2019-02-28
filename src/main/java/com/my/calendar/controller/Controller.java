package com.my.calendar.controller;

import com.my.calendar.DateObserver;
import com.my.calendar.ViewObserver;
import com.my.calendar.additionalfunctions.Notes;
import com.my.calendar.enumclasses.ChoiceOfView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.*;

public final class Controller {

    private final int DAY_OF_WEEK = 7;

    private ChoiceOfView currentView = ChoiceOfView.WEEK;

    private Notes note = new Notes();
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

    public void notifyChangeView() {
        for (ViewObserver view : viewObservers) {
            view.updateView();
        }
    }

    public Notes getNotes() {
        return note;
    }
    public LocalDate getLocalDate() {
        return localDate;
    }

    public ChoiceOfView getCurrentView() {
        return currentView;
    }

    public int setCurrentDaysView() {
        if (currentView.name().equals("WEEK")) {
            return DAY_OF_WEEK;
        } else if (currentView.name().equals("MONTH")) {
            return localDate.lengthOfMonth();
        }
        return 0;
    }

    public void setActualView(ChoiceOfView choiceOfView) {
        this.currentView = choiceOfView;
        notifyChangeView();
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
        notifyChangeDate();
    }
}
