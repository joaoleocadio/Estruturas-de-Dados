package Graph;

import Interfaces.UnorderedListADT;
import UnorderedLists.UnorderedListArray;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public class GraphNode<T> {
    protected T element;
    protected UnorderedListADT<GraphNode<T>> edgeList;

    public GraphNode(T element) {
        this.element = element;
        this.edgeList = new UnorderedListArray();
    }

    
     
}
