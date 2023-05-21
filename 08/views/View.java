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

    public void addNote() {
        print("Please choose a title for the note: ");
        String name = scanner.nextLine();

        print("Enter text:");
        String text = scanner.nextLine();

        Date date = new Date(System.currentTimeMillis());
        controller.addNote(name, text, date);
    }

    public void printNotes() {
        printNotesName();
        int index = scanner.nextInt();
        System.out.println();
        System.out.println(controller.getNoteString(index - 1));
    }

    public void removeNote() {
        printNotesName();
        int index = scanner.nextInt();
        System.out.println();
        controller.removeNoteByIndex(index - 1);
    }

    public void printNotesName() {
        ArrayList<String> notesName = controller.getNotesName();
        int i = 1;
        for (String name : notesName) {
            print(i + ") " + name);
            i++;
        }
    }


    public void exportNote() {
        printNotesName();
        int index = scanner.nextInt();
        controller.exportNote(index - 1);
    }
}