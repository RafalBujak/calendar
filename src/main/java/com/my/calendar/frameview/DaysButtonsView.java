package com.my.calendar.frameview;

import com.my.calendar.DateObserver;
import com.my.calendar.ViewObserver;
import com.my.calendar.additionalfunctions.Notes;
import com.my.calendar.controller.Controller;
import com.my.calendar.date.DateFormatter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DaysButtonsView extends JPanel implements DateObserver, ViewObserver {

    private final int LENGTH_OF_WEEK_BY_DAYS = 7;
    private Controller controller = Controller.getInstance();
    private Notes database = new Notes();
    private List<JButton> currentCalendarView = new ArrayList<>();
    private DateFormatter formatter = new DateFormatter();

    public DaysButtonsView() {
        Controller.getInstance().addChangeDateObservers(this);
        Controller.getInstance().addViewObservers(this);
    }

    public void currentView(int days) {
        removeAll();
        currentCalendarView.clear();
        LocalDate temp = LocalDate.of(controller.getLocalDate().getYear(), controller.getLocalDate().getMonth(), 1);
        for (int day = 0; day < days; day++) {
            if (days == LENGTH_OF_WEEK_BY_DAYS) {
                currentCalendarView.add(new JButton(controller.getLocalDate().with(DayOfWeek.MONDAY).plusDays(day).toString()));
            } else if (days == controller.getLocalDate().lengthOfMonth()){
                currentCalendarView.add(new JButton(temp.toString()));
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

        for (int i = 0; i < currentCalendarView.size(); i++) {
            int finalIterator = i;
            currentCalendarView.get(i).addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    if (SwingUtilities.isRightMouseButton(event)) {
                        String temp = "";
                        String notes = JOptionPane.showInputDialog("Add new note", temp);
                        database.addNote(currentCalendarView.get(finalIterator).getText(), notes);
                        database.getNoteFromMap(currentCalendarView.get(finalIterator).getText());
                    } else if (SwingUtilities.isLeftMouseButton(event)) {
                        String temp = currentCalendarView.get(finalIterator).getText();
                        formatter.setLocalDateFromMouse(temp);
                        resetBackground();
                        currentDateOfBackground();
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
    public void updateView(int days) {
        currentView(days);
    }

    @Override
    public void updateDate() {
        currentView(days);
    }
}
