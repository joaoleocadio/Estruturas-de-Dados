/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2fp11;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.ListsException;
import PriorityQueue.PriorityQueue;
import java.util.Iterator;

/**
 *
 * @author joaoc
 */
public class EX2FP11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ListsException, ElementNotFoundException, EmptyCollectionException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Iterator itr;
        

        pq.addElement(3, 1);
        pq.addElement(2, 1);
        pq.addElement(1, 2);
        pq.addElement(6, 2);
        pq.addElement(5, 3);
        pq.addElement(4, 3);
        
        itr = pq.iteratorLevelOrder();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("----------------");
        System.out.println("Excpeted 3. Result : " + pq.removeNext());
        System.out.println("Excpeted 2. Result : " + pq.removeNext());
        itr = pq.iteratorLevelOrder();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    
}
