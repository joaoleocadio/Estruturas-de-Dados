package Exceptions;

/**
 *
 * @author joaoc
 */
public class EmptyCollectionException extends Exception{
    
    public final static String EMPTY_COLLECTION = "Estrutura Vazia";

    public EmptyCollectionException() {
    
    }

    public EmptyCollectionException(String message) {
        super(message);
    }
    
}
