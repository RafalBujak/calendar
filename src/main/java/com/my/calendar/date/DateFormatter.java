package com.my.calendar.date;

import com.my.calendar.controller.Controller;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.parse;

public class DateFormatter {

    public DateFormatter() {  }

    public void setLocalDateFromInputDialog() {
        try {
            String receiveDate = JOptionPane.showInputDialog("Input the date in the format \"yyyy-mm-dd\"",
                    Controller.getInstance().getLocalDate().toString());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Controller.getInstance().setLocalDate(LocalDate.parse(receiveDate, formatter));
        } catch (Exception wrongDateFormat) {
            JOptionPane.showMessageDialog(null, "Incorrect date format. The correct format is yyyy-mm-dd");
        }
    }

    public void setLocalDateFromMouse(String dateFromMouse) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date;
            date = parse(dateFromMouse, formatter);
            Controller.getInstance().setLocalDate(date);
        } catch (Exception wrongDateFormat) {
            JOptionPane.showMessageDialog(null, "Incorrect date format.");
        }
    }
}
