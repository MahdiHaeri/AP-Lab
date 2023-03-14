package controller;

import java.util.Scanner;
import models.*;
import views.*;
import java.util.ArrayList;

public class PhoneBookController {
    private PhoneBook phoneBook;
    private PhoneBookView view;
    private Scanner scanner;

    public PhoneBookController(PhoneBook phoneBook, PhoneBookView view) {
        this.phoneBook = phoneBook;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    public void handelMenu() {
        int choice = -1;
        while (choice != 0) {
            view.printMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1: 
                    addContact();
                    break;
                case 2: 
                    deleteContact();
                    break;
                case 3: 
                    view.printContact(findContact());
                    break;
                case 4: 
                    view.printContacts(findContacts());                    
                    break;
                case 5:
                    view.printContacts(getAllContact());
                    break; 
                case 0:
                    System.out.println("Goodby :)");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public void addContact() {        
        view.printFirstNameRequistMessage();
        String firstName = scanner.nextLine();

        view.printLastNameRequistMessage();
        String lastName = scanner.nextLine();

        view.printEmailRequistMessage();
        String email = scanner.nextLine();

        view.printGroupRequistMessage();
        String group = scanner.nextLine();

        view.printCountryCodeRequistMessage();
        String countryCode = scanner.nextLine();

        view.printPhoneNumberRequistMessage();
        String number = scanner.nextLine();

        view.printZipCodeRequistMessage();
        String zipCode = scanner.nextLine();

        view.printCountryRequistMessage();
        String country = scanner.nextLine();

        view.printCityRequistMessage();
        String city = scanner.nextLine();

        Contact newContact = new Contact(group, email, firstName, lastName,
            new PhoneNumber(countryCode, number),
            new Address(zipCode, country, city));
        phoneBook.addContact(newContact);
    }

    public void deleteContact() {
        view.printFirstNameRequistMessage();
        String firstName = scanner.nextLine();

        view.printLastNameRequistMessage();
        String lastName = scanner.nextLine();

        phoneBook.deleteContact(firstName, lastName);
    }

    public Contact findContact() {
        view.printFirstNameRequistMessage();
        String firstName = scanner.nextLine();

        view.printLastNameRequistMessage();
        String lastName = scanner.nextLine();

        return phoneBook.findContact(firstName, lastName);
    }

    public ArrayList<Contact> findContacts() {
        view.printGroupRequistMessage();
        String group = scanner.nextLine();

        return phoneBook.findContacts(group);
    }

    public ArrayList<Contact> getAllContacts() {
        return phoneBook.getAllContacts();
    }

    public ArrayList<Contact> getAllContact() {
        return phoneBook.getAllContacts();
    }
}