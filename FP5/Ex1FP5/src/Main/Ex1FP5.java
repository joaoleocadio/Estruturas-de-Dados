package Main;

import OrderedLists.EmptyCollectionException;
import OrderedLists.OrderedList;

/**
 *
 * @author joaoc
 */
public class Ex1FP5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
        OrderedList<Integer> lista = new OrderedList<>();
        
        try {
            lista.add(2);
            lista.add(4);
            lista.add(6);
            lista.add(8);
            lista.add(5);        
            lista.removeFirst();
            System.out.println(lista.toString());
            
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        
        
        
    }
    
}
