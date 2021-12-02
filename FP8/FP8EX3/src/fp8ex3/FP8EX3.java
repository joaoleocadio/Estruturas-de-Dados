package fp8ex3;

/**
 *
 * @author joaoc
 */
public class FP8EX3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Car c6 = new Car(2010, "Subaru");    
        Car c2 = new Car(2002, "Ferrari");
        Car c3 = new Car(2003, "Tesla");
        Car c1 = new Car(1998, "Asia Rocksta"); 
        Car c4 = new Car(2004, "VW");
        Car c5 = new Car(2005, "Mercedes");
        
        
        Car[] lista = new Car[6];
        
        lista[0] = c1;
        lista[1] = c2;
        lista[2] = c3;
        lista[3] = c4;
        lista[4] = c5;
        lista[5] = c6;
        
        //System.out.println(Car.printList(lista));
        //SortingandSearching.selectionSort(lista);
        SortingandSearching.quickSort(lista, 0, 5);
        for (Car tmp : lista) {
            System.out.println(tmp.toString());          
        }
    }  
}
