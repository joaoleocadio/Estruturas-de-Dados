package Queue;

import Interfaces.QueueADT;
import EmptyCollectionException.EmptyCollectionException;

/**
 *
 * @author joaoc
 */
public class LinkedQueue<T> implements QueueADT<T>{
    private LinearNode<T> front;
    private LinearNode<T> rear;
    private int count;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.count = 0;
    }
    

    @Override
    public void enqueue(T element) {
        LinearNode<T> tmp = new LinearNode<>(null, element);
        
        if (size() == 0) {
            front = tmp;
            rear = front;
        } else {
            rear.setNext(tmp);
            rear = rear.getNext();
        }
        
        count++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException{
        T tmp = null;
        
        if (size() == 1) {
            tmp = front.getElement();
            this.front = this.rear = null;    
            count--;
        } else if (size() != 0) {
            tmp = front.getElement();
            this.front = front.getNext();
            count--;
        } else {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTY_COLLECTION);
        }
        
        return tmp;
    }

    @Override
    public T first() throws EmptyCollectionException{
        if (isEmpty()) throw new EmptyCollectionException(EmptyCollectionException.EMPTY_COLLECTION);
        
        return this.front.getElement();
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public String toString() {
        LinearNode<T> topo = this.front;
        String text = "";
        
        while (topo != null) {
            text += topo.toString();
            topo = topo.getNext();
        }
        return text;
    }
}
