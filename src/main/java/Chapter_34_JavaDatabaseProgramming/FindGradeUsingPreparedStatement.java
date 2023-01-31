package Chapter_34_JavaDatabaseProgramming;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

/*
This example does exactly the same thing as FindGrade except that it uses the prepared
statement to dynamically set the parameters.
The PreparedStatement interface, extending Statement, is used to execute a precompiled
SQL statement with or without parameters.
Since the SQL statements are precompiled, they are efficient for repeated executions.
*/

public class FindGradeUsingPreparedStatement extends Application {
    // PreparedStatement for executing queries
    private PreparedStatement preparedStatement;
    private TextField tfSSN = new TextField();
    private TextField tfCourseId = new TextField();
    private Label lblStatus = new Label();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Initialize database connection and create a Statement object
        initializeDB();

        Button btShowGrade = new Button("Show Grade");
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("SSN"), tfSSN,
                new Label("Course ID"), tfCourseId, (btShowGrade));

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox, lblStatus);

        tfSSN.setPrefColumnCount(6);
        tfCourseId.setPrefColumnCount(6);
        btShowGrade.setOnAction(e -> showGrade());

        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox, 420, 80);
        primaryStage.setTitle("FindGrade"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private void initializeDB() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");

            // Establish a connection
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost/javabook", "scott", "tiger");
            System.out.println("Database connected");

            String queryString = "select firstName, mi, " +                         // A prepared query string is defined
                    "lastName, title, grade from Student, Enrollment, Course " +
                    "where Student.ssn = ? and Enrollment.courseId = ? " +
                    "and Enrollment.courseId = Course.courseId";

            // Create a statement
            preparedStatement = connection.prepareStatement(queryString);           // An SQL prepared statement is obtained
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showGrade() {
        String ssn = tfSSN.getText();
        String courseId = tfCourseId.getText();
        try {
            preparedStatement.setString(1, ssn);               // The actual values of ssn and courseId are set to the parameters
            preparedStatement.setString(2, courseId);
            ResultSet rset = preparedStatement.executeQuery();                  // Executes the prepared statement

            if (rset.next()) {
                String lastName = rset.getString(1);
                String mi = rset.getString(2);
                String firstName = rset.getString(3);
                String title = rset.getString(4);
                String grade = rset.getString(5);

                // Display result in a label
                lblStatus.setText(firstName + " " + mi +
                        " " + lastName + "'s grade on course " + title + " is " +
                        grade);
            } else {
                lblStatus.setText("Not found");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}