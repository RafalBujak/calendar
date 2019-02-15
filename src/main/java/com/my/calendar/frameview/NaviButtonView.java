package com.my.calendar.frameview;

import com.my.calendar.buttons.NextButton;
import com.my.calendar.buttons.PreviousButton;
import com.my.calendar.comboboxframe.ComboBoxFrame;
import com.my.calendar.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class NaviButtonView extends JButton {
    private Controller controller = Controller.getInstance();

    public NaviButtonView() {
        setLayout(new FlowLayout());

        NextButton buttonNext = new NextButton(" > ");
        PreviousButton previousButton = new PreviousButton(" < ");
        ComboBoxFrame comboBoxFrame = new ComboBoxFrame();


        add(previousButton);
        controller.addChangeDateObservers(previousButton);
        add(controller.textViewField);
        controller.addChangeDateObservers(controller.textViewField);
        add(buttonNext);
        controller.addChangeDateObservers(buttonNext);
        add(comboBoxFrame);
        controller.addViewObservers(comboBoxFrame);
    }
}
