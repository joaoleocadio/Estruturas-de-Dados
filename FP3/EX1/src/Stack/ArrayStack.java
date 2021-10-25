package Stack;

/**
 *
 * @author joaoc
 */
public class ArrayStack <T> implements StackADT<T>{
    private final int DEFAULT_CAPACITY = 100;
    private int top;
    private T[] stack;

    public ArrayStack() {
        this.top = 0;
        this.stack = (T[])(new Object[DEFAULT_CAPACITY]);
    }

    public ArrayStack(int initialCapacity) {
        this.top = 0;
        this.stack = (T[])(new Object[DEFAULT_CAPACITY]);
    }


    @Override
    public void push(T element) {
        if (size() == stack.length) 
            expandCapacity();
        
        stack[top] = element;
        top++;
        
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        } else {
            this.top--;
            T result = stack[top];
            stack[top] = null;
            
            return result;
        }
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        return stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return (this.top == 0);
    }

    @Override
    public int size() {
        return this.top;
    }
    
    private void expandCapacity() {
        T[] tmp = (T[]) (new Object[stack.length + DEFAULT_CAPACITY]);
        
        for (int i = 0; i < stack.length; i++) {
            tmp[i] = stack[i];
        }
        
        stack = tmp;
    }

    @Override
    public String toString() {
        String text = "";
        
        int lastPosition = size() - 1;
        
        while (lastPosition != -1) {            
            text += "Posição: " + lastPosition + " -------> " + "Conteúdo: " + stack[lastPosition] + "\n";
            lastPosition--;
        }
        
        return text;
    }
}
