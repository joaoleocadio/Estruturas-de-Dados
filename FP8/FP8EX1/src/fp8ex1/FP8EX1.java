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
        Car c1 = new Car(1990, "Subaru");
        Car c2 = new Car(2015, "Ferrari");
        Car c3 = new Car(2020, "Tesla");
        
        Car[] lista = new Car[10];
        
        lista[0] = c1;
        lista[1] = c2;
        lista[2] = c3;
        
        System.out.println("Resultado: " + SortingandSearching.linearSearch(lista, 0, 1, c3));
        System.out.println("Resultado: " + SortingandSearching.binarySearch(lista, 0, 2, c3));
    }
    
}
