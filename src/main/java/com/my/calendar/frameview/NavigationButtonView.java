package com.my.calendar.frameview;

import com.my.calendar.buttons.NextButton;
import com.my.calendar.buttons.PreviousButton;
import com.my.calendar.comboboxframe.ComboBoxFrame;
import com.my.calendar.controller.Controller;
import com.my.calendar.textfields.TextViewField;

import javax.swing.*;
import java.awt.*;

public class NavigationButtonView extends JButton {

    public NavigationButtonView() {
        setLayout(new FlowLayout());

        NextButton buttonNext = new NextButton(" > ");
        PreviousButton previousButton = new PreviousButton(" < ");
        ComboBoxFrame comboBoxFrame = new ComboBoxFrame();
        TextViewField textViewField = new TextViewField(Controller.getInstance().getLocalDate());

        add(previousButton);
        add(textViewField);
        add(buttonNext);
        add(comboBoxFrame);
    }
}
