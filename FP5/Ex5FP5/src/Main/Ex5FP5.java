package Main;

import Interfaces.ListsException;
import UnorderedLists.DoubleLinkedUnorderedList;

/**
 *
 * @author joaoc
 */
public class Ex5FP5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ListsException {
        DoubleLinkedUnorderedList<Integer> list = new DoubleLinkedUnorderedList<>();
        
        list.addToRear(1);
        list.addToRear(2);
        list.addToRear(3);
        list.addToRear(4);
        list.addToFront(10);
        list.addAfter(100, 10);
        
        System.out.println(list.toString());
    }
    
}
