package data_accesses;

import java.io.*;
import java.util.ArrayList;
import models.Note;

public class DataAccess {
    private String path;
    public DataAccess(String path) {
        this.path = path;
        try (FileOutputStream fileOutputStream = new FileOutputStream(path, true)) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveNote(Note note) {
        ArrayList<Note> notes = readAllNotes();
        notes.add(note);
        writeAllNotes(notes);
    }

    public void removeNoteByObject(Note noteToRemove) {
        ArrayList<Note> notes = readAllNotes();

        if (notes.remove(noteToRemove)) {
            writeAllNotes(notes);
            System.out.println("Note removed successfully.");
        } else {
            System.out.println("Note not found.");
        }
    }

    public void removeNoteByIndex(int index) {
        ArrayList<Note> notes = readAllNotes();

        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
            writeAllNotes(notes);
            System.out.println("Note removed successfully.");
        } else {
            System.out.println("Note not found.");
        }
    }

    public Note getNoteByIndex(int index) {
        ArrayList<Note> notes = readAllNotes();

        if (index >= 0 && index < notes.size()) {
            return notes.get(index);
        } 

        return null;
    }

    public Note getNoteByName(String name) {
        ArrayList<Note> notes = readAllNotes();
        for (Note note: notes) {
            if (note.getName().equals(name)) {
                return note;
            }
        } 
        
        return null;
    }

    public void exportNote(int index) {
        Note note = getNoteByIndex(index);
        System.out.println(note.toString());
        if (note != null) {
            try {
                FileWriter fileWriter = new FileWriter("./Export/" + note.getName() + ".txt");
                fileWriter.write(note.toString());
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Note> readAllNotes() {
        ArrayList<Note> notes = new ArrayList<>();
    
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            while (true) {
                try {
                    Note note = (Note) objectInputStream.readObject();
                    notes.add(note);
                } catch (EOFException e) {
                    break; // Exit the loop when end of file is reached
                }
            }
        } catch (EOFException e) { 
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    
        return notes;
    }
    
    private void writeAllNotes(ArrayList<Note> notes) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            for (Note note : notes) {
                objectOutputStream.writeObject(note);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
