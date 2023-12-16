package controllers;

import java.util.ArrayList;
import java.util.Date;

import data_accesses.DataAccess;
import models.Note;

public class Controller {
    private DataAccess dataAccess;

    public Controller() {
        dataAccess = new DataAccess("Data/notes.bin");
    }

    public void addNote(String name, String text, Date date) {
        Note note = new Note(name, text, date);
        dataAccess.saveNote(note);
    }

    public boolean isExsist(String name) {
        return (dataAccess.getNoteByName(name) != null) ? true : false;
    }

    public void removeNoteByIndex(int index) {
        dataAccess.removeNoteByIndex(index);
    }

    public ArrayList<String> getNotesPreview() {
        ArrayList<String> notesName = new ArrayList<>();
    
        for (Note note: dataAccess.readAllNotes()) {
            notesName.add(note.getName() + "\t" + note.getDate().toString());
        }

        return notesName;
    }

    public void exportNote(int index) {
        dataAccess.exportNote(index);
    }

    public String getNoteString(int index) {
        Note note = dataAccess.getNoteByIndex(index);
        if (note == null) {
            throw new RuntimeException("note not found");
        }

        return dataAccess.getNoteByIndex(index).toString();
    }
}