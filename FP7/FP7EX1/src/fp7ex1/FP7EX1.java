package fp7ex1;

/**
 *
 * @author joaoc
 */
public class FP7EX1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedListRecursive<Integer> list = new LinkedListRecursive<>();
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(10);
        list.add(14);
        
        System.out.println(list.toString());
    }
    
}
