package Tree;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;
import Interfaces.BinarySearchTreeADT;
import UnorderedLists.UnorderedListArray;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T> implements BinarySearchTreeADT<T> {

    protected int height;
    protected int maxIndex;

    public ArrayBinarySearchTree() {
        super();
        this.height = 0;
        this.maxIndex = -1;
    }

    public ArrayBinarySearchTree(T element) {
        super(element);
        this.height = 1;
        this.maxIndex = 0;
    }

    @Override
    public void addElement(T element) {
        if (this.tree.length < maxIndex * 2 + 3) {
            expandCapacity();
        }

        Comparable<T> tempelement = (Comparable<T>) element;

        if (isEmpty()) {
            tree[0] = element;
            maxIndex = 0;
        } else {
            boolean added = false;
            int currentIndex = 0;

            while (!added) {
                if (tempelement.compareTo(tree[currentIndex]) < 0) {
                    /**
                     * go left
                     */
                    if (tree[currentIndex * 2 + 1] == null) {
                        tree[currentIndex * 2 + 1] = element;
                        added = true;
                        if (currentIndex * 2 + 1 > maxIndex) {
                            maxIndex = currentIndex * 2 + 1;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 1;
                    }
                } else {
                    /**
                     * go right
                     */
                    if (tree[currentIndex * 2 + 2] == null) {
                        tree[currentIndex * 2 + 2] = element;
                        added = true;
                        if (currentIndex * 2 + 2 > maxIndex) {
                            maxIndex = currentIndex * 2 + 2;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 2;
                    }
                }
            }
        }
        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
        cont++;
    }

    private void expandCapacity() {
        T[] tmp = (T[]) new Object[tree.length * 2];

        for (int i = 0; i < tree.length; i++) {
            tmp[i] = tree[i];
        }

        tree = tmp;
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException, ListsException {
        T result = null;
        boolean found = false;

        if (isEmpty()) {
            throw new ElementNotFoundException("binary search tree");
        }

        Comparable<T> tempElement = (Comparable<T>) targetElement;
        int targetIndex = findIndex(tempElement, 0);

        result = tree[targetIndex];
        replace(targetIndex);
        cont--;

        int temp = maxIndex;
        maxIndex = -1;
        for (int i = 0; i <= temp; i++) {
            if (tree[i] != null) {
                maxIndex = i;
            }
        }

        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
        return result;
    }

    @Override
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException, ListsException {
        removeElement(targetElement);

        try {
            while (contains((T) targetElement)) {
                removeElement(targetElement);
            }
        } catch (Exception ex) {
            
        }
    }

    @Override
    public T removeMin() throws EmptyCollectionException, ListsException, ElementNotFoundException {
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTY_COLLECTION);
        }
        
        return removeElement(findMin());
    }

    @Override
    public T removeMax() throws EmptyCollectionException, ListsException, ElementNotFoundException {
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTY_COLLECTION);
        }
        
        return removeElement(findMax());
    }

    @Override
    public T findMin() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTY_COLLECTION);
        }
        
        int position = 0;
        
        while (tree[2 * position + 1] != null && (2 * position + 1) <= maxIndex) {
            position = 2 * position + 1;
        }
        
        return tree[position];
    }

    @Override
    public T findMax() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTY_COLLECTION);
        }
        
        int position = 0;
        
        while (tree[2 * position + 2] != null && (2 * position +2) <= maxIndex) {
            position = 2 * position + 2;
        }
        
        return tree[position];
    }

    private int findIndex(Comparable<T> targetElement, int n) throws ElementNotFoundException {
        int result = 0;

        if (n > tree.length) {
            throw new ElementNotFoundException(ElementNotFoundException.EMPTY_COLLECTION);
        }
        if (tree[n] == null) {
            throw new ElementNotFoundException(ElementNotFoundException.EMPTY_COLLECTION);
        }
        if (targetElement.compareTo(tree[n]) == 0) {
            result = n;
        } else {
            if (targetElement.compareTo(tree[n]) > 0) {
                result = findIndex(targetElement, (2 * (n + 1)));
            } else {
                result = findIndex(targetElement, (2 * n + 1));
            }
        }
        return result;
    }

    private void replace(int targetIndex) throws ListsException {
        int currentIndex, parentIndex, temp, oldIndex, newIndex;
        UnorderedListArray<Integer> oldlist = new UnorderedListArray<Integer>();
        UnorderedListArray<Integer> newlist = new UnorderedListArray<Integer>();
        UnorderedListArray<Integer> templist = new UnorderedListArray<Integer>();
        Iterator<Integer> oldIt, newIt;

        // if target node has no children
        if ((targetIndex * 2 + 1 >= tree.length) || (targetIndex * 2 + 2 >= tree.length)) {
            tree[targetIndex] = null;
        } // if target node has no children
        else if ((tree[targetIndex * 2 + 1] == null) && (tree[targetIndex * 2 + 2] == null)) {
            tree[targetIndex] = null;
        } // if target node only has a left child
        else if ((tree[targetIndex * 2 + 1] != null) && (tree[targetIndex * 2 + 2] == null)) {
            // fill newlist with indices of nodes that will replace
            // the corresponding indices in oldlist
            currentIndex = targetIndex * 2 + 1;
            templist.addToRear(new Integer(currentIndex));
            while (!templist.isEmpty()) {
                currentIndex = ((Integer) templist.removeFirst()).intValue();
                newlist.addToRear(new Integer(currentIndex));
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    templist.addToRear(new Integer(currentIndex * 2 + 1));
                    templist.addToRear(new Integer(currentIndex * 2 + 2));
                }
            }
            // fill oldlist
            currentIndex = targetIndex;
            templist.addToRear(new Integer(currentIndex));
            while (!templist.isEmpty()) {
                currentIndex = ((Integer) templist.removeFirst()).intValue();
                oldlist.addToRear(new Integer(currentIndex));
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    templist.addToRear(new Integer(currentIndex * 2 + 1));
                    templist.addToRear(new Integer(currentIndex * 2 + 2));
                }
            }

            oldIt = oldlist.iterator();
            newIt = newlist.iterator();
            while (newIt.hasNext()) {
                oldIndex = oldIt.next();
                newIndex = newIt.next();
                tree[oldIndex] = tree[newIndex];
                tree[newIndex] = null;
            }
        } else if ((tree[targetIndex * 2 + 1] == null) && (tree[targetIndex * 2 + 2] != null)) {
            // fill newlist with indices of nodes that will replace
            // the corresponding indices in oldlist
            currentIndex = targetIndex * 2 + 2;
            templist.addToRear(new Integer(currentIndex));
            while (!templist.isEmpty()) {
                currentIndex = ((Integer) templist.removeFirst()).intValue();
                newlist.addToRear(new Integer(currentIndex));
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    templist.addToRear(new Integer(currentIndex * 2 + 1));
                    templist.addToRear(new Integer(currentIndex * 2 + 2));
                }
            }
            currentIndex = targetIndex;
            templist.addToRear(new Integer(currentIndex));
            while (!templist.isEmpty()) {
                currentIndex = ((Integer) templist.removeFirst()).intValue();
                oldlist.addToRear(new Integer(currentIndex));
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    templist.addToRear(new Integer(currentIndex * 2 + 1));
                    templist.addToRear(new Integer(currentIndex * 2 + 2));
                }
            }
            // do replacement
            oldIt = oldlist.iterator();
            newIt = newlist.iterator();
            while (newIt.hasNext()) {
                oldIndex = oldIt.next();
                newIndex = newIt.next();
                tree[oldIndex] = tree[newIndex];
                tree[newIndex] = null;
            }
        } else {
            currentIndex = targetIndex * 2 + 2;
            while (tree[currentIndex * 2 + 1] != null) {
                currentIndex = currentIndex * 2 + 1;
            }
            tree[targetIndex] = tree[currentIndex];
            // the index of the root of the subtree to be replaced
            int currentRoot = currentIndex;

            // if currentIndex has a right child
            if (tree[currentRoot * 2 + 2] != null) {
            // fill newlist with indices of nodes that will replace
            // the corresponding indices in oldlist
                currentIndex = currentRoot * 2 + 2;
                templist.addToRear(new Integer(currentIndex));
                while (!templist.isEmpty()) {
                    currentIndex = ((Integer) templist.removeFirst()).intValue();
                    newlist.addToRear(new Integer(currentIndex));
                    if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                        templist.addToRear(new Integer(currentIndex*2+1));
                        templist.addToRear(new Integer(currentIndex*2+2));
                    }
                }
                // fill oldlist
                currentIndex = currentRoot;
                templist.addToRear(new Integer(currentIndex));
                while (!templist.isEmpty()) {
                    currentIndex = ((Integer)templist.removeFirst()).intValue();
                    oldlist.addToRear(new Integer(currentIndex));
                    if ((currentIndex*2+2) <= (Math.pow(2,height)-2)) {
                        templist.addToRear(new Integer(currentIndex*2+1));
                        templist.addToRear(new Integer(currentIndex*2+2));
                    }
                } 
            } else {
                tree[currentRoot] = null;
            }          
        }
    }
}
