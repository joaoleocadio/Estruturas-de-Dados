package list;

/**
 *
 * @author joaoc
 */
public class LinkedList<T> {
    private LinearNode<T> head;
    private LinearNode<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public LinearNode<T> getHead() {
        return head;
    }

    public LinearNode<T> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }
    
    public boolean add(T element) {
        if (head == null) {
            LinearNode<T> current = new LinearNode<>(element);
            this.head = current;
            this.tail = current;
            this.size++;
            return true;
        } else {
            LinearNode<T> current = this.tail;
            LinearNode<T> next = new LinearNode<>(element);
            current.setNext(next);
            this.tail = next;
            this.size++;
            return true;
        }
    }
    public T remove(T data) {
        if (this.head == null) {
            System.out.println("Empty List!");
        } else {
            LinearNode<T> current = head;
            LinearNode<T> previous = null;

            boolean found = false;
            while (current != null && found == false) {
                if (current.getElement().equals(data)) {
                    found = true;
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }

            if (found == true) {
                if (this.size == 1) {
                    this.head = null;
                    this.tail = null;
                } else if (current.getElement().equals(head.getElement())) {
                    head = head.getNext();
                } else if (current.getElement().equals(tail.getElement())) {
                    previous.setNext(null);
                    tail = previous;
                } else {
                    previous.setNext(current.getNext());
                }
                this.size--;
                return current.getElement();
            } else {
                System.out.println("Not found!");
            }
        }
        return null;
    }
    
    public String printList() {
        String text = "";
        LinearNode<T> current = this.head;
        
        text += "#### Carros ####" + "\n";
        while (current != null) {           
            text += current.toString() + "\n";
            current = current.getNext();
        }
        
        return text;
    }
}
