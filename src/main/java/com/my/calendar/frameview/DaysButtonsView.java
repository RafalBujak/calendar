package com.my.calendar.frameview;

import com.my.calendar.ViewObserver;
import com.my.calendar.additionalfunctions.DatabaseOfNotes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.my.calendar.controller.Controller.*;

public class DaysButtonsView extends JPanel implements ViewObserver {

    private DatabaseOfNotes database = new DatabaseOfNotes();
    private List<JButton> weekView = new ArrayList<>();

    public DaysButtonsView() {
        getInstance().addViewObservers(this);
    }

    public void actualView() {
        removeAll();
        weekView.clear();
        int currentValueInDays = getInstance().getCurrentDayValue();
        for (int i = 0; i < currentValueInDays; i++) {
            weekView.add(new JButton(String.valueOf(getInstance().getLocalDate().with(DayOfWeek.MONDAY).plusDays(i))));
        }
        weekView.forEach(this::add);
        currentDateOfBackground();
        addMouseClickListener();
        updateUI();
        revalidate();
        repaint();
    }

    @Override
    public void updateView() {
        actualView();
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
        IntStream.range(0, weekView.size()).forEach(i -> weekView.get(i).setBackground(getBackground()));
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
                        getInstance().setLocalDateFromMouse(temp);
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
