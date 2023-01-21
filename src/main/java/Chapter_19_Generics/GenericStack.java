package Chapter_19_Generics;


// Demonstrates the use of generics to detect errors at compile time rather then runtime

public class GenericStack<E> {      // Generic type E declared
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();      // Generic array list

    public int getSize() {
        return list.size();
    }

    public E peek() {
        return list.get(getSize() - 1);
    }

    public void push(E o) {     // o of type E
        list.add(o);
    }

    public E pop() {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
    @Override
    public String toString() {
        return "stack: " + list.toString();
    }

    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<>();         // Create the stack
        stack1.push("London");
        stack1.push("Paris");
        stack1.push("Berlin");

        for (int i = 0; i < stack1.getSize() + 1; i++){                 // pops items off the stack
            System.out.println(stack1.pop());
        }
    }
}
