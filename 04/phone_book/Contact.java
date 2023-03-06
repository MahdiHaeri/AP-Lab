public class Contact {

    public Contact(String group, String email, String firstName, String lastName, PhoneNumber phoneNumber, Address address) {
       this.group = group;
       this.email = email;
       this.firstName = firstName;
       this.lastName = lastName;
       this.phoneNumber = phoneNumber;
       this.address = address; 
    }

    private String group;
    private String email;
    private String firstName; 
    private String lastName;
    private PhoneNumber phoneNumber;
    private Address address;
}