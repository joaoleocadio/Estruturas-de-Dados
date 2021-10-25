
package ex.pkg5;

/**
 *
 * @author joaoc
 */
public class Video extends Media {
    
    private int duracao;

    /**
     *
     * @param duracao
     */
    public Video(int duracao) {
        this.duracao = duracao;
    }

    /**
     *
     * @param duracao
     * @param name
     */
    public Video(int duracao, String name) {
        super(name);
        this.duracao = duracao;
    }

    /**
     *
     * @return
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String text = "";
        
        text += super.toString() + "Duração: " + getDuracao() + "\n";
        
        return text;
    }
    
    
    
}
