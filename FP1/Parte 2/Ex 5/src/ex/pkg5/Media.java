package ex.pkg5;

/**
 *
 * @author joaoc
 */
public abstract class Media {
    
    private String name;

    public Media() {
    }
    
    public Media(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    

    @Override
    public String toString() {
        String text = "";
        
        text += "Nome: " + this.getName() + "\n";
        
        return text;
    }
    
}
