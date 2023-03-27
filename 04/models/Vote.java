package models;

public class Vote {
    private final Person voter;
    private final String date;

    public Vote(Person voter, String date) {
        this.voter = voter;
        this.date = date;
    }

    public Person getVoter() { return voter; }
    public String getDate() { return date; }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Vote)) {
            return false;
        }

        Vote vote = (Vote) obj;

        return vote.getVoter().equals(this.getVoter()) && vote.getDate().equals(this.getDate());
    }

    @Override
    public int hashCode() {
        return voter.hashCode() + date.hashCode();
    }
}