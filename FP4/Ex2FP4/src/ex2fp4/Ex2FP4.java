package ex2fp4;

/**
 *
 * @author joaoc
 */
public class Ex2FP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
        
        CircularArrayQueue<Integer> queue = new CircularArrayQueue<>();
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(8);
        queue.dequeue();
        System.out.println(queue.getFront());
        System.out.println(queue.getRear());
        
        System.out.println(queue.toString());
        
        
        
        
    }
    
}
