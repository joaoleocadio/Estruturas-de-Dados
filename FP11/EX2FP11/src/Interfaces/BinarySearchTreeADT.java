package Interfaces;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;

/**
 *
 * @author joaoc
 */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T>{
    public void addElement (T element);
    public T removeElement (T targetElement) throws ElementNotFoundException, ListsException;
    public void removeAllOccurrences (T targetElement) throws ElementNotFoundException, ListsException;
    public T removeMin() throws EmptyCollectionException, ListsException, ElementNotFoundException;
    public T removeMax() throws EmptyCollectionException, ListsException, ElementNotFoundException;
    public T findMin() throws EmptyCollectionException;
    public T findMax() throws EmptyCollectionException;
}
