package fp7ex1;

/**
 *
 * @author joaoc
 */
public class LinearNode<T> {
    
    private LinearNode<T> next;
    private T element;

    public LinearNode(T element) {
        this.element = element;
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

    @Override
    public String toString() {
        return "Element: " + element + "\n";
    }
}
