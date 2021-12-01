package fp7ex2;

import DoubleLinkedList.DoubleLikedOrderedList;
import Interfaces.ListsException;


/**
 *
 * @author joaoc
 */
public class FP7EX2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ListsException {
        
        DoubleLikedOrderedList<Integer> list = new DoubleLikedOrderedList<>();
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list.toString());
        System.out.println("**********************");
        System.out.println(list.toStringReversed());
        
    }
    
}
