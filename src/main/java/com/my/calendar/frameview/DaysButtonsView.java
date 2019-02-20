package com.my.calendar.frameview;

import com.my.calendar.ChangeView;
import com.my.calendar.additionalfunctions.DatabaseOfNotes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import static com.my.calendar.controller.Controller.*;

public class DaysButtonsView extends JPanel implements ChangeView, ActionListener {
    private List<JButton> weekView = new ArrayList<>();
    private DatabaseOfNotes databaseOfNotes;

    public DaysButtonsView() {
        getInstance().addViewObservers(this::updateView);
    }

    //TODO
    //poprostu do wyjebania

    public void actualView() {

        removeAll();

        weekView.clear();
        int days = getInstance().getMonthDays();
        System.out.println(days);
        for (int i = 0; i < days; i++) {
            System.out.println("jestem w for " + i);
            weekView.add(new JButton(String.valueOf(getInstance().localDate.plusDays(i))));

            //added actionListener for set Background
            int finalIteratorForBackground = i;
            weekView.get(i).addActionListener(e -> weekView.get(finalIteratorForBackground).setBackground(Color.red));

            // added mouse Listener to the button
            int finalIteratorForMouseClick = i;
            weekView.get(i).addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    if (SwingUtilities.isRightMouseButton(event)) {
                        //TODO
                        //implement this option to add note
                        //databaseOfNotes = new DatabaseOfNotes(weekView.get(finalIteratorForMouseClick).toString(), "note right");
                        //System.out.println(databaseOfNotes.getNote() + " " + weekView.get(finalIteratorForMouseClick).getText());
                        weekView.get(finalIteratorForMouseClick).setBackground(Color.gray);
                        weekView.get(0).setBackground(getBackground());

                    } else if (SwingUtilities.isLeftMouseButton(event)) {
                        //TODO
                        //implement this option to add possibility to change date from the name of Jbutton to date in textfield
                        databaseOfNotes = new DatabaseOfNotes(weekView.get(finalIteratorForMouseClick).toString(), "note left");
                        System.out.println(databaseOfNotes.getNote() + " " + weekView.get(finalIteratorForMouseClick).getText());
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
        weekView.forEach(this::add);
        weekView.get(0).setBackground(Color.gray);
        updateUI();
        revalidate();
        repaint();
    }

    @Override
    public void updateView() {
        actualView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
