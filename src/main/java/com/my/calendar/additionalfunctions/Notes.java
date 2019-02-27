package com.my.calendar.additionalfunctions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Notes implements SimpleNoteService {

    private Map<String, ArrayList<String>> storeOfNotes = new HashMap<>();

    public Notes() {
    }

    @Override
    public void addNote(String key, String value) {
        ArrayList<String> values = storeOfNotes.computeIfAbsent(key, k -> new ArrayList<>());
        values.add(value);
    }

    @Override
    public void getNote(String key) {
        StringBuilder tempValue = new StringBuilder();
        for (Map.Entry<String, ArrayList<String>> entry : storeOfNotes.entrySet()) {
            if (storeOfNotes.containsKey(key)) {
                tempValue.append(entry.getKey()).append(" Note : ").append(entry.getValue()).append("\n");
            }
        }
    }
}
