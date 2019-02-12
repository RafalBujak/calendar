package com.my.calendar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Controller {


    TextViewButton textViewButton = new TextViewButton(LocalDate.now());
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

    public void addViewObserwers(ChangeView changeView) {
        changeViews.add(changeView);
    }

    public void setChangeDate() {

        for (ChangeDate date : changeDates) {
            date.updateDate();
        }
    }

    public void setChangeView() {

        for (ChangeView view : changeViews) {
            view.updateView();
        }
    }
}
