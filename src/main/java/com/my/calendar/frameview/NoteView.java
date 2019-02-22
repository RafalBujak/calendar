package com.my.calendar.frameview;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class NoteView extends JPanel {

    public NoteView(LocalDate date) throws HeadlessException {
        JFrame noteFrame = new JFrame("Note");
        noteFrame.setSize(500, 700);
        noteFrame.setLocation(50, 50);
        noteFrame.setVisible(true);
    }
}
