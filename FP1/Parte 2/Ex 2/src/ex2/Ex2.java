package ex2;

import java.util.ArrayList;


/**
 *
 * @author joaoc
 */
public class Ex2 {

    /**
     * Ex 2 e 3 -> Parte 2
     * @param args the command line arguments
     */
    public static void main(String[] args) {
/*
        Point[] a = new Point[10];
        Object[] b;
        b = a;
        b[0] = new Point(10, 20);*/
        
/*
        Point[] a = new Point[10];
        Object[] b;
        b = a;
        b[0] = "Magical Mystery Tour";*/
        
        /*
        Point[] a = new Point[10];
        Object[] b;
        b = a;
        a[0] = "Magical Mystery Tour";*/
        
        ArrayList<Point> a = new ArrayList<Point>();
        ArrayList<Object> b;
        
        
        
        a.add(new Point(10, 20));
        a.add(new Point(4, 6));
        System.out.println(a);
    }
    
}
