/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.LinkedList;

/**
 *
 * @author joaoc
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        
        
        list.addFirst("Topo");
        list.addLast("Fim");
        list.removeFirst();
        System.out.println("Lista: " + list);
    }
    
}
