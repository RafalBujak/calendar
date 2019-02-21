package com.my.calendar.additionalfunctions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatabaseOfNotes {

    public Map<String, ArrayList<String>> storeOfNotes = new HashMap<>();

    public DatabaseOfNotes() {  }

    public void addNote(String key, String value) {
        ArrayList<String> values = storeOfNotes.computeIfAbsent(key, k -> new ArrayList<String>());
        values.add(value);
    }

    public ArrayList<String> getNote(String key) {
        return storeOfNotes.get(key);
    }
}
