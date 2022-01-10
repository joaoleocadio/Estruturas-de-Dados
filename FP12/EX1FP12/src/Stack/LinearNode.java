package Stack;

/**
 *
 * @author joaoc
 */
public class LinearNode<T> {
    
    private LinearNode<T> next;
    private T element;

    public LinearNode(LinearNode<T> next, T element) {
        this.next = next;
        this.element = element;
    }

    public LinearNode() {
        this.element = null;
        this.next = null;
    } 

    public LinearNode<T> getNext() {
        return next;
    }

    public void setNext(LinearNode<T> next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

}
