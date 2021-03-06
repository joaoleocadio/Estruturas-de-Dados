package UnorderedLists;

import Interfaces.ListADT;
import Interfaces.ListsException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public abstract class DoubleLinkedList<T> implements ListADT<T>, Iterable<T>{
    protected DoubleNode<T> head;
    protected DoubleNode<T> tail;
    protected int count;
    protected int modCount;
    
    

    /**
     * Default Constructor DoubleLinkedList
     */
    public DoubleLinkedList() {
        this.head = this.tail = null;
        this.count = 0;
        this.modCount = 0;
    }
      
    /**
     * Removes and returns the first element from this list.
     * @return the first element from this list
     * @throws ListsException 
     */
    @Override
    public T removeFirst() throws ListsException {
        if (isEmpty()) {
            throw new ListsException(ListsException.EMPTYCOLLECTION);
        }
        
        DoubleNode<T> tmp = this.head;
        
        if (size() == 1) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.getNext();
            this.head.setPrevious(null);
        }
        
        count--;
        modCount++;
        return tmp.getElement();
    }

    /**
     * Removes and returns the last element from this list.
     * @return the last element from this list
     * @throws ListsException 
     */
    @Override
    public T removeLast() throws ListsException {
        if (isEmpty()) {
            throw new ListsException(ListsException.EMPTYCOLLECTION);
        }
        
        DoubleNode<T> tmp = this.tail;
        
        if (size() == 1) {
            this.head = this.tail = null;
        } else {
            this.tail = this.tail.getPrevious();
            this.tail.setNext(null);
        }
        
        this.count--;
        this.modCount++;
        
        return tmp.getElement();
    }

    /**
     * Removes and returns the specified element from this list.
     * @param element the element to be removed from the list
     * @return the specified element from this list.
     * @throws ListsException 
     */
    @Override
    public T remove(T element) throws ListsException {
        if (isEmpty()) {
            throw new ListsException(ListsException.EMPTYCOLLECTION);
        }
        
        DoubleNode<T> tmp = search(element);
        
        if (tmp != null) {
            if (tmp == this.head) {
                removeFirst();
            } else if (tmp == this.tail) {
                removeLast();
            } else {
                DoubleNode<T> previous = tmp.getPrevious();
                DoubleNode<T> next = tmp.getNext();
                
                previous.setNext(tmp.getNext());
                next.setPrevious(tmp.getPrevious());
            }
            this.count--;
            this.modCount++;
            return tmp.getElement();
        }
        return null;
        
    }

    /**
     * Returns a reference to the first element in this list.
     * @return a reference to the first element in this list
     * @throws ListsException 
     */
    @Override
    public T first() throws ListsException {
        if (isEmpty()) {
            throw new ListsException(ListsException.EMPTYCOLLECTION);
        }
        
        return this.head.getElement();
    }

    /**
     * Returns a reference to the last element in this list.
     * @return a reference to the last element in this list
     * @throws ListsException 
     */
    @Override
    public T last() throws ListsException {
        if (isEmpty()) {
            throw new ListsException(ListsException.EMPTYCOLLECTION);
        }
        
        return this.tail.getElement();
    }
    
    /**
     * Returns element 
     * @param element
     * @return
     * @throws ListsException 
     */
    private DoubleNode<T> search(T element) throws ListsException{
        if (isEmpty()) {
            throw new ListsException(ListsException.EMPTYCOLLECTION);
        }
        
        DoubleNode<T> tmp = this.head;
        
        while (tmp != null) {            
            if (tmp.getElement().equals(element)) {
                return tmp;
            }
            tmp = tmp.getNext();
        }
        
        return null;
    }

    /**
     * Returns true if this list contains the specified target element.
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     * @throws ListsException 
     */
    @Override
    public boolean contains(T target) throws ListsException{
        return (search(target) != null);
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    /**
     * Returns an iterator for the elements in this list.
     * @return an iterator over the elements in this list
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Returns a string representation of this list.
     * @return a string representation of this list
     */
    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    @Override
    public String toString() {
        String text = "\n";
        
        DoubleNode<T> tmp = this.head;
        int i = 0;
        
        while (tmp != null) {            
            text += "Position " + i + " ------> "+ tmp.getElement() + "\n";
            tmp = tmp.getNext();
            i++;
        }
        
        return text;
    }  
    
    private class DoubleLinkedListIterator implements Iterator<T>{
             
        private DoubleNode<T> current;
        private int expectedModCount = modCount;
        private boolean okToRemove;

        public DoubleLinkedListIterator() {
            this.current = (DoubleNode<T>) head;
            this.expectedModCount = modCount;
            this.okToRemove = false;
        }     
        
        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Cole????o alterada!");
            }
            
            this.okToRemove = false;
            
            return (current != null);
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new ArrayIndexOutOfBoundsException("There isn??t a next element");
            }
            
            DoubleNode<T> tmp = this.current;
            
            this.current = this.current.getNext();
            this.okToRemove = true;
            
            return tmp.getElement();
        } 

        @Override
        public void remove() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            if (!okToRemove) {
                throw new RuntimeException("It??s not possible to remove");
            }

            try {
                DoubleLinkedList.this.remove((T) current.getElement());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            okToRemove = false;
            expectedModCount++;
        }    
    }
}