package DoubleLinkedList;

import Interfaces.ListsException;
import Interfaces.OrderedListADT;

/**
 *
 * @author joaoc
 */
public class DoubleLikedOrderedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T>{

    public DoubleLikedOrderedList() {
    }

    
    @Override
    public void add(T element) throws ListsException {
        if (element instanceof Comparable) {
            if (isEmpty()) {
                this.head = new DoubleNode<T>(element);
                this.tail = head;
            } else {
                boolean found = false;
                DoubleNode<T> current = this.head;
                
                while (current != null && found == false) {                    
                    Comparable<T> tmp = (Comparable<T>) current.getElement();
                    if (tmp.compareTo(element) > 0) {
                        found = true;
                    } else {
                        current = current.getNext();
                    }
                }
                
                if (found == true) {
                    //Adicionar no inicio da lista
                    if (current == this.head) {
                        DoubleNode<T> olderHead = head;
                        this.head = new DoubleNode<>(element);
                        this.head.setNext(olderHead);
                        olderHead.setPrevious(head);
                    } else {
                        DoubleNode<T> previous = current.getPrevious();
                        DoubleNode<T> newNode = new DoubleNode<>(element);
                        
                        //Apontar para o meio do valor encontrado
                        previous.setNext(newNode);
                        current.setPrevious(newNode);
                        
                        newNode.setPrevious(previous);
                        newNode.setNext(current);
                    }
                    //Se não conseguir comparar, adiciona no fim
                } else {
                    DoubleNode<T> olderTail = this.tail;
                    
                    this.tail = new DoubleNode<>(element);
                    tail.setPrevious(olderTail);
                    olderTail.setNext(tail);
                }
            }
            
            this.count++;
            //modCount++;
        } else {
            throw new ListsException("Objeto não é instância de Comparable! ");
        }
    }
    
}
