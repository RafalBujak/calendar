package com.my.calendar.additionalfunctions;

import com.my.calendar.controller.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Notes {

    private Map<String, ArrayList<String>> storeOfNotes = new HashMap<>();

    public Notes() {
    }

    public void addNote(String key, String value) {
        ArrayList<String> values = storeOfNotes.computeIfAbsent(key, k -> new ArrayList<String>());
        values.add(value);
    }

    public void getNoteFromMap(String key) {
        StringBuilder tempValue = new StringBuilder();
        for (Map.Entry<String, ArrayList<String>> entry : storeOfNotes.entrySet()) {
            if (storeOfNotes.containsKey(key)) {
                tempValue.append(entry.getKey()).append(" Note : ").append(entry.getValue()).append("\n");
            }
        }

        Controller.getInstance().getTextArea().setText(tempValue.toString());
    }
}
