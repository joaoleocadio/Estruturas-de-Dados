package management;

import ex.pkg5.Media;
import java.util.ArrayList;

/**
 *
 * @author joaoc
 * @param <T>
 */
public class Management<T extends Media> {
    
    private ArrayList<T> list = new ArrayList<>();

    /**
     *
     */
    public Management() {
    }
    
    /**
     *
     * @param media
     */
    public void addList(T media) {
        if(media == null) {
            System.out.println("Media is null!");
        } else {
            list.add(media);
        }       
    }
    
    /**
     *
     * @param position
     * @return
     */
    public T getFromList(int position) {
        return list.get(position);
    }
    
    /**
     *
     */
    public void getList(){
        for (T tmp : list) {
            if (list != null) {
                System.out.println(tmp.toString());
            }          
        }
    }  
}
