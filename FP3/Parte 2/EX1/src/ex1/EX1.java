package ex1;

import Stack.EmptyCollectionException;


/**
 *
 * @author joaoc
 */
public class EX1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
        Calculadora calc = new Calculadora();
        String exp = "1 2 + 4 * 3 + ";
        
        calc.setExpression(exp);
        
        try {
            System.out.println("Resultado: " + calc.execute());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
