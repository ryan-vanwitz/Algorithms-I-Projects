package structures;

import java.util.*;

public interface BagADT<E> {
    public void add(E item);
    public E remove() throws NoSuchElementException;
    public boolean isEmpty();
    public Iterator<E> iterator();
}