package ex1;

/**
 *
 * @author joaoc
 */
public class Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList <Integer> list = new LinkedList();
        
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(2);
        list.add(30);
        list.add(31);

        list.remove(20);
        list.printList();
    }
    
}
