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

    @Override
    public String toString() {
        String text = "Element: " + element + "";
        Iterator<GraphNode<T>> printItr = edgeList.iterator();
        while (printItr.hasNext()) {
            text += "\nEdge: " + element + "->" + printItr.next().element + "";
        }
        return text;
    }
     
}
