package ex1;

import Stack.ArrayStack;
import Stack.EmptyCollectionException;
import java.util.Scanner;

/**
 *
 * @author joaoc
 */
public class EX1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {

        ArrayStack<Integer> st = new ArrayStack();
        
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);

        st.pop();
        st.pop();

        System.out.println(st.peek());
        System.out.println(st.toString());

    }   
}
