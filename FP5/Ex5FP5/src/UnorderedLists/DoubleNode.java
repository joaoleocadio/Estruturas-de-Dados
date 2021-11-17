package UnorderedLists;

/**
 *
 * @author joaoc
 */
public class DoubleNode<T> {
    private DoubleNode<T> next;
    private T element;
    private DoubleNode<T> previous;

    public DoubleNode() {
        this.next = null;
        this.element = null;
        this.previous = null;
    }

    public DoubleNode(T element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "DoubleNode: " + "element=" + element + '}';
    }
    
}
