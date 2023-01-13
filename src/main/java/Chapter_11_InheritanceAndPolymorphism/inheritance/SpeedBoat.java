package Chapter_11_InheritanceAndPolymorphism.inheritance;

// Derived class.
public class SpeedBoat extends Boat {

    // The SpeedBoat child class adds one more field.
    public int weight;

    // The SpeedBoat subclass has one constructor
    public SpeedBoat(String make, int speed, int startWeight) {
        super(make, speed);
        weight = startWeight;
    }

    // The SpeedBoat subclass adds one more method
    public void setWeight(int newWeight) {
        weight = newWeight;
    }

    // Overriding toString() method of Boat to print more info
    @Override public String toString(){
        return(super.toString() + "\nWeight is " + weight + "kg");
    }
}
