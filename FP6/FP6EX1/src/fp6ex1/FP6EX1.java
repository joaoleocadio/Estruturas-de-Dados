/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp6ex1;

import SmackStack.SmackStack;

/**
 *
 * @author joaoc
 */
public class FP6EX1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SmackStack<Integer> stack = new SmackStack<>();
        
        try {
            stack.push(1); //0
            stack.push(2); //1
            stack.push(3); //2
            stack.push(4); //3
            stack.push(5); //4
            stack.push(6); //5
            stack.smack();
            stack.smack();
            stack.pop();
            System.out.println("Peek: " + stack.peek());
            System.out.println(stack.isEmpty());
            
            System.out.println(stack.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
