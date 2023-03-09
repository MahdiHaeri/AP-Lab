package views;

import java.util.ArrayList;

import models.Contact;

public class PhoneBookView {
    public PhoneBookView() {
    }

    public void printMenu() {
        System.out.println("\n---Phone Book Menu---");
        System.out.println("1. Add contact");
        System.out.println("2. Remove contact");
        System.out.println("3. Find contact");
        System.out.println("4. Find group");
        System.out.println("5. Print all contacts");
        System.out.println("0. Quit");
    }

    public void printTitle(String title) {
        System.out.println("\n---" + title + "---");
    }

    public void printGroupRequistMessage() {
        System.out.print("Enter Group: ");
    }

    public void printFirstNameRequistMessage() {
        System.out.print("Enter first name: ");
    }

    public void printLastNameRequistMessage() {
        System.out.print("Enter last name: ");
    }

    public void printEmailRequistMessage() {
        System.out.print("Enter email: ");
    }

    public void printCountryCodeRequistMessage() {
        System.out.print("Enter phone number (country code): ");
    } 

    public void printPhoneNumberRequistMessage() {
        System.out.print("Enter phone number (number): ");
    }

    public void printZipCodeRequistMessage() {
        System.out.print("Enter address (zip code): ");
    }

    public void printCountryRequistMessage() {
        System.out.print("Enter address (country): ");
    }

    public void printCityRequistMessage() {
        System.out.print("Enter address (city): ");
    }

    public void printContact(Contact contact) {
        System.out.println(contact.toString());
    }

    public void printContacts(ArrayList<Contact> Contacts) {
        printTitle("All Contacts");
        for (Contact contact : Contacts) {
            System.out.println(contact.toString());
        }
    }
}