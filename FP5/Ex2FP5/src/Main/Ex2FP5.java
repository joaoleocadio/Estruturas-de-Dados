package Main;

import DoubleLinkedList.DoubleLikedOrderedList;
import DoubleLinkedList.DoubleLinkedList;
import java.util.Iterator;


/**
 *
 * @author joaoc
 */
public class Ex2FP5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoubleLikedOrderedList<Integer> list = new DoubleLikedOrderedList<>();
        
        try {
            list.add(2);
            list.add(4);
            list.add(6);
            list.add(8);
            list.add(5);

            Iterator<Integer> itr = list.iterator();
            
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
            
            list.add(9);
            list.add(10);
            
            System.out.println("----------");
            Iterator<Integer> itr1 = list.iterator();
            while (itr1.hasNext()) {
                System.out.println(itr1.next());
            }
            
            System.out.println("---- Inverter -----");
            
            System.out.println(list.invert());
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
}
