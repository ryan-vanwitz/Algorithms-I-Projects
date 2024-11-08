package structures;

/**
 * The RemovalArray interface defines the contract for arrays that support element removal.
 * Implementations of this interface provide methods for adding elements, removing elements
 * by index or by value, and clearing the array.
 *
 * @param <E> the type of elements stored in the array
 */
public interface RemovalArray<E> {

    /**
     * Adds the specified element to the array.
     *
     * @param e the element to be added
     * @return true if the element is successfully added, false otherwise
     */
    public boolean add(E e);

    /**
     * Removes the element at the specified index from the array.
     *
     * @param index the index of the element to be removed
     * @return true if the element is successfully removed, false otherwise
     */
    public boolean remove(int index);

    /**
     * Removes the first occurrence of the specified element from the array, if present.
     *
     * @param e the element to be removed
     * @return true if the element is successfully removed, false otherwise
     */
    public boolean remove(E e);

}