package OrderedLists;

import Interfaces.ListADT;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public abstract class ArrayList<T> implements ListADT<T>, Iterable<T>{
    
    protected final static int DEFAULT_CAPACITY = 10;
    
    protected T[] list;
    protected int cont;
    protected int modCount = 0;
    
    public class ArrayIterator<T> implements Iterator {

        private int current;
        private int expectedModCount;
        private boolean okToRemove;

        public ArrayIterator() {
            this.current = 0;
            this.expectedModCount = modCount;
            this.okToRemove = false;
        }
           
        
        @Override
        public boolean hasNext() {
            if (this.expectedModCount != modCount ) {
                throw new ConcurrentModificationException();
            } 
            
            this.okToRemove = false;
            
            return (current < cont);
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            
            T tmp = (T) list[current];
            current++;
            this.okToRemove = true;
            
            return tmp;
        }   

        @Override
        public void remove() {
            if (this.expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            
            if (!okToRemove) {
                throw new RuntimeException("It´s not possible to remove");
            }
            
            try {
                ArrayList.this.remove(list[current]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            this.okToRemove = false;
            this.expectedModCount++;
        }      
    }
    

    public ArrayList() {
        this.list = (T[]) new Object[DEFAULT_CAPACITY];
        this.cont = 0;
    }
    
      
    @Override
    public T removeFirst() throws EmptyCollectionException{
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        T tmp = list[0];
        
        
        //Fazer Shift para a esquerda depois de remover o primeiro elemento do Array
        for (int i = 0; i < size(); i++) {
            list[i] = list[i + 1];
        }
        
        this.cont--;
        this.modCount++;
        
        return tmp;
        
    }

    @Override
    public T removeLast() throws EmptyCollectionException{
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        T tmp = list[size() - 1];
        list[size() - 1] = null;
        
        this.cont--;
        this.modCount++;
        
        return tmp;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException {
        int position = searchElement(element);
        
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        if (position == -1) {
            throw new EmptyCollectionException("Elemento não encontrado!");
        } else if (position == 0) {
            return removeFirst();
        } else if (position == size() - 1) {
            return removeLast();
        } 
         
        
        T tmp = list[position];
        
        for (int i = position; i < size(); i++) {
            list[i] = list[i + 1];
        }
        
        this.cont--;
        this.modCount++;
        
        return tmp;        
    }

    @Override
    public T first() {
        return list[0];
    }

    @Override
    public T last() {
        return list[cont - 1];
    }

    @Override
    public boolean contains(T target) {
        return (searchElement(target) != -1);
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public int size() {
        return this.cont;
    }

    @Override
    public Iterator<T> iterator() {
        ArrayIterator itr = new ArrayIterator();
        
        return itr;
    }
    
    private int searchElement(T element) {
        int position = -1;
        
        for (int i = 0; i < size(); i++) {
            if(this.list[i].equals(element)) {
                position = i;
            }
        }
        
        return position;
    }
    
    @Override
    public String toString() {
        String text = "";
        

        for (int i = 0; i < size(); i++) {
            text += "Posição: " + i + " -------> " + this.list[i].toString() + "\n";
        }

        return text;
    }
}