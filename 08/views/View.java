package views;

import java.sql.Date;
import java.util.Scanner;
import controllers.*;
import java.util.ArrayList;

public class View {
    private Scanner scanner;
    private Controller controller;

    public View(Controller controller) {
        scanner = new Scanner(System.in);
        this.controller = controller;
    }

    public void print(String message) {
        System.out.println(message);
    }


    public void commandHandler() {
        int command = 0;
        while (command != 5) {
            printMainMenu();
            command = scanner.nextInt();
            scanner.nextLine();
            try {
                swithCommands(command);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printMainMenu() {
        print("1. Add");
        print("2. Remove");
        print("3. Notes");
        print("4. Export");
        print("5. Exit");
    }

    public void swithCommands(int command) {
            switch (command) {
                case 1:
                    addNote();
                    break;
                case 2:
                    removeNote();
                    break;
                case 3:
                    printNotes();
                    break;
                case 4:
                    exportNote();
                    break;
                case 5:
                    break;
                default:
                    print("Wrong command");
            }
    }

    public void checkExit(String string) {
        if (string.equals("0")) {
            throw new RuntimeException("");
        }
    }

    public void addNote() {
        print("Please choose a title for the note: (type 0 for exit)");
        String name = scanner.nextLine();
        checkExit(name);
        if (controller.isExsist(name)) {
            throw new RuntimeException("this title early exsist");
        }

        print("Enter text:");
        String text = scanner.nextLine();

        Date date = new Date(System.currentTimeMillis());
        controller.addNote(name, text, date);
    }

    public void printNotes() {
        System.out.println("Choose a note to show: (type 0 for exit)");
        printNotePreview();
        int index = scanner.nextInt();
        checkExit(Integer.toString(index));
        System.out.println();
        System.out.println(controller.getNoteString(index - 1));
    }

    public void removeNote() {
        System.out.println("Choose a note to remove: (type 0 for exit)");
        printNotePreview();
        int index = scanner.nextInt();
        checkExit(Integer.toString(index));
        System.out.println();
        controller.removeNoteByIndex(index - 1);
    }

    public void printNotePreview() {
        ArrayList<String> notesPreviews = controller.getNotesPreview();
        int i = 1;
        for (String notepreview : notesPreviews) {
            print(i + ") " + notepreview);
            i++;
        }
    }


    public void exportNote() {
        System.out.println("Choose a note to remove: (type 0 for exit)");
        printNotePreview();
        int index = scanner.nextInt();
        checkExit(Integer.toString(index));
        controller.exportNote(index - 1);
    }
}