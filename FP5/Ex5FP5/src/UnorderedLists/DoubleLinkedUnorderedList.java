package UnorderedLists;

import Interfaces.ListsException;
import Interfaces.UnorderedListADT;

/**
 *
 * @author joaoc
 */
public class DoubleLinkedUnorderedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T>{

    public DoubleLinkedUnorderedList() {
    }
    

    @Override
    public void addToFront(T element) throws ListsException {
        if (isEmpty()) {
            this.head = new DoubleNode<>(element);
            this.tail = head;
        } else {
            DoubleNode<T> olderHead = head;
            
            head = new DoubleNode<>(element);
            head.setNext(olderHead);
            olderHead.setPrevious(head);
        }
        
        count++;
        modCount++;
    }

    @Override
    public void addToRear(T element) throws ListsException {
        if (isEmpty()) {
            addToFront(element);
        } else {
            DoubleNode<T> olderTail = tail;
            
            tail = new DoubleNode<>(element);
            tail.setPrevious(olderTail);
            olderTail.setNext(tail);
            
            count++;
            modCount++;
        }
    }

    @Override
    public void addAfter(T element, T target) throws ListsException {
        if (isEmpty()) {
            throw new ListsException(ListsException.EMPTYCOLLECTION);
        } else {
            boolean found = false;
            DoubleNode<T> current = head;
            
            for (int i = 0; i < size(); i++) {
                if (current.getElement().equals(target)) {
                    found = true;
                } else {
                    current = current.getNext();
                }
            }
            
            if (found == true) {
                if (current == tail) {
                    addToRear(element);
                } else {
                    DoubleNode<T> next = current.getNext();
                    DoubleNode<T> newNode = new DoubleNode<>(element);
                    
                    newNode.setNext(next);
                    newNode.setPrevious(current);

                    current.setNext(newNode);
                    next.setPrevious(newNode);
                    
                    count++;
                    modCount++;
                }
            } else {
                throw new ListsException(ListsException.EMPTYCOLLECTION);
            }
        }
    }   
}
