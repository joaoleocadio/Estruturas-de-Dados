package Queue;

/**
 *
 * @author joaoc
 */
public class CircularArrayQueue<T> implements QueueADT<T>{
    
    private final int DEFAULT_CAPACITY = 4;
    
    private T[] queue;
    private int rear;
    private int front;
    private int size;

    public CircularArrayQueue() {
        this.queue = (T[]) new Object[DEFAULT_CAPACITY];
        rear = front = size = 0;
    }

    public int getRear() {
        return rear;
    }

    public int getFront() {
        return front;
    }
    
    
    

    @Override
    public void enqueue(T element) throws EmptyCollectionException{
        if (size() == this.queue.length) {
            expandQueue();
        }
        
        queue[rear] = element;
        rear = (rear +1) % queue.length;
        size++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        T tmp = queue[front];
        front = (front + 1) % queue.length;
        size--;
        
        return tmp;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public int size() {
        return this.size;
    }
    
    private void expandQueue() {
        T[] tmp = (T[]) new Object[queue.length + DEFAULT_CAPACITY];
        int tmpFront = this.front;
        
        for (int i = 0; i < queue.length; i++) {
            tmp[i] = queue[tmpFront];
            tmpFront = (tmpFront + 1) % queue.length;
        }
        front = 0;
        rear = size();
        
        queue = tmp;
    }
    
    @Override
    public String toString(){
        String text = "";
        int start = front;
        
        while(start != rear){
            text += queue[start].toString() + " ";
            start = (start + 1) % queue.length;
        }
        return text;
    }
    
}
