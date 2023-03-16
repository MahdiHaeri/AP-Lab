import models.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        
        ArrayList<String> choices_1 = new ArrayList<String>();

        choices_1.add("Yes");
        choices_1.add("No");
        choices_1.add("I don't know");

        votingSystem.createVoting("Are you attend in class for friday?", false, 2, choices_1);
        votingSystem.createVoting("Are you a boy?", false, 2, choices_1);
        
        Person person_1 = new Person("mahdi", "haeri");
        Person person_2 = new Person("ali", "jafari");
        Person person_3 = new Person("mobin", "baghi");
        Person person_4 = new Person("fatemeh", "yousofi");
        Person person_5 = new Person("raha", "mohammadi");

        ArrayList<String> choices_2 = new ArrayList<String>();
        choices_2.add(choices_1.get(0));
        choices_2.add(choices_1.get(2));

        votingSystem.vote(0, person_1, choices_2);
        votingSystem.vote(1, person_2, choices_1);

        votingSystem.printResult(0);
        System.out.println("------------------------------------------");
        votingSystem.printResult(1);
        System.out.println("------------------------------------------");
    }
}