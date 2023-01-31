package Chapter_34_JavaDatabaseProgramming;
import java.sql.*;

// Suppose the function studentFound is already created in the database. This program gives an
// example that tests this function using callable statements.

public class TestCallableStatement {
    /** Creates new form TestTableEditor */
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/javabook", "scott", "tiger");

        // Create a callable statement
        CallableStatement callableStatement = connection.prepareCall(
                "{? = call studentFound(?, ?)}");

        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter student's first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter student's last name: ");
        String lastName = input.nextLine();

        callableStatement.setString(2, firstName);
        callableStatement.setString(3, lastName);
        callableStatement.registerOutParameter(1, Types.INTEGER);
        callableStatement.execute();

        if (callableStatement.getInt(1) >= 1)
            System.out.println(firstName + " " + lastName + " is in the database");
        else
            System.out.println(firstName + " " + lastName + " is not in the database");
    }
}
