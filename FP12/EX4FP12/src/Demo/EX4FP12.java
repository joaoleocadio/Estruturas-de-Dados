package Demo;

import Graph.GraphExceptions;
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
    public static void main(String[] args) throws GraphExceptions {
        NetworkMatrix<Integer> graph;
        Iterator<Integer> itr;
        
        graph = new NetworkMatrix<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 4, 4);
        graph.addEdge(2, 2, 5);
        graph.addEdge(1, 1, 6);
        graph.addEdge(4, 4, 7);
        graph.addEdge(1, 4, 8);
        
        System.out.println(graph.toString());
    }
    
}
