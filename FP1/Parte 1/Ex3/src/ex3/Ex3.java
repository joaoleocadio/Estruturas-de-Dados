
package ex3;

/**
 *
 * @author joaoc
 */
public class Ex3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UnorderedPair<String> p1 = new UnorderedPair<String>("beer", "beer");
        UnorderedPair<String> p2 = new UnorderedPair<String>("beer", "peanuts");

        
        if (p1.equals(p2)) {
            System.out.println(p1.getFirst() + " and " + p1.getSecond() + " is the same as ");
            System.out.println(p2.getFirst() + " and " + p2.getSecond());
        }
        
        System.out.println(p1.compare());
    }
    
}
