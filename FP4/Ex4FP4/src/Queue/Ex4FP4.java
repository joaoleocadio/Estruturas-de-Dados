package Queue;

import Cifra.Cifra;

/**
 *
 * @author joaoc
 */
public class Ex4FP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cifra teste = new Cifra();
        String message = "knowledge is power";
        
        try {
            teste.ask();
            //System.out.println(teste.printKey());
            System.out.println("Mensagem Cifrada: " + teste.encodeMessage(message));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }   
}