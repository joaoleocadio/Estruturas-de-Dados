package ex2;

/**
 *
 * @author joaoc
 */
public class EX2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
        LinkedStack<Integer> stack = new LinkedStack<>();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        
        //System.out.println(stack.peek());
        
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        //stack.pop();
        System.out.println(stack.toString());
        System.out.println("Tamanho da Stack: " + stack.size());
            
    }
    
}
