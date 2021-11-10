package ex1fp4;

import Queue.EmptyCollectionException;
import Queue.LinkedQueue;

/**
 *
 * @author joaoc
 */
public class Ex1FP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        
        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(2);
            queue.dequeue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        //System.out.println(queue.isEmpty());
        //System.out.println(queue.first());
        System.out.println(queue.toString());
    }
    
}
