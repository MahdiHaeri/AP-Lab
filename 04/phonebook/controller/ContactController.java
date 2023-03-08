package controller;

import models.PhoneBook;
import models.Contact;
import java.util.ArrayList;

public class ContactController {
    private PhoneBook phoneBook;

    public ContactController(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void addContact(Contact contact) {
        phoneBook.addContact(contact);
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