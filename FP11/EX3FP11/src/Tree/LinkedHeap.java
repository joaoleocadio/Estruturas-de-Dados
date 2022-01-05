package Tree;

import Exceptions.EmptyCollectionException;
import Interfaces.HeapADT;

/**
 *
 * @author joaoc
 */
public class LinkedHeap<T> extends LinkedBinaryTree<T> implements HeapADT<T> {

    public HeapNode<T> lastNode;

    public LinkedHeap() {
        super();
    }

    @Override
    public void addElement(T obj) {
        HeapNode<T> node = new HeapNode<T>(obj);

        if (root == null) {
            root = node;
        } else {
            HeapNode<T> next_parent = getNextParentAdd();

            if (next_parent.left == null) {
                next_parent.left = node;
            } else {
                next_parent.right = node;
            }

            node.parent = next_parent;
        }

        lastNode = node;
        count++;

        if (count > 1) {
            heapifyAdd();
        }
    }

    @Override
    public T removeMin() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty Heap");
        }

        T minElement = root.element;

        if (count == 1) {
            root = null;
            lastNode = null;
        } else {
            HeapNode<T> next_last = getNewLastNode();
            if (lastNode.parent.left == lastNode) {
                lastNode.parent.left = null;
            } else {
                lastNode.parent.right = null;
            }
            root.element = lastNode.element;
            lastNode = next_last;
            heapifyRemove();
        }

        count--;

        return minElement;
    }

    @Override
    public T findMin() {
        return root.getElement();
    }

    private HeapNode<T> getNextParentAdd() {
        HeapNode<T> result = lastNode;

        while ((result != root) && (result.parent.left != result)) {
            result = result.parent;
        }

        if (result != root) {
            if (result.parent.right == null) {
                result = result.parent;
            } else {
                result = (HeapNode<T>) result.parent.right;
                while (result.left != null) {
                    result = (HeapNode<T>) result.left;
                }
            }
        } else {
            while (result.left != null) {
                result = (HeapNode<T>) result.left;
            }
        }
        return result;
    }

    private void heapifyAdd() {
        T temp;
        HeapNode<T> next = lastNode;

        temp = next.element;

        while ((next != root) && (((Comparable) temp).compareTo(next.parent.element) < 0)) {
            next.element = next.parent.element;
            next = next.parent;
        }
        next.element = temp;
    }

    private HeapNode<T> getNewLastNode() {
        HeapNode<T> result = lastNode;
        
        while ((result != root) && (result.parent.left == result)) {
            result = result.parent;
        }

        if (result != root) {
            result = (HeapNode<T>) result.parent.left;
        }
        while (result.right != null) {
            result = (HeapNode<T>) result.right;
        }
        return result;

    }

    private void heapifyRemove() {
        T temp;
        HeapNode<T> node = (HeapNode<T>) root;
        HeapNode<T> left = (HeapNode<T>) node.getLeft();
        HeapNode<T> right = (HeapNode<T>) node.getRight();
        HeapNode<T> next;

        if ((left == null) && (right == null)) {
            next = null;
        } else if (left == null) {
            next = right;
        } else if (right == null) {
            next = left;
        } else if (((Comparable) left.getElement()).compareTo(right.getElement()) < 0) {
            next = left;
        } else {
            next = right;
        }

        temp = node.getElement();
        while ((next != null) && (((Comparable) next.getElement()).compareTo(temp) < 0)) {
            node.setElement(next.getElement());
            node = next;
            left = (HeapNode<T>) node.getLeft();
            right = (HeapNode<T>) node.getRight();

            if ((left == null) && (right == null)) {
                next = null;
            } else if (left == null) {
                next = right;
            } else if (right == null) {
                next = left;
            } else if (((Comparable) left.getElement()).compareTo(right.getElement()) < 0) {
                next = left;
            } else {
                next = right;
            }
        }
        node.setElement(temp);
    }

}
