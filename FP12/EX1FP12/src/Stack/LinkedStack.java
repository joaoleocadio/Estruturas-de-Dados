package Stack;

import Exceptions.EmptyCollectionException;
import Interfaces.StackADT;

/**
 *
 * @author joaoc
 */
public class LinkedStack<T> implements StackADT<T>{
    private int size = 0;
    private LinearNode<T> first;

    public LinkedStack() {
        this.first = null;
    }

    @Override
    public void push(T element) {
        
        if (size() == 0) {
            this.first = new LinearNode<T>(null, element );
        } else {
            LinearNode<T> tmp = new LinearNode<T>(first, element);
            this.first = tmp;
        }
        this.size++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTY_COLLECTION);
        } else {
            LinearNode<T> topoAtual = this.first;
            this.first = first.getNext();
            this.size--;
            return topoAtual.getElement();
        }
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException(EmptyCollectionException.EMPTY_COLLECTION);
        
        else {
            return this.first.getElement();
        }
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String text = "";
        
        LinearNode<T> tmp = this.first;
        
        while (tmp != null) {
            text += "Node Hash: " + tmp.hashCode() + " ------> Content: " + tmp.getElement() + "\n";
            tmp = tmp.getNext();
        }
        
        return text;
    }
    
    
}
