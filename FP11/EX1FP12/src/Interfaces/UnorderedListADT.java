package Interfaces;

import Exceptions.ListsException;

/**
 *
 * @author joaoc
 */
public interface UnorderedListADT<T> extends ListADT<T> {
    
    public void addToFront(T element) throws ListsException;
    public void addToRear(T element) throws ListsException;
    public void addAfter(T element, T target) throws ListsException;   
}
