package ex.pkg4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author joaoc
 */
public class Ex4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> tmp = new ArrayList();
        tmp.add("Wor");
        tmp.add("Hell");
        tmp.add("GoodBye");
        tmp.add("Earth");
        System.out.println(tmp);

        //Classe Anonima
        Collections.sort(tmp, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
                
        );
        System.out.println(tmp);
    }
    
}
