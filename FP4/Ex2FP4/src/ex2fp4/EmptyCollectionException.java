package ex2fp4;

/**
 *
 * @author joaoc
 */
public class EmptyCollectionException extends Exception{
    
    public final static String EMPTYCOLLECTION = "Queue Vazia";

    public EmptyCollectionException() {
    }

    public EmptyCollectionException(String message) {
        super(message);
    }
    
    
}
