package com.my.calendar.controller;

import com.my.calendar.ChangeDate;
import com.my.calendar.ChangeView;
import com.my.calendar.textfields.TextViewField;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Controller {

    public LocalDate localDate = LocalDate.now();
    public TextViewField textViewField = new TextViewField(localDate);
    private List<ChangeDate> changeDates = new ArrayList<>();
    private List<ChangeView> changeViews = new ArrayList<>();

    private static Controller controllerInstance = null;

    private Controller() {

    }

    public static Controller getInstance() {

        if(controllerInstance == null) {
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

        for (ChangeDate date : changeDates) {
            date.updateDate();
        }
    }

    public void notifyChangeView() {

        for (ChangeView view : changeViews) {
            view.updateView();
        }
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
