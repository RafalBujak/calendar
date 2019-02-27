package com.my.calendar.comboboxframe;

import com.my.calendar.controller.Controller;
import com.my.calendar.enumclasses.ChoiceOfView;

import javax.swing.*;
import java.awt.event.ActionListener;

import static com.my.calendar.enumclasses.ChoiceOfView.*;

public class ComboBox extends JComboBox<ChoiceOfView> implements ActionListener {

    private Controller controller = Controller.getInstance();
    public ComboBox() {

        addItem(WEEK);
        addItem(MONTH);

        addActionListener(event -> controller.setActualView((ChoiceOfView) getSelectedItem()));
    }
}
