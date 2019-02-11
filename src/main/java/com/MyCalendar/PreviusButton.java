package com.MyCalendar;

import javax.swing.*;

public class PreviusButton extends JButton implements ChangeDate{

    public JButton createButtonPrevius() {
        JButton previusButton = new JButton(" < ");
        return previusButton;
    }

    @Override
    public void updateDate() {

    }
}
