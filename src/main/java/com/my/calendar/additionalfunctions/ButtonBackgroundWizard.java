package com.my.calendar.additionalfunctions;

import com.my.calendar.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class ButtonBackgroundWizard extends JButton {


    private int iterator = 1;

    public ButtonBackgroundWizard(){

    }

    public void creatingBackgroundOfButtonsNext() {
        while (iterator < Controller.getInstance().buttons.length) {

            Controller.getInstance().buttons[iterator - 1].setBackground(getBackground());
            Controller.getInstance().buttons[iterator].setBackground(Color.gray);
            break;

        }
        iterator++;
    }

    //TODO
    //make this method live :)
    public void creatingBackgroundOfButtonsPrevious() {
        while (Controller.getInstance().buttons.length < iterator) {

            Controller.getInstance().buttons[iterator + 1].setBackground(getBackground());
            Controller.getInstance().buttons[iterator].setBackground(Color.gray);
            break;

        }
        iterator--;
    }

}
