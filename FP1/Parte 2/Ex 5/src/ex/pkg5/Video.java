
package ex.pkg5;

/**
 *
 * @author joaoc
 */
public class Video extends Media {
    
    private int duracao;

    public Video(int duracao) {
        this.duracao = duracao;
    }

    public Video(int duracao, String name) {
        super(name);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        String text = "";
        
        text += super.toString() + "Duração: " + getDuracao() + "\n";
        
        return text;
    }
    
    
    
}
