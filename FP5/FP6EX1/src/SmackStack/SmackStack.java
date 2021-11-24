package SmackStack;

/**
 *
 * @author joaoc
 */
public class SmackStack<T> implements SmackStackADT<T>{
    private final int DEFAULT_CAPACITY = 10;
    private int top;
    private int rear;
    private T[] smackStack;

    public SmackStack() {
        this.top = 0;
        this.rear = 0;
        this.smackStack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public SmackStack(int initialCapacity) {
        this.top = 0;
        this.rear = 0;
        this.smackStack = (T[]) new Object[initialCapacity];
    }
     

    @Override
    public void push(T element) {
        if (size() == smackStack.length) {
            expandCapacity();
        }
        
        smackStack[top] = element;
        top++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        } else {
            T result = smackStack[top];
            smackStack[top] = null;
            this.top--;
            
            return result;
        }
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        return smackStack[size() - 1];
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
        T[] tmp = (T[]) (new Object[smackStack.length + DEFAULT_CAPACITY]);
        
        for (int i = 0; i < smackStack.length; i++) {
            tmp[i] = smackStack[i];
        }
        
        smackStack = tmp;
    }

    @Override
    public String toString() {
        String text = "";
        
        int lastPosition = size() - 1;
        
        while (lastPosition != -1) {            
            text += "Posição: " + lastPosition + " -------> " + "Conteúdo: " + smackStack[lastPosition] + "\n";
            lastPosition--;
        }
        
        return text;
    } 

    @Override
    public T smack() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        T result = smackStack[rear];
        smackStack[rear] = null;
        this.rear++;
        
        return result;
    }
    
}
