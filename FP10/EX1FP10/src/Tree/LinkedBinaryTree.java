package Tree;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.BinaryTreeADT;
import Queue.LinkedQueue;
import Exceptions.ListsException;
import UnorderedLists.UnorderedListArray;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaoc
 */
public abstract class LinkedBinaryTree<T> implements BinaryTreeADT<T>{
    protected int count;
    public BinaryTreeNode<T> root;

    public LinkedBinaryTree() {
        this.count = 0;
        this.root = null;
    }

    public LinkedBinaryTree(T element) {
        count = 1;
        this.root = new BinaryTreeNode<T> (element);
    }
    
    private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }
        
        if (next.element.equals(targetElement)) {
            return next;
        }
        
        BinaryTreeNode<T> temp = findAgain(targetElement, next.left);
        
        if (temp == null) {
            temp = findAgain(targetElement, next.right);
        }
        
        return temp;
    }
    

    @Override
    public T getRoot() throws ElementNotFoundException {
        if (isEmpty()) {
            throw new ElementNotFoundException("Root is null");
        }
        
        return this.root.element;
    }

    @Override
    public boolean isEmpty() {
        return (this.count == 0);
    }

    @Override
    public int size() throws EmptyCollectionException {
        return count;
    }

    @Override
    public boolean contains(T targetElement) throws ElementNotFoundException {
        return (targetElement == find(targetElement));
    }

    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> current = findAgain(targetElement, root);
        
        if (current == null) {
            throw new ElementNotFoundException("binary tree");
        }
        
        return (current.element);
    }
    

    @Override
    public Iterator<T> iteratorInOrder() throws ListsException {
        UnorderedListArray<T> tmpList = new UnorderedListArray<T>();
        inorder(root, tmpList);
        
        return tmpList.iterator();
    }
    
    protected void inorder (BinaryTreeNode<T> node, UnorderedListArray<T> tempList) throws ListsException{
        if (node != null) {
            inorder(node.left, tempList);
            tempList.addToRear(node.element);
            inorder(node.right, tempList);
        }
    }  
    
    @Override
    public Iterator<T> iteratorPreOrder() throws ListsException{
        UnorderedListArray<T> tmpList = new UnorderedListArray<T>();
        preOrder(root, tmpList);

        return tmpList.iterator();  
    }
    
    protected void preOrder(BinaryTreeNode<T> node, UnorderedListArray<T> tempList) throws ListsException {
        if (node != null) {
            tempList.addToRear(node.element);
            preOrder(node.left, tempList);
            preOrder(node.right, tempList);
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() throws ListsException {
        UnorderedListArray<T> tmpList = new UnorderedListArray<T>();
        postOrder(root, tmpList);

        return tmpList.iterator();  
    }
    
    protected void postOrder(BinaryTreeNode<T> node, UnorderedListArray<T> tempList) throws ListsException {
        if (node != null) {
            postOrder(node.left, tempList);
            postOrder(node.right, tempList);
            tempList.addToRear(node.element);
        }
        
    }

    @Override
    public Iterator<T> iteratorLevelOrder() throws ListsException, ElementNotFoundException, EmptyCollectionException{
        LinkedQueue<T> nodes = new LinkedQueue<>();
        UnorderedListArray<T> results = new UnorderedListArray<>();
        
        if (isEmpty()) {
            throw  new ElementNotFoundException("Root is null");
        }
        
        nodes.enqueue((T) root);
        
        while (!nodes.isEmpty()) {
            BinaryTreeNode<T> tmp = (BinaryTreeNode<T>) nodes.dequeue();
            
            if (tmp != null) {
                results.addToRear(tmp.element);
                
                if (tmp.numChildren() > 0) {
                    nodes.enqueue((T) tmp.left);
                    nodes.enqueue((T) tmp.right);
                }
            }
        }
        return results.iterator();
    }
    
}
