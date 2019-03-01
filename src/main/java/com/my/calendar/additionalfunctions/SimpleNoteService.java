package com.my.calendar.additionalfunctions;

public interface SimpleNoteService {
    void addNote(String key, String value);
    String getNotes(String key);
}
