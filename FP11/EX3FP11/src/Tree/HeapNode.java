package Tree;

/**
 *
 * @author joaoc
 */
public class HeapNode<T> extends BinaryTreeNode<T> {
    protected HeapNode<T> parent;

    public HeapNode(T element) {
        super(element);
        this.parent = null;
    }

}
