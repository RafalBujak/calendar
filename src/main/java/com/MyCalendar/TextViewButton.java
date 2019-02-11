package com.MyCalendar;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class TextViewButton extends JTextField implements ChangeDate {


    public TextViewButton() {

    }

    public TextField createTextField(LocalDate date) {
        TextField textField = new TextField(date.toString());
        return textField;
    }


    @Override
    public void updateDate() {

    }
}
