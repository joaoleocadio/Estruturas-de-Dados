package ex.pkg2;

/**
 *
 * @author joaoc
 */
public class Ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedListSentinela<Integer> a = new LinkedListSentinela<>();
        
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(10);
        a.add(30);
        
        a.remove(2);
        
        a.printList();
    }  
}
