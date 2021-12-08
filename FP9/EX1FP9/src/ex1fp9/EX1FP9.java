package ex1fp9;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Tree.BinaryTreeNode;
import Tree.LinkedBinaryTree;
import Exceptions.ListsException;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public class EX1FP9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ListsException, ElementNotFoundException, EmptyCollectionException {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>("A");
        
        BinaryTreeNode<String> n1 = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> n2 = new BinaryTreeNode<>("C");
        
        BinaryTreeNode<String> n3 = new BinaryTreeNode<>("D");
        BinaryTreeNode<String> n4 = new BinaryTreeNode<>("E");
        
        tree.root.setLeft(n1);
        tree.root.setRight(n2);
        
        n1.setLeft(n3);
        n1.setRight(n4);
        
        //Iterator itr = tree.iteratorInOrder();
        //Iterator itr = tree.iteratorPreOrder();
        //Iterator itr = tree.iteratorPostOrder();
        Iterator itr = tree.iteratorLevelOrder();
        
        while (itr.hasNext()) {
            System.out.println(itr.next() + " ");
        }
        
        
    }
    
}
