package ex3;

import java.util.Objects;

/**
 *
 * @author joaoc
 */
public class Pair <T extends Comparable> {
    private T first;
    private T second;

    public Pair() {
    
    }
    
    

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    
    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "First: " + first + "\n" +  "Second: " + second + "\n";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (getClass() != otherObject.getClass()) {
            return false;
        } else {
            Pair otherPair = (Pair) otherObject;
            return (first.equals(otherPair.first) && second.equals(otherPair.second));
        }       
    }
    
    public T max() {
        if (first.compareTo(second) >= 0) {
            return first;
        } else {
            return second;
        }
    }
    
    
    
}
