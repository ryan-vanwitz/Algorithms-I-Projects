package structures;
import java.util.*;

public class ConstrainedCapacityBag<E> implements BagADT{
    // *** Data members (fields) ***
    private E[] items;
    private int numItems;
    
    // *** Constructor ***
    public ConstrainedCapacityBag(int size) {
        items = (E[])(new Object[size]);
        numItems = 0;
    }
    
    // *** Bag ADT methods ***
    @Override
    public void add(E item) {
        if (item == null) {
            throw new IllegalArgumentException("Bag does not allow null elements");
        } 
        if (numItems == items.length) { 
            expandArray(); 
        }
        items[numItems] = item;
        numItems++;
    }
    
    public E remove() throws NoSuchElementException {
        if (numItems < 1) { throw new NoSuchElementException(); }
        numItems--;
        return items[numItems];
    }

    public boolean isEmpty() { return numItems == 0; }
    
    public Iterator<E> iterator() {
 
 
  
 
    }
    
}
