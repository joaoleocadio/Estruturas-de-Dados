package ex.pkg2;

/**
 *
 * @author joaoc
 */
public class LinkedListSentinela<T> {
    private LinearNode<T> head;
    private LinearNode<T> tail;
    private int cont;

    public LinkedListSentinela() {
        this.head = new LinearNode<>(null);
        this.tail = new LinearNode<>(null);
        this.cont = 0;
    }

    public int getCont() {
        return cont;
    }
    
    private boolean isEmpty(){
        return (this.cont == 0);
    }
    
    public void add(T nodo) {
        LinearNode<T> newNode = new LinearNode<>(nodo);
         
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNext(this.head);
            this.head = newNode;
        //newNode.setNext(this.head.getNext());
        //this.head.setNext(newNode);
        }
                
        this.cont++;
        /*LinearNode<T> newNode = new LinearNode<>(nodo);

        newNode.setNext(this.head.getNext());
        this.head.setNext(newNode);
        this.cont++;*/
    }
    
    public boolean remove(T nodo) {
        LinearNode<T> current = this.head.getNext();
        LinearNode<T> previous = this.head;
        
        while (current.getElement() != null) {
            if (current.getElement().equals(nodo)) {
                previous.setNext(current.getNext());
                this.cont--;
                return true;
            } else {              
                previous = current;
                current = current.getNext();
                //tail = previous.getNext();
            }
        }
        return false;
        
        /*
        boolean found = false;

        LinearNode<T> previous = this.head;
        LinearNode<T> current = this.head.getNext();

        while (current.getElement() != null ) {
            if (current.getElement().equals(nodo)) {
                previous.setNext(current.getNext());
                this.cont--;
                return true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        return false;*/
    }
    
    private void info() {
        System.out.println("********* Info *********");
        
        System.out.println("Nº de elementos na lista: " + this.cont);
        
        System.out.println("HEAD: " + this.head.getElement().toString());
        
        System.out.println("TAIL: " + this.tail.getElement().toString());
        
                
    }
    
    public void printList() {
        LinearNode tmp = head.getNext();      
        
        //System.out.println(tmp.toString());
        while(tmp != null) {
            System.out.println(tmp.toString());
            tmp = tmp.getNext();
        }
        System.out.println("---------");
        //System.out.println("Nº Elementos: " + this.cont);
        System.out.println("Head: " + head.getNext());
        //System.out.println("Tail: " + tail.getElement().toString());
        
        //info();
        
    }
    
}
