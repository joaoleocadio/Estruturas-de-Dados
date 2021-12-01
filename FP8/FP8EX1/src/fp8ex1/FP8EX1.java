package fp8ex1;

/**
 *
 * @author joaoc
 */
public class FP8EX1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Car c1 = new Car(2001, "Subaru");
        Car c2 = new Car(2002, "Ferrari");
        Car c3 = new Car(2003, "Tesla");
        Car c4 = new Car(2004, "VW");
        Car c5 = new Car(2005, "Mercedes");
        
        Car[] lista = new Car[10];
        
        lista[0] = c1;
        lista[1] = c2;
        lista[2] = c3;
        lista[3] = c4;
        lista[4] = c5;
        
        System.out.println(Car.printList(lista));
        
        System.out.println("Resultado: " + SortingandSearching.linearSearch(lista, 0, 4, c2));
        System.out.println("Resultado: " + SortingandSearching.binarySearch(lista, 0, 4, c2));
    }
    
}
