package ex2;

/**
 *
 * @author joaoc
 */
public class Ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pair<Integer> tmp = new Pair<>();
        
        tmp.setFirst(15);
        tmp.setSecond(10);
        System.out.println(tmp.getFirst().equals(tmp.getSecond()));
        System.out.println(tmp.toString());
    }
    
}
