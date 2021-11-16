/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DoubleLinkedList.DoubleLikedOrderedList;


/**
 *
 * @author joaoc
 */
public class Ex2FP5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoubleLikedOrderedList<Integer> list = new DoubleLikedOrderedList<>();
        
        try {
            list.add(2);
            list.add(4);
            list.add(6);
            list.add(8);
            list.add(5);
            
            System.out.println(list.toString());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
}
