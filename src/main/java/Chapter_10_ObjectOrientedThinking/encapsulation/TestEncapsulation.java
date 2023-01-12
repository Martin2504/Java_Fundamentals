package Chapter_10_ObjectOrientedThinking.encapsulation;

public class TestEncapsulation {
    public static void main(String[] args) {

        Employee object = new Employee();

        // Setting values of variables.
        object.setName("Martin");
        object.setAge(21);
        object.setJob_title("Manager");

        // Displaying values of the variables.
        System.out.println("Employee name: " + object.getName());
        System.out.println("Employee age: " + object.getAge());
        System.out.println("Employee job title: " + object.getJob_title());

        // Due to encapsulation, direct access to Employee's attributes is not possible.
        // System.out.println("Employee name: " + object.getName());

    }
}
