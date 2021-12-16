package ex2fp10;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;
import Tree.ArrayBinarySearchTree;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public class EX2FP10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ListsException, ElementNotFoundException, EmptyCollectionException {
        ArrayBinarySearchTree<Integer> tree = new ArrayBinarySearchTree<>();
        Iterator<Integer> itr;
        
        tree.addElement(10);
        tree.addElement(5);
        tree.addElement(15);
        tree.addElement(3);
        tree.addElement(7);
        tree.addElement(13);
        tree.addElement(5);
        
        //tree.removeAllOccurrences(5);
        tree.removeMax();
        tree.removeMin();
        System.out.println("Máx: " + tree.findMax());
        System.out.println("Mín: " + tree.findMin());
        
        itr = tree.iteratorInOrder();
        while (itr.hasNext()) {
            System.out.println(itr.next() + " ");
        }
        
    }
    
}
