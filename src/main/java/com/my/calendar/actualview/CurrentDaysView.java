package com.my.calendar.actualview;

import com.my.calendar.DateObserver;
import com.my.calendar.ViewObserver;
import com.my.calendar.buttons.DaysButton;
import com.my.calendar.controller.Controller;
import com.my.calendar.date.DateFormatter;
import com.my.calendar.notelist.JListNote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CurrentDaysView extends JPanel implements DateObserver, ViewObserver {

    private final int LENGTH_OF_WEEK_BY_DAYS = 7;

    private Controller controller = Controller.getInstance();
    private List<JButton> currentCalendarView = new ArrayList<>();
    private DateFormatter formatter = new DateFormatter();

    public CurrentDaysView() {
        controller.addChangeDateObservers(this);
        controller.addViewObservers(this);
    }

    public void currentViewDays(int days) {
        removeAll();
        currentCalendarView.clear();

        LocalDate temp = LocalDate.of(controller.getLocalDate().getYear(), controller.getLocalDate().getMonth(), 1);

        for (int day = 0; day < days; day++) {
            if (days == LENGTH_OF_WEEK_BY_DAYS) {
                currentCalendarView.add(new DaysButton(controller.getLocalDate().with(DayOfWeek.MONDAY).plusDays(day).toString()));
            } else if (days == controller.getLocalDate().lengthOfMonth()) {
                currentCalendarView.add(new DaysButton(temp.toString()));
                temp = temp.plusDays(1L);
            }
        }

        currentCalendarView.forEach(this::add);
        currentDateOfBackground();
        addMouseClickListener();
        revalidate();
        repaint();
    }

    private void currentDateOfBackground() {
        int i = 0;
        while (i < currentCalendarView.size()) {
            if (controller.getLocalDate().toString().equals(currentCalendarView.get(i).getText())) {
                currentCalendarView.get(i).setBackground(Color.gray);
            }
            i++;
        }
    }

    private void resetBackground() {
        IntStream.range(0, currentCalendarView.size()).forEach(iterator -> currentCalendarView.get(iterator).setBackground(getBackground()));
    }

    private void addMouseClickListener() {
        for (int day = 0; day < currentCalendarView.size(); day++) {
            int innerClassIterator = day;
            currentCalendarView.get(day).addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    if (SwingUtilities.isRightMouseButton(event)) {
                        String temp = "";
                        String notes = JOptionPane.showInputDialog("Add new note", temp);
                        controller.getNotes().addNote(currentCalendarView.get(innerClassIterator).getText(), notes);
                    } else if (SwingUtilities.isLeftMouseButton(event)) {
                        String temp = currentCalendarView.get(innerClassIterator).getText();
                        formatter.setLocalDateFromMouse(temp);
                        resetBackground();
                        currentDateOfBackground();
                        new JListNote();
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
        }
    }

    @Override
    public void updateView() {
        currentViewDays(controller.setCurrentDaysView());
    }

    @Override
    public void updateDate() {
        currentViewDays(controller.setCurrentDaysView());
    }
}
