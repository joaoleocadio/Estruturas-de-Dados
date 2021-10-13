package ex.pkg5;

/**
 *
 * @author joaoc
 */
public class Book extends Media {
    
    private int numPag;

    public Book(String name) {
        super(name);
    }

    public Book(int numPag, String name) {
        super(name);
        this.numPag = numPag;
    }

    public int getNumPag() {
        return numPag;
    }

    @Override
    public String toString() {
        String text = "";
        
        text += super.toString() + "Nº de Página: " + getNumPag() + "\n";
        
        return text;
    }
    
}
