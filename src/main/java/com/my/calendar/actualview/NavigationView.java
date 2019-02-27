package com.my.calendar.actualview;

import com.my.calendar.buttons.NextButton;
import com.my.calendar.buttons.PreviousButton;
import com.my.calendar.comboboxframe.ComboBox;
import com.my.calendar.controller.Controller;
import com.my.calendar.textfields.TextView;

import javax.swing.*;
import java.awt.*;

public class NavigationView extends JButton {

    public NavigationView() {
        setLayout(new FlowLayout());

        NextButton buttonNext = new NextButton(" > ");
        PreviousButton previousButton = new PreviousButton(" < ");
        ComboBox comboBoxFrame = new ComboBox();
        TextView textViewField = new TextView(Controller.getInstance().getLocalDate());

        add(previousButton);
        add(textViewField);
        add(buttonNext);
        add(comboBoxFrame);
    }
}
