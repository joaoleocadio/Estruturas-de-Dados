package ex.pkg5;

import management.Management;

/**
 *
 * @author joaoc
 */
public class Ex5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Book b1 = new Book(498, "Harry Potter e a Pedra Filosofal");
        Book b2 = new Book(536, "Harry Potter e a Câmara dos Segredos");
        Book b3 = new Book(745, "Harry Potter e o Prisioneiro de Azkaban");
        
        Video v1 = new Video(300, "Phineas e Ferb");
        Video v2 = new Video(265, "Tartarugas Ninja");
        
        CD cd1 = new CD("Porto Editora", "Pink Floyd");
        CD cd2 = new CD("Areal", "Tony Carreira");
        
        Management lista = new Management();
        
        lista.addList(b1);
        lista.addList(b2);
        lista.addList(b3);
        
        lista.addList(v1);
        lista.addList(v2);
        
        lista.addList(cd1);
        lista.addList(cd2);
        
        //System.out.println(lista.getFromList(2));
        lista.getList();
        
        Management<CD> mn2 = new Management<>();
        
        mn2.addList(cd2);
    }
    
}
