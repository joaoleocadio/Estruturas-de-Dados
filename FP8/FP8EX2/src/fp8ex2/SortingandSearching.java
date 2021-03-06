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
    
    /**
     * A pesquisa binária é impossível de fazer com listas ligadas
     * @param <T>
     * @param data
     * @param min
     * @param max
     * @param target
     * @return 
     */
    public static <T extends Comparable<? super T>> boolean binarySearch (LinkedList<T> data, int min, int max, T target) {

        int i = 0;
        LinearNode<T> aux = data.getHead();
        T[] array = (T[]) new Comparable[data.getSize()];
        
        while (aux != null) {
            array[i] = (T) aux.getElement();
            aux = aux.getNext();
            i++;
        }

        return BinarySearch.binarySearch(array, 0, data.getSize(), target);
    }

}
