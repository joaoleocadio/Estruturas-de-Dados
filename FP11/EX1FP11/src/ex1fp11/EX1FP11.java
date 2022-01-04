package ex1fp11;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;
import Tree.ArrayMinHeap;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public class EX1FP11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ListsException, ElementNotFoundException, EmptyCollectionException {
        ArrayMinHeap<Integer> heap = new ArrayMinHeap<>();
        Iterator<Integer> itr;
        
        heap.addElement(3);
        heap.addElement(5);
        heap.addElement(4);
        heap.addElement(8);
        heap.addElement(7);
        heap.addElement(9);
        
        heap.removeMin();
        
        heap.addElement(2);
        System.out.println("Min: " + heap.findMin());
        itr = heap.iteratorPreOrder();
        
        while (itr.hasNext()) {            
            System.out.println(itr.next() + " ");
        }
    }
    
}
