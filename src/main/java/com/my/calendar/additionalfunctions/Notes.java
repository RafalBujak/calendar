package com.my.calendar.additionalfunctions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Notes implements SimpleNoteService {

    private Map<String, ArrayList<String>> storeOfNotes = new HashMap<>();

    public Notes() {
    }

    @Override
    public void addNote(String key, String value) {
        ArrayList<String> values = storeOfNotes.computeIfAbsent(key, k -> new ArrayList<>());
        values.add(value);
        System.out.println(storeOfNotes.size());
    }

    @Override
    public String getNote(String key) {
        List<String> noteList;
        noteList = storeOfNotes.getOrDefault(key, new ArrayList<>());
        return noteList.toString();
    }
}
