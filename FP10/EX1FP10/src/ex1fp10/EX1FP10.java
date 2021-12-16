package ex1fp10;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;
import Tree.LinkedBinarySearchTree;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public class EX1FP10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ListsException, ElementNotFoundException, EmptyCollectionException {
        LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree();
        Iterator<Integer> itr;
        
        
        tree.addElement(10);
        tree.addElement(5);
        tree.addElement(15);
        tree.addElement(3);
        tree.addElement(7);
        tree.addElement(13);
        tree.addElement(2);
        tree.addElement(4);
        
        System.out.println("");
        //tree.removeMin();
        //tree.removeMax();
        tree.removeElement(5);
        //itr = tree.iteratorInOrder();
        itr = tree.iteratorLevelOrder();
        while (itr.hasNext()) {
            System.out.println(itr.next() + " ");
        }
        
        System.out.println("Min: " + tree.findMin());
        System.out.println("Max: " + tree.findMax());
        /*
        tree.removeAllOccurrences(2);
        System.out.println("-----------");
        itr = tree.iteratorInOrder();
        while (itr.hasNext()) {
            System.out.println(itr.next() + " ");
        }*/
    }    
}