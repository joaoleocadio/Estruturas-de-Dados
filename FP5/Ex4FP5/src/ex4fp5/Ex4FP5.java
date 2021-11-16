package ex4fp5;

import UnorderedLists.ListsException;
import UnorderedLists.UnorderedListArray;

/**
 *
 * @author joaoc
 */
public class Ex4FP5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ListsException {
        UnorderedListArray<Integer> list = new UnorderedListArray<>();
        
        try {
            list.addToFront(1);
            list.addToFront(2);
            list.addToFront(3);
            list.addToRear(10);
            list.addToRear(12);
            list.addAfter(50, 1);

            System.out.println(list.toString());
            System.out.println("");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
}
