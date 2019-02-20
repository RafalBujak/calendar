package com.my.calendar.additionalfunctions;

import com.my.calendar.controller.Controller;
import javax.swing.*;
import java.awt.*;

import static com.my.calendar.controller.Controller.*;

public class ButtonBackgroundWizard extends JButton {

    //TODO
    //to delete, eventually leave as extra functionality

    public ButtonBackgroundWizard() {

    }

    public void buttonNextCreatingBackgroundOfButtons() {

        if (getInstance().getIterator() <= getInstance().buttons.length) {

            getInstance().buttons[getInstance().getIterator() - 1].setBackground(getBackground());
            getInstance().buttons[getInstance().getIterator()].setBackground(Color.gray);

            getInstance().setIteratorForNextButton();
            if (getInstance().getIterator() >= getInstance().buttons.length) {
                getInstance().setIteratorForPreviousButton();
            }
        }
    }

    public void buttonPreviousCreatingBackgroundOfButtons() {

        if (getInstance().getIterator() <= Controller.getInstance().buttons.length) {

            getInstance().setIteratorForPreviousButton();
            getInstance().buttons[getInstance().getIterator() + 1].setBackground(getBackground());
            getInstance().buttons[getInstance().getIterator()].setBackground(Color.gray);

            if (getInstance().getIterator() == 0) {
                getInstance().setIteratorForNextButton();
            }
        }
    }

    public void textFieldCreatingBackgroundOfButtons() {
        /*
        co ma wykonac ta metoda po wprowadzeniu z klawiatury nowej daty

        1. po wpsaniu daty utwórz nowa tablice jbuttonów od daty która zostałą wpisana do textboxa
        2. ustawic iterator na wartosc indexu 1
        3. ustawic na buttonie o indexie 0 tło
        4.


         */
    }

    public void changeViewForNextWeek() {

    }

}
