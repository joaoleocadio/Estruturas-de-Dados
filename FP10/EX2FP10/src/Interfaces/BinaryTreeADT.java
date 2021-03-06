package Interfaces;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public interface BinaryTreeADT<T> {
    public T getRoot() throws EmptyCollectionException;
    public String toString(); 
    public boolean isEmpty();
    public int size() throws EmptyCollectionException;
    public boolean contains (T targetElement) throws ElementNotFoundException;
    public T find (T targetElement) throws ElementNotFoundException;    
    public Iterator<T> iteratorInOrder() throws ListsException;
    public Iterator<T> iteratorPreOrder() throws ListsException;
    public Iterator<T> iteratorPostOrder() throws ListsException;
    public Iterator<T> iteratorLevelOrder() throws ListsException, ElementNotFoundException, EmptyCollectionException;
}
