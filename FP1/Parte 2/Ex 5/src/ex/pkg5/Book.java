package ex.pkg5;

/**
 *
 * @author joaoc
 */
public class Book extends Media {
    
    private int numPag;

    /**
     *
     * @param name
     */
    public Book(String name) {
        super(name);
    }

    /**
     *
     * @param numPag
     * @param name
     */
    public Book(int numPag, String name) {
        super(name);
        this.numPag = numPag;
    }

    /**
     *
     * @return
     */
    public int getNumPag() {
        return numPag;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String text = "";
        
        text += super.toString() + "Nº de Página: " + getNumPag() + "\n";
        
        return text;
    }
    
}
