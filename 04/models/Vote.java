package models;

public class Vote {
    private final Person voter;
    private final String date;

    public Vote(Person voter, String date) {
        this.voter = voter;
        this.date = date;
    }
}