package fp8ex3;

/**
 *
 * @author joaoc
 */
public class Car implements Comparable {

    private int ano;
    private String marca;

    public Car(int ano, String marca) {
        this.ano = ano;
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public int compareTo(Object o) {
        try {
            Car tmp = (Car) o;
            
            if (this.ano < tmp.ano) {
                return -1;
            } else if (this.ano == tmp.ano) {
                return 0;
            } else {
                return 1;
            }
        } catch (Exception e) {
            throw new ClassCastException();
        }
    }

    @Override
    public String toString() {
        return "Ano: " + ano + " marca: " + marca;
    }
    
    public static String printList(Car[] list) {
        String txt = "";
        
        txt += "#### CARROS ####" + "\n";
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                txt += list[i].toString() + "\n";
            }
        }
        
        return txt;
    }
    
}
