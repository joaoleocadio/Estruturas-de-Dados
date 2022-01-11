package Network;

import Graph.Graph;
import Graph.GraphExceptions;

/**
 *
 * @author joaoc
 */
public class NetworkMatrix<T> extends Graph<T> implements NetworkADT<T> {
    
    private double[][] weightMatrix;

    public NetworkMatrix() {
        this.weightMatrix = new double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
    }

    @Override
    public void addVertex(T vertex) {
        if (numVertices == vertices.length) {
            expandCapacity();
        }
        
        vertices[numVertices] = vertex;
        for (int i = 0; i < adjMatrix.length; i++) {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
    }

    @Override
    protected void expandCapacity() {
        super.expandCapacity(); 
        
        double[][] tmpWeightMatriz = new double[vertices.length * 2][vertices.length * 2];
        
        for (int i = 0; i < weightMatrix.length; i++) {
            for (int j = 0; j < weightMatrix.length; j++) {
                tmpWeightMatriz[i][j] = weightMatrix[i][j];
            }
        }
        
        weightMatrix = tmpWeightMatriz;
    }

    @Override
    public void removeVertex(T vertex) throws GraphExceptions {
        int index = getIndex(vertex);
        
        //Através do super conseguimos fazer o shift da matriz de adjacências e do array de vertices
        super.removeVertex(vertex);
        
        //Fazer o shift na coluna da matriz de peso
        for (int i = index; i < numVertices; i++) {
            for (int j = 0; j < numVertices + 1; j++) {
                weightMatrix[j][i] = weightMatrix[j][i + 1];
            }
        }
        
        //Fazer o shift na linha da matriz de peso
        for (int i = index; i < numVertices; i++) {
            for (int j = 0; j < numVertices + 1; j++) {
                weightMatrix[i][j] = weightMatrix[i + 1][j];
            }
        }
    }
     

    @Override
    public void addEdge(T vertex1, T vertex2, double weight) throws GraphExceptions {
        int indexVertex1 = getIndex(vertex1);
        int indexVertex2 = getIndex(vertex2);
        
        super.addEdge(vertex1, vertex2);
        weightMatrix[indexVertex1][indexVertex2] = weight;
        weightMatrix[indexVertex2][indexVertex1] = weight;
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) throws GraphExceptions {
        int indexVertex1 = getIndex(vertex1);
        int indexVertex2 = getIndex(vertex2);
        
        super.removeEdge(vertex1, vertex2); 
        weightMatrix[indexVertex1][indexVertex2] = 0;
        weightMatrix[indexVertex2][indexVertex1] = 0;
    }
    

    @Override
    public double shortestPathWeight(T vertex1, T vertex2) throws GraphExceptions {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        String text = "";
        text += super.toString() + "\n";

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                text += "|";
                text += weightMatrix[i][j];
                text += "|";
            }
            text += "\n";
        }

        return text;
    }
    
}
