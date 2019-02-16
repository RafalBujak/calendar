package com.my.calendar.frameview;

import com.my.calendar.buttons.NextButton;
import com.my.calendar.buttons.PreviousButton;
import com.my.calendar.comboboxframe.ComboBoxFrame;
import com.my.calendar.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class NavigationButtonView extends JButton {

    public NavigationButtonView() {
        setLayout(new FlowLayout());

        //NextButton buttonNext = new NextButton(" > ");
        PreviousButton previousButton = new PreviousButton(" < ");
        ComboBoxFrame comboBoxFrame = new ComboBoxFrame();


        add(previousButton);
        Controller controller = Controller.getInstance();
        controller.addChangeDateObservers(previousButton);
        add(controller.textViewField);
        controller.addChangeDateObservers(controller.textViewField);
        add(Controller.getInstance().nextButton);
        controller.addChangeDateObservers(controller.nextButton);
        add(comboBoxFrame);
        controller.addViewObservers(comboBoxFrame);
    }
}
