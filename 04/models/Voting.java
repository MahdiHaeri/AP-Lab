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
}