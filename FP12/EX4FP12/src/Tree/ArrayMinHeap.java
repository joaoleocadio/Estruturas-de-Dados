package Tree;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;
import Interfaces.HeapADT;
import Tree.ArrayBinaryTree;

/**
 *
 * @author joaoc
 */
public class ArrayMinHeap<T> extends ArrayBinaryTree<T> implements HeapADT<T> {

    public ArrayMinHeap() {
        super();
    }

    @Override
    public void addElement(T obj) {
        if (cont == tree.length) {
            expandCapacity();
        }

        tree[cont] = obj;
        cont++;

        if (cont > 1) {
            heapifyAdd();
        }
    }

    private void expandCapacity() {
        T[] tmp = (T[]) (new Object[tree.length + CAPACITY]);
        for (int i = 0; i < tree.length; i++) {
            tmp[i] = tree[i];
        }
        tree = tmp;
    }

    private void heapifyAdd() {
        T temp;
        int next = cont - 1;

        temp = tree[next];

        while ((next != 0) && (((Comparable) temp).compareTo(tree[(next - 1) / 2]) < 0)) {

            tree[next] = tree[(next - 1) / 2];
            next = (next - 1) / 2;
        }

        tree[next] = temp;
    }

    @Override
    public T removeMin() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTY_COLLECTION);
        }

        T minElement = tree[0];
        tree[0] = tree[cont - 1];
        tree[cont - 1] = null;
        heapifyRemove();
        cont--;
        
        return minElement;
    }

    private void heapifyRemove() {
        T temp;
        int node = 0;
        int left = 1;
        int right = 2;
        int next;

        if ((tree[left] == null) && (tree[right] == null)) {
            next = cont;
        } else if (tree[left] == null) {
            next = right;
        } else if (tree[right] == null) {
            next = left;
        } else if (((Comparable) tree[left]).compareTo(tree[right]) < 0) {
            next = left;
        } else {
            next = right;
        }
        temp = tree[node];

        while ((next < cont) && (((Comparable) tree[next]).compareTo(temp) < 0)) {
            tree[node] = tree[next];
            node = next;
            left = 2 * node + 1;
            right = 2 * (node + 1);
            
            if ((tree[left] == null) && (tree[right] == null)) {
                next = cont;
            } else if (tree[left] == null) {
                next = right;
            } else if (tree[right] == null) {
                next = left;
            } else if (((Comparable) tree[left]).compareTo(tree[right]) < 0) {
                next = left;
            } else {
                next = right;
            }
        }
        tree[node] = temp;

    }

    @Override
    public T findMin() {
        return tree[0];
    }

}
