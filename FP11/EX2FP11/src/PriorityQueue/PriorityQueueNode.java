package PriorityQueue;

/**
 *
 * @author joaoc
 */
public class PriorityQueueNode<T> implements Comparable<PriorityQueueNode> {

    private static int nextOrder = 0;

    private int priority;
    private int order;
    private T element;

    public PriorityQueueNode(T element, int priority) {
        this.element = element;
        this.priority = priority;
        this.order = nextOrder;
        nextOrder++;
    }

    public int getPriority() {
        return priority;
    }

    public int getOrder() {
        return order;
    }

    public T getElement() {
        return element;
    }

    @Override
    public String toString() {
        String temp = ("Element: " + element.toString() + " | Priority: " + priority + " | Order: " + order + "\n");
        return temp;
    }

    /**
     * Returns the 1 if the current node has higher priority than the given node
     * and -1 otherwise.
     *
     * @param obj the node to compare to this node
     * @return the integer result of the comparison of the obj node and this one
     */
    @Override
    public int compareTo(PriorityQueueNode obj) {
        int result;
        PriorityQueueNode<T> temp = obj;
        
        if (priority > temp.getPriority()) {
            result = 1;
        } else if (priority < temp.getPriority()) {
            result = -1;
        } else if (order > temp.getOrder()) {
            result = 1;
        } else {
            result = -1;
        }
        
        return result;
    }

}
