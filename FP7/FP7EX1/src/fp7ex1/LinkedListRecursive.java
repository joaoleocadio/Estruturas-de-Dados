package fp7ex1;

/**
 *
 * @author joaoc
 */
public class LinkedListRecursive<T> implements LinkedListTestADT<T>{
    
    private LinearNode<T> head, tail;
    private int size;

    @Override
    public void add(T element) {
        if (size == 0) {
            head = new LinearNode<>(element);
            tail = head;
        } else {
            LinearNode<T> oldTail = tail;
            tail = new LinearNode<>(element);
            oldTail.setNext(tail);
        }
        size++;
    }

    @Override
    public String toString() {
        return printRecursive(head);
    }
    
    public String printRecursive(LinearNode<T> list) {
        String result = "";
        
        //Critério de paragem
        if (list.getNext() == null) {
            result += list.toString();
        } else {
            //Caso específico
            result += list.toString() + printRecursive(list.getNext());
        }
        
        return result;
    }
    
    
}
