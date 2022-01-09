package Graph;

import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;
import Queue.LinkedQueue;
import Stack.LinkedStack;
import UnorderedLists.UnorderedListArray;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaoc
 */
public class Graph<T> implements GraphADT<T> {

    protected final int DEFAULT_CAPACITY = 10;

    protected int numVertices;
    protected boolean[][] adjMatrix;
    protected T[] vertices;

    public Graph() {
        this.numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void addVertex(T vertex) {
        if (numVertices == vertices.length) {
            expandCacity();
        }

        vertices[numVertices] = vertex;

        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }

        numVertices++;
    }

    private void expandCacity() {
        T[] largerVertices = (T[]) (new Object[vertices.length * 2]);
        boolean[][] largerAdjMatrix = new boolean[vertices.length * 2][vertices.length * 2];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                largerAdjMatrix[i][j] = adjMatrix[i][j];
            }
            largerVertices[i] = vertices[i];
        }
        vertices = largerVertices;
        adjMatrix = largerAdjMatrix;
    }

    @Override
    public void removeVertex(T vertex) throws GraphExceptions{
        int index = getIndex(vertex);
        
        if (isEmpty()) {
            throw new GraphExceptions(GraphExceptions.EMPTY_GRAPH);
        }
        
        if (index == -1) {
            throw new GraphExceptions(GraphExceptions.ELEMENT_NOT_FOUND);
        }
        
        //Fazer o shift na coluna da matriz
        for (int i = index; i < numVertices - 1; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[j][i] = adjMatrix[j][i+1];
            }
        }
        
        //Fazer o shift na linha da matriz
        for (int i = index; i < numVertices - 1; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[i][j] = adjMatrix[i+1][j];
            }
        }
        
        //Fazer o shift no array de vertices
        for (int i = index; i < numVertices - 1; i++) {
            vertices[i] = vertices[i+1];
        }
        
        numVertices--;
        
    }

    @Override
    public void addEdge(T vertex1, T vertex2) throws GraphExceptions {
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }

    private void addEdge(int index1, int index2) throws GraphExceptions {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
        } else {
            throw new GraphExceptions(GraphExceptions.ELEMENT_NOT_FOUND);
        }
    }
    
    private boolean indexIsValid(int index) {
        if (index >= 0 && index < numVertices) {
            return true;
        }
        return false;
    }
    
    private int getIndex(T vertex) {
        int position = -1;
        int current = 0;
        boolean found = false;
        
        while(!found && current < numVertices) {
            if (vertex.equals(vertices[current])) {
                found = true;
                position = current;
                break;
            }          
            current++;
        }        
        return position;
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) throws GraphExceptions{
        removeEdge(getIndex(vertex1), getIndex(vertex2));
    }

    private void removeEdge(int index1, int index2) throws GraphExceptions {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = false;
            adjMatrix[index2][index1] = false;
        } else {
            throw new GraphExceptions(GraphExceptions.ELEMENT_NOT_FOUND);
        }
    }
    
    //Iterador que permite a travessia em largura
    @Override
    public Iterator iteratorBFS(T startVertex) throws EmptyCollectionException, ListsException {
        return iteratorBFS(getIndex(startVertex));
    }
    
    private Iterator iteratorBFS(int startIndex) throws EmptyCollectionException, ListsException {
        Integer x;
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();
        UnorderedListArray<T> resultList = new UnorderedListArray<T>();

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalQueue.enqueue(new Integer(startIndex));
        visited[startIndex] = true;

        while (!traversalQueue.isEmpty()) {
            x = traversalQueue.dequeue();
            resultList.addToRear(vertices[x.intValue()]);
            /** Find all vertices adjacent to x that have
             not been visited and queue them up */
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalQueue.enqueue(new Integer(i));
                    visited[i] = true;
                }
            }
        }

        return resultList.iterator();
    }

    @Override
    public Iterator iteratorDFS(T startVertex) throws EmptyCollectionException, ListsException{
        return iteratorDFS(getIndex(startVertex));
    } 
    
    private Iterator iteratorDFS(int startIndex) throws EmptyCollectionException, ListsException {
        Integer x;
        boolean found;
        LinkedStack<Integer> traversalStack = new LinkedStack();
        UnorderedListArray<T> resultList = new UnorderedListArray<>();
        boolean[] visited = new boolean[numVertices];

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }

        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalStack.push(new Integer(startIndex));
        resultList.addToRear(vertices[startIndex]);
        visited[startIndex] = true;

        while (!traversalStack.isEmpty()) {
            x = traversalStack.peek();
            found = false;
            /** Find a vertex adjacent to x that has not been visited
             and push it on the stack */
            for (int i = 0; (i < numVertices) && !found; i++) {
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalStack.push(new Integer(i));
                    resultList.addToRear(vertices[i]);
                    visited[i] = true;
                    found = true;
                }
            }
            if (!found && !traversalStack.isEmpty()) {
                traversalStack.pop();
            }
        }
        return resultList.iterator();

    }

    @Override
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) throws ListsException, EmptyCollectionException {
        Integer x;
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();
        UnorderedListArray<T> resultList = new UnorderedListArray<>();
        int startIndex = getIndex(startVertex);
        int targetIndex = getIndex(targetVertex);
        int[][] info = new int[vertices.length][3];
        boolean found = false;
        int counter = 0;

        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalQueue.enqueue(new Integer(startIndex));
        //Index of Vertex
        info[counter][0] = startIndex;
        //PathLength
        info[counter][1] = 0;
        //LastVertex
        info[counter][2] = -1;
        visited[startIndex] = true;

        while (!found && !traversalQueue.isEmpty()) {
            x = traversalQueue.dequeue();
            /** Find all vertices adjacent to x that have
             not been visited and queue them up */
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalQueue.enqueue(new Integer(i));
                    counter++;
                    info[counter][0] = i;
                    info[counter][1] = info[x.intValue()][1] + 1;
                    info[counter][2] = info[x.intValue()][0];
                    visited[i] = true;
                    if (i == targetIndex) {
                        found = true;
                    }
                }
            }
        }

        if (found) {
            resultList.addToFront(vertices[info[counter][0]]);
            int lastIndex = info[counter][2];
            while (lastIndex != -1) {
                resultList.addToFront(vertices[info[lastIndex][0]]);
                lastIndex = info[lastIndex][2];
            }

        }
        return resultList.iterator();
    }

    @Override
    public boolean isEmpty() {
        return (numVertices == 0);
    }

    @Override
    public boolean isConnected() throws GraphExceptions, EmptyCollectionException, ListsException {
        if (isEmpty()) {
            throw new GraphExceptions(GraphExceptions.EMPTY_GRAPH);
        }
        
        Iterator itr = iteratorBFS(0);
        int counter = 0;

        while (itr.hasNext()) {
            itr.next();
            counter++;
        }

        return (counter == numVertices);
    }

    @Override
    public int size() {
        return numVertices;
    }

    @Override
    public String toString() {

        String text = "   ";

        for(int i = 0; i < numVertices; i++) {
            text += " " + vertices[i].toString()  + "|";
        }
        
        text += "\n";        

        for (int i = 0; i < numVertices; i++) {
       
            text += " " + vertices[i].toString() ;

            for (int j = 0; j < numVertices; j++) {
                
                text += "|";

                if (adjMatrix[i][j] == true) {
                    text += " T";
                }
                else {
                    text += " F";
                }
            }
            text += "|";
            text += "\n";
        }
        return text;
    }
}
