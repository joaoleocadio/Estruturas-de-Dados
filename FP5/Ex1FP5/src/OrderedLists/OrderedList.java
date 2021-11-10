package OrderedLists;

import Interfaces.OrderedListADT;

/**
 *
 * @author joaoc
 */
public class OrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {

    public OrderedList() {
    
    }

    @Override
    public void add(T element) throws EmptyCollectionException {
        if (this.list.length == size()) {
            expandList();
        }
        
        if (element instanceof Comparable) {
            if (isEmpty()) {
                this.list[0] = element;
            } else {
                
                Comparable lastPosition = (Comparable) this.list[cont - 1];
                
                if (lastPosition.compareTo(element) < 0) {
                    list[cont] = element;
                } else {
                    boolean found = false;
                    int current = 0;
                    
                    while (current < size() && found == false) {
                        Comparable<T> tmp = (Comparable<T>) list[current];
                        if (tmp.compareTo(element) > 0) {
                            found = true;
                        } else {
                            current++;
                        }
                    }
                    
                    //Shift da ultima posição para a primeira
                    if (found == true) {
                        for (int i = cont - 1; i >= current; i--) {
                            list[i + 1] = list[i];
                        }
                        list[current] = element;
                    }
                }
            }
            
            cont++;
            
        } else {
            throw new EmptyCollectionException("O elemento não é instancia de comparable!");
        }
    }
    
    private void expandList() {
        T[] tmp = (T[]) new Object[list.length + DEFAULT_CAPACITY];
        
        for (int i = 0; i < size(); i++) {
            tmp[i] = list[i];
        }
        
        list = tmp;
    } 
}
