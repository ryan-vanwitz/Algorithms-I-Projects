package implementation;

import java.util.Arrays;
import structures.RemovalArray;

/**
 * Implementation of the RemovalArray interface using an incremental array strategy.
 * The array grows incrementally as elements are added.
 * @param <E> the type of elements stored in the array
 */
public class IncrementalArray<E> implements RemovalArray<E> {
    
    private Object[] items; // Array to store elements
    private int size; // Current size of the array
    
    /**
     * Constructs a new IncrementalArray instance with initial capacity of 1.
     */
    public IncrementalArray() {
        this.items = new Object[1]; // Initialize array with initial capacity of 1
        this.size = 0; // Initialize size to 0
    }
    
    /**
     * Adds the specified element to the end of the array.
     * If the array is full, it doubles its capacity before adding the element.
     * @param e the element to be added
     * @return true if the element is successfully added
     */
    public boolean add(E e) {
        if (items.length == size) {
            items = Arrays.copyOf(items, items.length + 1); // Double the array capacity
        }
        items[size] = e; // Add the element to the end of the array
        size++; // Increment the size
        return true;
    }
    
    /**
     * Removes the element at the specified index from the array.
     * @param index the index of the element to be removed
     * @return true if the element is successfully removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public boolean remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Failed removing element. Index Out Of Bounds");
        }
        System.arraycopy(items, index + 1, items, index, size - index - 1); // Shift elements to the left
        size--; // Decrement the size
        items[size] = null; // Nullify the last element
        return true;
    }
    
    /**
     * Removes the first occurrence of the specified element from the array.
     * @param e the element to be removed
     * @return true if the element is successfully removed
     */
    public boolean remove(E e) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(e)) {
                remove(i); // Call remove(int index) to remove the element at index i
                return true;
            }
        }
        return true;
    }
    
    /**
     * Retrieves the element at the specified index from the array.
     * @param index the index of the element to be retrieved
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
     public E find(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            return (E) items[index];
        }
    
    /**
     * Returns the current size of the array.
     * @return the size of the array
     */
    public int size() {
        return size;
    }
    
}