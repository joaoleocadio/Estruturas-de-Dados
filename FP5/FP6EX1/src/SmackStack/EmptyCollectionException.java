/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmackStack;

/**
 *
 * @author joaoc
 */
public class EmptyCollectionException extends Exception {
    public final static String EMPTYCOLLECTION = "Coleção Vazia";

    public EmptyCollectionException() {
    }

    public EmptyCollectionException(String message) {
        super(message);
    }
}
