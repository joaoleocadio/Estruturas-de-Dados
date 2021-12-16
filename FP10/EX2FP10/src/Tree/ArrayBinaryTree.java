package Tree;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;
import Interfaces.BinaryTreeADT;
import Interfaces.UnorderedListADT;
import Queue.LinkedQueue;
import UnorderedLists.UnorderedListArray;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public class ArrayBinaryTree<T> implements BinaryTreeADT<T>{
    protected final static int CAPACITY = 50;
    
    protected T[] tree;
    protected int count;

    public ArrayBinaryTree() {
        this.tree = (T[]) new Object[CAPACITY];
        this.count = 0;
        
    }
    
    public ArrayBinaryTree(T element) {
        this.tree = (T[]) new Object[CAPACITY];
        this.tree[0] = element;
        this.count = 1;
    }
    
    
    @Override
    public T getRoot() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTY_COLLECTION);
        }
        return this.tree[0];
    }

    @Override
    public boolean isEmpty() {
        return (this.count == 0);
    }

    @Override
    public int size() throws EmptyCollectionException {
        return this.count;
    }

    @Override
    public boolean contains(T targetElement) throws ElementNotFoundException {
        return targetElement == find(targetElement);
    }

    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        T temp = null;
        boolean found = false;
        
        for (int ct = 0; ct < count && !found; ct++ ) {
            if (targetElement.equals(tree[ct])) {
                found = true;
                temp = tree[ct];
            }
        }
        
        if(!found) {
            throw new ElementNotFoundException("binary tree");
        }
        
        return temp;
    }

    @Override
    public Iterator<T> iteratorInOrder() throws ListsException {
        UnorderedListArray<T> tempList = new UnorderedListArray<>();
        inorder(0, tempList);
        
        return tempList.iterator();
    }
    
    protected void inorder (int node, UnorderedListArray<T> templist) throws ListsException {
        if (node < tree.length) {
            if (tree[node] != null) {
                inorder(node * 2 + 1, templist);
                templist.addToRear(tree[node]);
                inorder((node + 1) * 2, templist);
            }
        }
    }

    @Override
    public Iterator<T> iteratorPreOrder() throws ListsException {
        UnorderedListArray<T> tempList = new UnorderedListArray<>();
        preorder(0, tempList);
        
        return tempList.iterator();
    }
    
    protected void preorder(int node, UnorderedListArray<T> templist) throws ListsException {
        if (node < tree.length) {
            if (tree[node] != null) {
                templist.addToRear(tree[node]);
                preorder(node * 2 + 1, templist);
                preorder((node + 1) * 2, templist);
            }
        }
    }

    protected void postorder(int node, UnorderedListArray<T> templist) throws ListsException {
        if (node < tree.length) {
            if (tree[node] != null) {
                postorder(node * 2 + 1, templist);
                templist.addToRear(tree[node]);
                postorder((node + 1) * 2, templist);
            }
        }
    }
    
    @Override
    public Iterator<T> iteratorPostOrder() throws ListsException {
        UnorderedListArray<T> tempList = new UnorderedListArray<>();
        postorder(0, tempList);
        
        return tempList.iterator();
    }

    @Override
    public Iterator<T> iteratorLevelOrder() throws ListsException, ElementNotFoundException, EmptyCollectionException {

        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTY_COLLECTION);
        }

        UnorderedListArray<T> list = new UnorderedListArray<>();
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        int count = 0;

        queue.enqueue(0);
        count++;

        while (!queue.isEmpty()) {
            int position = queue.dequeue();
            if (tree[position] != null) {
                list.addToRear(tree[position]);
                if (count < count && tree[(position * 2 + 1)] != null) {
                    queue.enqueue((position * 2 + 1));
                    count++;
                }
                if (count < count && tree[((position + 1) * 2)] != null) {
                    queue.enqueue(((position + 1) * 2));
                    count++;
                }
            }
        }

        return list.iterator();    
    }   
}
