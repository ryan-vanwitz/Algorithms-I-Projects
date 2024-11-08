package implementation;

import java.util.Arrays;
import structures.RemovalArray;

/**
 * Implementation of RemovalArray using a SwappingArray strategy.
 * 
 * This implementation allows for efficient removal of elements by swapping the
 * element to be removed with the last element in the array. This approach
 * eliminates the need to shift elements and improves removal performance,
 * especially for larger arrays.
 * 
 * @param <E> the type of elements stored in the array
 */
public class SwapingArray<E> implements RemovalArray<E> {
    
    // Internal array to store elements
    private Object[] items;
    
    // Current size of the array
    private int size;
    
    /**
     * Constructs a SwappingArray with an initial capacity of 1.
     */
    public SwapingArray() {
        this.items = new Object[1];
        this.size = 0;
    }
    
    /**
     * Adds an element to the array.
     * 
     * @param e the element to be added
     * @return true if the element is successfully added, false otherwise
     */
    public boolean add(E e) {
        if (size == items.length) {
            resizeArray();
        }
        items[size++] = e;
        return true;
    }

    /**
     * Removes the element at the specified index.
     * 
     * @param index the index of the element to be removed
     * @return true if the element is successfully removed, false otherwise
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        items[index] = items[size - 1];
        items[size - 1] = null;
        size--; 
        return true;
    }

    /**
     * Removes the specified element from the array.
     * 
     * @param e the element to be removed
     * @return true if the element is successfully removed, false otherwise
     */
    public boolean remove(E e) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(e)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Resizes the internal array by doubling its capacity.
     */
    private void resizeArray() {
        Object[] newArray = new Object[items.length * 2];
        System.arraycopy(items, 0, newArray, 0, items.length);
        items = newArray;
    }
    
    /**
     * Retrieves the element at the specified index.
     * 
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public E find(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (E) items[index];
    }

    /**
     * Returns the current size of the array.
     * 
     * @return the size of the array
     */
    public int size() {
        return size;
    }
    
}