package Chapter_24_ImplementingListsStacksQueuesAndPriorityQueues;
import java.util.Collection;

// Defines the methods for manipulating a list

public interface MyList<E> extends Collection<E>{
    /** Add a new element at the specified index in this list */
    public void add(int index, E e);

    /** Return the element from this list at the specified index */
    public E get (int index);

    /** Return the index of the first matching element in this list.
     * Return −1 if no match. */
    public int indexOf(Object e);

    /** Return the index of the last matching element in this list
     * Return −1 if no match. */
    public int lastIndexOf(E e);

    /** Remove the element at the specified position in this list
     * Shift any subsequent elements to the left.
     * Return the element that was removed from the list. */
    public E remove(int index);

    /** Replace the element at the specified position in this list
     * with the specified element and returns the new set. */
    public E set(int index, E e);

    @Override   /** Add a new element at the end of this list */
    public default boolean add(E e){
        add(size(), e);
        return true;
    }

    @Override    /** Return true if this list contains no elements */
    public default boolean isEmpty() {
        return size() == 0;
    }

    @Override   /** Remove the first occurrence of the element e
     * from this list. Shift any subsequent elements to the left.
     * Return true if the element is removed. */
    public default boolean remove(Object e){
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        } else {
            return false;
        }
    }

    @Override       // implement containsAll
    public default boolean containsAll(Collection<?> c) {
        // Left as exercise
        return true;
    }

    @Override       // implement addAll
    public default boolean addAll(Collection<? extends E> c) {
        // Left as an exercise
        return true;
    }

    @Override       // implement removeAll
    public default boolean removeAll(Collection<?> c) {
        // Left as an exercise
        return true;
    }

    @Override       // implement retainAll
    public default boolean retainAll(Collection<?> c) {
        // Left as an exercise
        return true;
    }

    @Override       // implement toArray()
    public default Object[] toArray() {
        // Left as an exercise
        return null;
    }

    @Override       // implement toArray(T[])
    public default <T> T[] toArray(T[] array) {
        // Left as an exercise
        return null;
    }

    /* The methods isEmpty(), add(E), remove(E), containsAll, addAll, removeAll,
    retainAll, toArray(), and toArray(T[]) are defined in the Collection interface. Since
    these methods are implementable in MyList, they are overridden in the MyList interface
    as default methods.*/

}
