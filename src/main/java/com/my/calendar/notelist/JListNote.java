package com.my.calendar.notelist;

import com.my.calendar.controller.Controller;

import javax.swing.*;

public class JListNote extends JFrame {

    public JListNote() {
        DefaultListModel<String> notesList = new DefaultListModel<>();

        String temp = Controller.getInstance().getLocalDate().toString();

        notesList.addElement(Controller.getInstance().getNotes().getNote(temp));

        JList<String> noteList = new JList<>(notesList);
        add(noteList);

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setTitle("Notes");
        this.setSize(200,200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}