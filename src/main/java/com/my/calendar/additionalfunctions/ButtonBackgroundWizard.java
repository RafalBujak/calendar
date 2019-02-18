package com.my.calendar.additionalfunctions;

import com.my.calendar.controller.Controller;
import javax.swing.*;
import java.awt.*;

public class ButtonBackgroundWizard extends JButton {


    public ButtonBackgroundWizard() {

    }

    public void buttonNextCreatingBackgroundOfButtons() {

        if (Controller.getInstance().getIterator() <= Controller.getInstance().buttons.length) {

            Controller.getInstance().buttons[Controller.getInstance().getIterator() - 1].setBackground(getBackground());
            Controller.getInstance().buttons[Controller.getInstance().getIterator()].setBackground(Color.gray);

            Controller.getInstance().setIteratorForNextButton();
            if (Controller.getInstance().getIterator() >= Controller.getInstance().buttons.length) {
                Controller.getInstance().setIteratorForPreviousButton();
            }
        }
    }

    public void buttonPreviousCreatingBackgroundOfButtons() {

        if (Controller.getInstance().getIterator() <= Controller.getInstance().buttons.length) {

            Controller.getInstance().setIteratorForPreviousButton();
            Controller.getInstance().buttons[Controller.getInstance().getIterator() + 1].setBackground(getBackground());
            Controller.getInstance().buttons[Controller.getInstance().getIterator()].setBackground(Color.gray);

            if (Controller.getInstance().getIterator() == 0) {
                Controller.getInstance().setIteratorForNextButton();
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
}
