package management;

import ex.pkg5.Media;
import java.util.ArrayList;

/**
 *
 * @author joaoc
 */
public class Management<T extends Media> {
    
    private ArrayList<T> list = new ArrayList<>();

    public Management() {
    }
    
    public void addList(T media) {
        list.add(media);
    }
    
    public T getFromList(int position) {
        return list.get(position);
    }
    
    public void getList(){
        for (T tmp : list) {
            if (list != null) {
                System.out.println(tmp.toString());
            }          
        }
    }
    
}
