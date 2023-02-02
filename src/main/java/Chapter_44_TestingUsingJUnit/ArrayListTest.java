package Chapter_44_TestingUsingJUnit;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class ArrayListTest {
    private ArrayList<String> list = new ArrayList<String>();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testInsertion() {       // Testing insertion
        list.add("Beijing");
        // The method reports success if the two objects are the same using the equals method.
        assertEquals("Beijing", list.get(0));
        list.add("Shanghai");
        list.add("Hongkong");
        assertEquals("Hongkong", list.get(list.size() - 1));
    }

    @Test
    public void testDeletion() {        //  Testing deletion
        list.clear();
        // The method reports success if the booleanExpression evaluates true.
        assertTrue(list.isEmpty());

        list.add("A");
        list.add("B");
        list.add("C");
        list.remove("B");
        assertEquals(2, list.size());   // Tests if list is of size 2
    }
}
