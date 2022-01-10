package Interfaces;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.BinaryTreeADT;

/**
 *
 * @author joaoc
 */
public interface HeapADT<T> extends BinaryTreeADT<T>{
    public void addElement(T obj);
    public T removeMin() throws EmptyCollectionException;
    public T findMin();
}
