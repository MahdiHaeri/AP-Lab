package models;

public class Note {
    private String name;
    private String text;
    private int day, month, year;    

    public Note(String name, String text, int day, int month, int year) {
        this.name = name;
        this.text = text;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getName() { return name; }
    public String getText() { return text; }
    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    public void setName(String name) { this.name = name; }
    public void setText(String text) { this.text = text; }
    public void setDay(int day) { this.day = day; }
    public void setMonth(int month) { this.month = month; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return "Note{" + "name=" + name + ", text=" + text + ", day=" + day + ", month=" + month + ", year=" + year + '}';
    }
}