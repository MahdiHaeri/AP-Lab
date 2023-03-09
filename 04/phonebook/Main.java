import controller.PhoneBookController;
import models.PhoneBook;
import views.PhoneBookView;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        PhoneBookView phoneBookView = new PhoneBookView();
        PhoneBookController phoneBookController = new PhoneBookController(phoneBook, phoneBookView);

        phoneBookController.handelMenu();
    }
}