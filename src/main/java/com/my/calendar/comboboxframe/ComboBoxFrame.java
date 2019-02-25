package com.my.calendar.comboboxframe;

import com.my.calendar.enumclasses.ChoiceOfView;

import javax.swing.*;
import java.awt.event.ActionListener;

import static com.my.calendar.enumclasses.ChoiceOfView.*;
import static com.my.calendar.controller.Controller.*;

public class ComboBoxFrame extends JComboBox<ChoiceOfView> implements ActionListener {

    public ComboBoxFrame() {

        addItem(WEEK);
        addItem(MONTH);

        addActionListener(event -> getInstance().setActualView(getSelectedItem().toString()));
    }
}
