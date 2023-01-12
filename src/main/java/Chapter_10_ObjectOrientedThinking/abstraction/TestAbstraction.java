package Chapter_10_ObjectOrientedThinking.abstraction;

public class TestAbstraction {
    public static void main(String[] args){

        Shape s1 = new Circle("Red", 2.5);
        Shape s2 = new Rectangle("Blue", 6, 3);

        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
}
