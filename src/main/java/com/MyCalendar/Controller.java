package com.MyCalendar;

public final class Controller {

    private static Controller controllerInstance = null;

    private Controller() {

    }

    public static Controller getInstance() {

        if(controllerInstance == null) {
            controllerInstance = new Controller();
        }
        return controllerInstance;
    }

}
