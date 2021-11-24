/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmackStack;

/**
 *
 * @author joaoc
 */
public interface SmackStackADT<T> {
    public void push(T element);
    public T pop() throws EmptyCollectionException;
    public T peek() throws EmptyCollectionException;
    public boolean isEmpty();
    public int size();
    public T smack() throws EmptyCollectionException;

    @Override
    public String toString();
}
