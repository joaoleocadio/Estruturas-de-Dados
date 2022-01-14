package Demo;

import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;
import Graph.GraphExceptions;
import Network.NetworkADT;
import Network.NetworkMatrix;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public class EX4FP12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws GraphExceptions, EmptyCollectionException, ListsException {
        NetworkADT<Integer> graph;
        Iterator<Integer> itr;

        graph = new NetworkMatrix<>();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 4, 20);
        graph.addEdge(2, 2, 5);
        graph.addEdge(1, 1, 6);
        graph.addEdge(4, 4, 7);
        graph.addEdge(1, 4, 8);
        graph.addEdge(4, 3, 6);
        System.out.println(graph.toString());
        System.out.println("Caminho mais curto peso: " + graph.shortestPathWeight(1, 3));
        itr = graph.iteratorShortestPath(1, 3);
        while (itr.hasNext()) {
            System.out.print("->");
            System.out.print(itr.next());
        }
        System.out.println();

    }

}
