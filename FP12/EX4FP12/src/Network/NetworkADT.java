package Network;

import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;
import Graph.GraphADT;
import Graph.GraphExceptions;

/**
 *
 * @author joaoc
 */
public interface NetworkADT<T> extends GraphADT<T> {
    
    /**
     * Inserts an edge between two vertices of this graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @param weight  the weight
     */
    public void addEdge(T vertex1, T vertex2, double weight) throws GraphExceptions;
    
     /**
     * Returns the weight of the shortest path in this network.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return the weight of the shortest path in this network
     */
    public double shortestPathWeight(T vertex1, T vertex2) throws GraphExceptions, ListsException, EmptyCollectionException;
}
