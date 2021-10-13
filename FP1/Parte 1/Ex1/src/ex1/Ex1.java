package ex1;

/**
 *
 * @author joaoc
 */
public class Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instanciação da classe genérica atribuindo os respetivos tipos
        TwoTypePair<String, String> tmp = new TwoTypePair("Hello", "World");
        TwoTypePair<String,String> tmp1 = new TwoTypePair("Hellos", "World");
        
        //Testando os métodos 
        System.out.println(tmp.equals(tmp1));
        System.out.println(tmp.toString());
        System.out.println(tmp1.toString());
    }
    
}
