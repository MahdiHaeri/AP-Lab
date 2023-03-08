package models;

import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<Contact> contacts;    

    public PhoneBook() {
        this.contacts = new ArrayList<Contact>();
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void deleteContact(String firstName, String lastName) {
        for (Contact contact: this.contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                this.contacts.remove(contact);
                break;
            }
        }
    }

    public Contact findContact(String firstName, String lastName) {
        for (Contact contact: this.contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                return contact;
            }
        }
        
        return null;
    }
    
    public ArrayList<Contact> findContacts(String group) {
        ArrayList<Contact> result = new ArrayList<Contact>();

        for (Contact contact: this.contacts) {
            if (contact.getGroup().equals(group)) {
                result.add(contact);
            }
        }

        return result;
    }

    public void printContacts() {
        System.out.println("---------- Contacts ----------");
        for (Contact contact: this.contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }

    public ArrayList<Contact> getAllContacts() {
        return this.contacts;
    }
}