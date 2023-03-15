package models; 

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class Voting {
    private int type;
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private ArrayList<Person> voters;

    public Voting(int type, String question, boolean isAnonymous) {
        this.type = type;
        this.question = question; 
        this.isAnonymous = isAnonymous;
    }

    public String getQuestion() { return question; }

    public void setQuestion(String question) { this.question = question; }

    public ArrayList<String> getChoices() {
        ArrayList<String> resultArray = new ArrayList<String>();

        for (String key: choices.keySet()) {
            resultArray.add(key);
        }

        return resultArray;
    }

    public void createChoice(String choice) {
        HashSet<Vote> value = new HashSet<Vote>();
        choices.put(choice, value);
    }
}