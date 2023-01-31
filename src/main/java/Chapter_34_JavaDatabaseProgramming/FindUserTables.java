package Chapter_34_JavaDatabaseProgramming;
import java.sql.*;

/*
You can identify the tables in the database through database metadata using the getTables
method. This program displays all the user tables in the javabook database on a local MySQL
database
 */

public class FindUserTables {
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {
        // Load the JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");

        // Connect to a database
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/javabook", "scott", "tiger");
        System.out.println("Database connected");

        DatabaseMetaData dbMetaData = connection.getMetaData();     // database metadata

        ResultSet rsTables = dbMetaData.getTables(null, null, null,     // obtain tables
                new String[] {"TABLE"});
        System.out.print("User tables: ");
        while (rsTables.next())
            System.out.print(rsTables.getString("TABLE_NAME") + " ");           // get table names

        // Close the connection
        connection.close();
    }
}
