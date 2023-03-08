package models;

public class Contact {
    private String group;
    private String email;
    private String firstName;
    private String lastName;
    private PhoneNumber phoneNumber;
    private Address address;

    public Contact(String group, String email, String firstName, String lastName, PhoneNumber phoneNumber, Address address) {
        this.group = group;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    } 

    public String getGroup() {
        return group;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public String toString() {
        return firstName + " " + lastName + "\n" +
                "Group: " + group + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phoneNumber.toString() + "\n" +
                "Address: " + address.toString() + "\n";
    }
}