package Main;

import OrderedLists.ArrayList.ArrayIterator;
import OrderedLists.EmptyCollectionException;
import OrderedLists.OrderedList;
import java.util.Iterator;

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
            lista.add(13);   
            lista.add(5);
            lista.add(9);
            
            
            Iterator<Integer> itr = lista.iterator();
            
            while (itr.hasNext()) { 
                System.out.println(itr.next());
                
            }
            
            
            lista.add(12);
            System.out.println(lista.toString());
            
            lista.add(20);
            while (itr.hasNext()) { 
                System.out.println(itr.next());
                
            }
            
            lista.removeLast();
            System.out.println(lista.toString());
            
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }       
    }
    
}
