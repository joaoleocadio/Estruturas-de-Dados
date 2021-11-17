package Interfaces;

/**
 *
 * @author joaoc
 */
public class ListsException extends Exception{
    
    public final static String EMPTYCOLLECTION = "Lista Vazia";

    public ListsException() {
    }

    public ListsException(String message) {
        super(message);
    }

    
    
}
