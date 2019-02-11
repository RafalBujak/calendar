package com.MyCalendar;

import javax.swing.*;

public class NextButton extends JButton implements ChangeDate{


    public JButton createButtonNext() {
        JButton rightNaviButton = new JButton(" > ");
        return rightNaviButton;
    }


    @Override
    public void updateDate() {

    }
}
