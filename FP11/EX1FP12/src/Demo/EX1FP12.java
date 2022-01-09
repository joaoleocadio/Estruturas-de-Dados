package Demo;

import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;
import Graph.Graph;
import Graph.GraphExceptions;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public class EX1FP12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws GraphExceptions, ListsException, EmptyCollectionException {
        Graph<String> graph = new Graph<>();
        Iterator<Integer> itr;
        
        
        
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        
        graph.addEdge("a", "b");
        graph.addEdge("b", "a");
        graph.addEdge("a", "c");
        graph.addEdge("c", "a");
        graph.addEdge("b", "c");
        graph.addEdge("c", "b");
        graph.addEdge("b", "d");
        graph.addEdge("d", "b");
        
        itr = graph.iteratorBFS("d");
        while(itr.hasNext()) {
            System.out.print(itr.next());
        }
        
        //System.out.println(graph.toString());*/
        /*
        Graph<Integer> graphInt = new Graph<>();
        
        graphInt.addVertex(1);
        graphInt.addVertex(2);
        graphInt.addVertex(3);
        graphInt.addVertex(4);
        graphInt.addEdge(1, 2);
        graphInt.addEdge(2, 4);
        graphInt.addEdge(2, 2);
        graphInt.addEdge(1, 1);
        graphInt.addEdge(4, 4);
        graphInt.addEdge(4, 3);
        graphInt.addEdge(1, 4);
        /*
        System.out.println(graphInt.toString());
        graphInt.removeVertex(3);
        System.out.println(graphInt.toString());
        System.out.println("\nExcepted: True. Result : " + graphInt.isConnected());
        
        Iterator itrSPFound = graphInt.iteratorShortestPath(1, 3);
        while (itrSPFound.hasNext()) {
            System.out.print("->");
            System.out.println(itrSPFound.next());
        }
        System.out.println("--------");
        itr = graphInt.iteratorBFS(1);
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        System.out.println("--------");
        Iterator itr1 = graphInt.iteratorDFS(1);
        while(itr1.hasNext()) {
            System.out.println(itr1.next());
        }
        */
    }
    
}
