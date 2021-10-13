package ex1;

import java.util.Objects;

/**
 *
 * @author joaoc
 */
public class TwoTypePair <T1, T2>{
    private T1 first;
    private T2 second;

    public TwoTypePair() {
        this.first = null;
        this.second = null;
    }

    public TwoTypePair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "TwoTypePair{" + "first=" + first + ", second=" + second + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.first);
        hash = 19 * hash + Objects.hashCode(this.second);
        return hash;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (getClass() != otherObject.getClass()) {
            return false;
        } else {
            TwoTypePair otherPair = (TwoTypePair) otherObject;
            return (first.equals(otherPair.first) && second.equals(otherPair.second));
        }
    
    }   
    
}
