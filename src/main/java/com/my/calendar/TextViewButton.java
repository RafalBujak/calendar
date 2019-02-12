package com.my.calendar;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class TextViewButton extends JTextField implements ChangeDate {


    public TextViewButton(LocalDate date) {
        super(date.toString());
    }

    public TextViewButton() {

    }



    @Override
    public void updateDate() {

    }
}
