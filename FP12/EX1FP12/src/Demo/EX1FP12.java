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
        
        String A = "A", B = "B", C = "C", D = "D", E = "E", G = "G";

        try {
        
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);      

        graph.addEdge(A, B);
        graph.addEdge(B, C);
        //graph.addEdge(C, B);
        graph.addEdge(A, C);
        //graph.addEdge(C, A);
        graph.addEdge(B, D);
        //graph.addEdge(D, B);
        //graph.addEdge(B, A);
        
        
        System.out.println(graph.toString());
        itr = graph.iteratorDFS(B);
        while(itr.hasNext()) {
            System.out.print(itr.next() + ",");
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
         /*
        System.out.println("------");
        
        itr = graph.iteratorBFS(C);
        while(itr.hasNext()) {
            System.out.print(itr.next());
        }*/
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
