package Chapter_15_EventDrivenProgrammingAndAnimations;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

// Class demonstrates the use of a listener to process a value change in an observable object

public class ObservablePropertyDemo {
    public static void main(String[] args) {
        DoubleProperty balance = new SimpleDoubleProperty();
        balance.addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {        // Anonymous inner class can be simplified using a lambda expression
                System.out.println("The new value is " + balance.doubleValue());
            }
        });

        balance.set(4.5);
        // When this line is executed, it causes a change in balance, which notifies the listener by
        // invoking the listener’s invalidated method.
    }
}
