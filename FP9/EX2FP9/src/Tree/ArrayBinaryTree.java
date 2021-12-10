package Tree;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;
import Interfaces.BinaryTreeADT;
import Queue.LinkedQueue;
import UnorderedLists.UnorderedListArray;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {
    private final int CAPACITY = 50;

    protected int count;
    protected T[] tree;

    public ArrayBinaryTree() {
        this.count = 0;
        this.tree = (T[]) new Object[CAPACITY];
    }

    public ArrayBinaryTree(T element) {
        this.count = 1;
        this.tree = (T[]) new Object[CAPACITY];
        this.tree[0] = element;
    }
    
    
    @Override
    public T getRoot() throws ElementNotFoundException {
        if (isEmpty()) {
            throw new ElementNotFoundException(ElementNotFoundException.EMPTY_COLLECTION);
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
        
        for (int ct = 0; ct < count && !found; ct++) {
            if (targetElement.equals(tree[ct])) {
                found = true;
                temp = tree[ct];
            }
        }
        if (!found) {
            throw new ElementNotFoundException("binary tree");
        }
        return temp;
    }

    @Override
    public Iterator<T> iteratorInOrder() throws ListsException {
        UnorderedListArray<T> templist = new UnorderedListArray<T>();
        inorder(0, templist);

        return templist.iterator();
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
        UnorderedListArray<T> templist = new UnorderedListArray<T>();
        preorder(0, templist);

        return templist.iterator();
    }
    
    protected void preorder(int node, UnorderedListArray<T> templist) throws ListsException {
        if (node < tree.length) {
            if (tree[node] != null) {
                templist.addToRear(tree[node]);
                preorder(node * 2 + 1, templist);//verificar a esquerda
                preorder((node + 1) * 2, templist);//verificar direita
            }
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() throws ListsException {
        UnorderedListArray<T> templist = new UnorderedListArray<T>();
        postorder(0, templist);
        
        return templist.iterator();
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
                if (count < size() && tree[(position * 2 + 1)] != null) {
                    queue.enqueue((position * 2 + 1));
                    count++;
                }
                if (count < size() && tree[((position + 1) * 2)] != null) {
                    queue.enqueue(((position + 1) * 2));
                    count++;
                }
            }
        }

        return list.iterator();
        
    }
    
}
