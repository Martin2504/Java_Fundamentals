package Chapter_10_ObjectOrientedThinking.encapsulation;

//My Java program to demonstrate encapsulation
public class Employee {

    // Declared all variables as private.
    // They can only be accessed by public methods of this class.
    private String name;
    private int age;
    private String job_title;

    // Get method to access private variable name.
    public String getName() { return name; }

    // Get method to access private variable age.
    public int getAge() { return age; }

    // Get method to access private variable job_title.
    public String getJob_title() { return job_title; }

    // Set method to access private variable name.
    public void setName(String newName) { name =  newName; }

    // Set method to access private variable age.
    public void setAge(int newAge) { age =  newAge; }

    // Set method to access private variable job_title.
    public void setJob_title(String newJob_title) { job_title =  newJob_title; }


}
