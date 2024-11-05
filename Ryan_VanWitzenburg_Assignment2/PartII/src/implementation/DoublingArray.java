package implementation;

import java.util.Arrays;
import structures.RemovalArray;

/**
 * DoublingArray is an implementation of the RemovalArray interface that
 * dynamically resizes its internal array when necessary by doubling its
 * capacity. This class allows for adding, removing, finding elements by index,
 * getting the size, and clearing the array.
 */
public class DoublingArray<E> implements RemovalArray<E> {
	
    // Array to store elements
    private Object[] items;
    // Current size of the array
    private int size;
    
    /**
     * Constructs a DoublingArray with an initial capacity of 1 and size of 0.
     */
    public DoublingArray() {
        this.items = new Object[1];
        this.size = 0;
    }
    
    /**
     * Adds the specified element to the end of the array.
     * If the array is full, it doubles its capacity before adding the element.
     *
     * @param e the element to be added
     * @return true if the element is successfully added
     */
    public boolean add(E e) {
        if (items.length == size) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        items[size] = e;
        size++;
        return true;
    }
    
    /**
     * Removes the element at the specified index from the array.
     * Shifts subsequent elements to the left to close the gap.
     *
     * @param index the index of the element to be removed
     * @return true if the element is successfully removed
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public boolean remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Failed removing element. Index Out Of Bounds");
        }
        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        items[size - 1] = null; // Nullify the last element
        size--; // Decrement size
        return true;
    }
    
    /**
     * Removes the first occurrence of the specified element from the array.
     *
     * @param e the element to be removed
     * @return true if the element is successfully removed
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
     * Returns the element at the specified index in the array.
     *
     * @param index the index of the element to return
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
     * Returns the number of elements in the array.
     *
     * @return the number of elements in the array
     */
    public int size() {
        return size;
    }
    
}