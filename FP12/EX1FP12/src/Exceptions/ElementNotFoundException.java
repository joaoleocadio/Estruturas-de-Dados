package Exceptions;

/**
 *
 * @author joaoc
 */
public class ElementNotFoundException extends Exception {
    public final static String EMPTY_COLLECTION = "Coleção Vazia";

    public ElementNotFoundException() {
    }

    public ElementNotFoundException(String message) {
        super(message);
    }
    
}
