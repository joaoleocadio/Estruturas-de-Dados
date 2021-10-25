package ex.pkg5;

/**
 *
 * @author joaoc
 */
public class CD extends Media{
    
    private String editora;

    /**
     *
     * @param name
     */
    public CD(String name) {
        super(name);
    }

    /**
     *
     * @param editora
     * @param name
     */
    public CD(String editora, String name) {
        super(name);
        this.editora = editora;
    }

    /**
     *
     * @return
     */
    public String getEditora() {
        return editora;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String text = "";
        
        text += super.toString() + "Editora: " + getEditora() + "\n";
        
        return text;
    }
    
    
}
