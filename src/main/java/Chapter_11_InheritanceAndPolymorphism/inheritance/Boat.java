package Chapter_11_InheritanceAndPolymorphism.inheritance;

// Java program to illustrate the concept of inheritance.

public class Boat {

    // Boat class has two fields
    public String make;
    public int speed;

    // Boat class has one constructor.
    public Boat(String make, int speed){
        this.make = make;
        this.speed = speed;
    }

    // Boat class has three methods.
    public void applyBreak(int decrement){
        speed -= decrement;
    }

    public void speedUp(int increment){
        speed += increment;
    }

    // toString() method to print info of boat.
    public String toString(){
        return("The make of the boat is " + make + "\n"
        + "Speed of boat is " + speed + "mph");
    }
}
