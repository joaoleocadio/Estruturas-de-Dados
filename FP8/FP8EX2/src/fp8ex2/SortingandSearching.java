package fp8ex2;

import list.LinearNode;
import list.LinkedList;

/**
 *
 * @author joaoc
 */
public class SortingandSearching {
    public static <T extends Comparable<? super T>> boolean linearSearch(LinkedList<T> data, T target) {
        
        LinearNode<T> list = data.getHead();
        
        while (list != null) {            
            if (list.getElement().compareTo(target) == 0) {
                return true;
            }
            list = list.getNext();
        }
        return false;
    }
    
    /*
    public static <T extends Comparable<? super T>> boolean binarySearch (T[] data, int min, int max, T target) {
        
    }
*/
}
