package controller;

import models.*;
import java.util.ArrayList;

public class PhoneBookController {
    private PhoneBook phoneBook;

    public PhoneBookController(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void addContact(String group, String email, String firstName, String lastName,
        String countryCode, String number, String zipCode, String country, String city) {
        Contact newContact = new Contact(group, email, firstName, lastName,
            new PhoneNumber(countryCode, number),
            new Address(zipCode, country, city));
        phoneBook.addContact(newContact);
    }

    public void deleteContact(String firstName, String lastName) {
        phoneBook.deleteContact(firstName, lastName);
    }

    public Contact findContact(String firstName, String lastName) {
        return phoneBook.findContact(firstName, lastName);
    }

    public ArrayList<Contact> findContacts(String group) {
        return phoneBook.findContacts(group);
    }

    public ArrayList<Contact> getAllContact() {
        return phoneBook.getAllContacts();
    }
}