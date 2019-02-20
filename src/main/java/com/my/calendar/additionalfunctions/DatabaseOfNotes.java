package com.my.calendar.additionalfunctions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DatabaseOfNotes {

    private Map<String, String> storeOfNotes = new HashMap<>();
    private String day;

    public String getNote() {
        return note;
    }

    private String note;

    public DatabaseOfNotes(String day, String note) {
        this.day = day;
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatabaseOfNotes that = (DatabaseOfNotes) o;
        return day.equals(that.day) &&
                note.equals(that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, note);
    }
}
