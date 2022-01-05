package ex3fp11;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;
import Tree.LinkedHeap;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public class EX3FP11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ListsException, ElementNotFoundException, EmptyCollectionException {
        LinkedHeap<Integer> heap = new LinkedHeap<>();
        Iterator<Integer> itr;
        
        heap.addElement(6);
        heap.addElement(4);
        heap.addElement(5);
        heap.addElement(3);
        heap.addElement(2);
        heap.addElement(1);
        heap.addElement(5);
        heap.addElement(4);
        heap.addElement(6);
        heap.addElement(5);
        heap.addElement(4);
        heap.addElement(6);
        
        System.out.println("Excpeted 1. Result : " + heap.removeMin());
        itr = heap.iteratorInOrder();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("Excepted : 2. Result : " + heap.findMin());
    }
    
}
