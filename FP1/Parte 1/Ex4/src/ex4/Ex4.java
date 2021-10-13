
package ex4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author joaoc
 */
public class Ex4 {

    /**
     * @param args the command line arguments
     */
    
    static void printCollection(Collection<?> list) {
        for (Object e : list) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        List<?> c = new ArrayList<String>();
        
        ((List<String>) c).add("hello world");
        ((List<Integer>) c).add(4);
        
        printCollection(c);
    }
    
}
