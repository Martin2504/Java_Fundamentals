package Chapter_10_ObjectOrientedThinking.abstraction;

// Java program to illustrate the concept of Abstraction.
abstract class Shape {
    String color;

    // These are abstract methods. (just declared)
    abstract double area();
    public abstract String toString();

    // This abstract class has one constructor.
    public Shape(String color){
        System.out.println("Shape constructor called ");
        this.color = color;
    }

    // This is a concrete method.
    public String getColor() { return color; }
}
