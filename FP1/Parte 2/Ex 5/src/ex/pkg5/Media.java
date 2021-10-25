package ex.pkg5;

/**
 *
 * @author joaoc
 */
public abstract class Media {
    
    /**
     * Atributo name
     */
    private String name;

    /**
     * Método Construtor default
     */
    public Media() {
    }
    
    /**
     * Método Construtor com o paramentro name
     * @param name 
     */
    public Media(String name) {
        this.name = name;
    }

    /**
     * Getter para o nome
     * @return 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Método toString para impressão dos atributos
     * @return 
     */
    @Override
    public String toString() {
        String text = "";
        
        text += "Nome: " + this.getName() + "\n";
        
        return text;
    }
    
}
