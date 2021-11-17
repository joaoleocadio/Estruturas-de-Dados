package UnorderedLists;

import Interfaces.UnorderedListADT;

/**
 *
 * @author joaoc
 */
public class UnorderedListArray<T> extends ArrayList<T> implements UnorderedListADT<T> {

    public UnorderedListArray() {
    }
    

    @Override
    public void addToFront(T element) throws ListsException {
        if (isEmpty()) {
            list[0] = element;
        } else if (size() == list.length) {
            expandList();
        } else {
            for (int i = size() - 1; i >= 0; i--) {
                list[i + 1] = list[i];
            }
            
            list[0] = element;
        }
        cont++;
        modCount++;
    }

    @Override
    public void addToRear(T element) throws ListsException {
        if (isEmpty()) {
            list[0] = element;
        } else if (size() == list.length) {
            expandList();
        } else {
            list[size()] = element;
        }
        
        cont++;
        modCount++;
    }

    @Override
    public void addAfter(T element, T target) throws ListsException {
        if (isEmpty()) {
            throw new ListsException(ListsException.EMPTYCOLLECTION);
        } else if (size() == list.length) {
            expandList();
        } else {
            
            boolean found = false;
            int pos = 0;
            
            //Percorrer o array
            for (int i = 0; i < size(); i++) {
                if (list[pos].equals(target)) {
                    found = true;
                } else {
                    pos++;
                }
            }
            
            if (found == true) {
                for (int i = size() - 1; i > pos; i--) {
                    list[i + 1] = list[i];
                }
                list[pos + 1] = element;
                cont++;
                modCount++;
            } else {
                throw new ListsException("Element not Found!");
            }
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
