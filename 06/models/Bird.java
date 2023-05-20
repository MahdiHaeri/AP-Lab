package models;

public abstract class Bird extends Animal {
    double heightOfFlight;

    public Bird(String name, int age, String attributes, double heightOfFlight) {
        super(name, age, attributes);
        this.heightOfFlight = heightOfFlight;
    }

    public double getHeightOfFlight() {
        return this.heightOfFlight;
    }

    public void setHeightOfFlight(double heightOfFlight) {
        if (heightOfFlight > 0) {
            this.heightOfFlight = heightOfFlight;
        }
    }

    public String toString() {
        return super.toString() + "\nHeight of Flight: " + this.heightOfFlight;
    }
}