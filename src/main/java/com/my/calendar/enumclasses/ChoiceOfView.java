package com.my.calendar.enumclasses;

import com.my.calendar.controller.Controller;

import java.time.LocalDate;

public enum ChoiceOfView {

    WEEK {

        @Override
        public void previousButtonFunctionality() {
            super.previousButtonFunctionality();
        }

        @Override
        public void nextButtonFunctionality() {
            super.nextButtonFunctionality();
        }
    },
    MONTH {

        @Override
        public void previousButtonFunctionality() {
            super.previousButtonFunctionality();
        }

        @Override
        public void nextButtonFunctionality() {
            super.nextButtonFunctionality();
        }
    };

    public void previousButtonFunctionality() {

        if (Controller.getInstance().getCurrentView().name().equals("WEEK")) {
            LocalDate localDate = Controller.getInstance().getLocalDate().minusWeeks(1);
            Controller.getInstance().setLocalDate(localDate);
        } else if (Controller.getInstance().getCurrentView().name().equals("MONTH")) {
            LocalDate localDate = Controller.getInstance().getLocalDate().minusMonths(1);
            Controller.getInstance().setLocalDate(localDate);
        }
    }

    public void nextButtonFunctionality() {
        if (Controller.getInstance().getCurrentView().name().equals("WEEK")) {
            LocalDate localDate = Controller.getInstance().getLocalDate().plusWeeks(1);
            Controller.getInstance().setLocalDate(localDate);
        } else if (Controller.getInstance().getCurrentView().name().equals("MONTH")) {
            LocalDate localDate = Controller.getInstance().getLocalDate().plusMonths(1);
            Controller.getInstance().setLocalDate(localDate);
        }
    }
}
