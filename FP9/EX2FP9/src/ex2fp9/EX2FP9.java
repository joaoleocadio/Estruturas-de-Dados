/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2fp9;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;
import Tree.ArrayBinaryTree;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public class EX2FP9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ListsException, ElementNotFoundException, EmptyCollectionException {
        String[] elements = {"a", "b", "c", "d", "e"};
        ArrayBinaryTree<String[]> tree = new ArrayBinaryTree<>(elements);

        //Iterator c = tree.iteratorInOrder();
        
        
        //Iterator c = tree.iteratorPreOrder();  
        //Iterator c = tree.iteratorPostOrder();
        Iterator c = tree.iteratorLevelOrder();
        
        
        while (c.hasNext()) {
            if (tree != null) {
                System.out.println(c.next() + " ");
            }
            
        }

    }
    
}
