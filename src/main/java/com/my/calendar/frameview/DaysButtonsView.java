package com.my.calendar.frameview;

import com.my.calendar.ViewObserver;
import com.my.calendar.additionalfunctions.Notes;
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

import static com.my.calendar.controller.Controller.*;

public class DaysButtonsView extends JPanel implements ViewObserver {

    private Notes database = new Notes();
    private List<JButton> weekView = new ArrayList<>();
    private DateFormatter formatter = new DateFormatter();

    public DaysButtonsView() {
        getInstance().addViewObservers(this);
    }

    public void currentButtonsViewOnFrame() {
        removeAll();
        weekView.clear();
        LocalDate temp = LocalDate.of(getInstance().getLocalDate().getYear(), getInstance().getLocalDate().getMonth(), 1);
        int days = getInstance().getCurrentDayValue();
        for (int day = 0; day < days; day++) {
            if (days == 7) {
                weekView.add(new JButton(getInstance().getLocalDate().with(DayOfWeek.MONDAY).plusDays(day).toString()));
            } else if (days > 7 ) {
                weekView.add(new JButton(temp.toString()));
                temp = temp.plusDays(1L);
            }
        }
        weekView.forEach(this::add);
        currentDateOfBackground();
        addMouseClickListener();
        revalidate();
        repaint();
    }

    @Override
    public void updateView() {
        currentButtonsViewOnFrame();
    }

    private void currentDateOfBackground() {
        int i = 0;
        while (i < weekView.size()) {
            if (getInstance().getLocalDate().toString().equals(weekView.get(i).getText())) {
                weekView.get(i).setBackground(Color.gray);
            }
            i++;
        }
    }

    private void resetBackground() {
        IntStream.range(0, weekView.size()).forEach(iterator -> weekView.get(iterator).setBackground(getBackground()));
    }

    private void addMouseClickListener() {

        for (int i = 0; i < weekView.size(); i++) {
            int finalIterator = i;
            weekView.get(i).addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    if (SwingUtilities.isRightMouseButton(event)) {
                        String temp = "";
                        String notes = JOptionPane.showInputDialog("Add new note", temp);
                        database.addNote(weekView.get(finalIterator).getText(), notes);
                        database.getNoteFromMap(weekView.get(finalIterator).getText());
                    } else if (SwingUtilities.isLeftMouseButton(event)) {
                        String temp = weekView.get(finalIterator).getText();
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
}
