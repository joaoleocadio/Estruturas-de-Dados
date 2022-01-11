package Graph;

import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;
import Interfaces.UnorderedListADT;
import UnorderedLists.UnorderedListArray;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public class GraphList<T> implements GraphADT<T>{
    
    protected int numVertices;
    protected UnorderedListADT<GraphNode<T>> verticesList;

    public GraphList() {
        this.numVertices = 0;
        this.verticesList = new UnorderedListArray<GraphNode<T>>();
    }
   

    @Override
    public void addVertex(T vertex) throws GraphExceptions, ListsException {
        if (vertex == null) {
            throw new GraphExceptions(GraphExceptions.ELEMENT_NOT_FOUND);
        }
        
        verticesList.addToRear(new GraphNode(vertex));
        numVertices++;
    }

    @Override
    public void removeVertex(T vertex) throws GraphExceptions {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addEdge(T vertex1, T vertex2) throws GraphExceptions {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) throws GraphExceptions {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iteratorBFS(T startVertex) throws EmptyCollectionException, ListsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iteratorDFS(T startVertex) throws EmptyCollectionException, ListsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) throws ListsException, EmptyCollectionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return (verticesList.isEmpty());
    }

    @Override
    public boolean isConnected() throws GraphExceptions, EmptyCollectionException, ListsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return numVertices;
    }
    
}
