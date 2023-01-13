package Chapter_11_InheritanceAndPolymorphism.inheritance;

// Driver class.
public class TestInheritance {
    public static void main(String args[]){
        SpeedBoat fastOne =  new SpeedBoat("Aquila", 50, 1000 );
        System.out.println(fastOne.toString());

        fastOne.applyBreak(1);
        System.out.println("Speed is now " + fastOne.speed);

        fastOne.setWeight(990);
        System.out.println("Weight is now " + fastOne.weight);

    }
}
