package fp8ex2;

import list.LinkedList;

/**
 *
 * @author joaoc
 */
public class FP8EX2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Car c1 = new Car(1990, "Subaru");
        Car c2 = new Car(2015, "Ferrari");
        Car c3 = new Car(2020, "Tesla");

        LinkedList<Car> list = new LinkedList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        
                
        System.out.println(list.printList());
        System.out.println("Resultado: " + SortingandSearching.linearSearch(list, c2));
        System.out.println("Resultado: " + SortingandSearching.binarySearch(list, 0, 2, c2));
    }
    
}
