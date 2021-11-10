package Cifra;

import Queue.CircularArrayQueue;
import Queue.EmptyCollectionException;
import java.util.Scanner;

/**
 *
 * @author joaoc
 */
public class Cifra {
    CircularArrayQueue<Integer> queue = new CircularArrayQueue<>();
    
    public void ask() throws EmptyCollectionException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Message: ");
        String input = sc.nextLine();
        System.out.println("Enter your key: ");
        String inputKey = sc.nextLine();
        addKey(inputKey);
    }
    
    public void addKey(String key) throws EmptyCollectionException {
        String[] numbers = key.split(" ");
        
        for (int i = 0; i < numbers.length; i++) {
            try {
                int result = Integer.parseInt(numbers[i]);
                queue.enqueue(result);
            } catch (Exception e) {
                throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
            }
            
        }
    }
    
    public String printKey() {
        String text = "";
        
        text += queue.toString();
        
        return text;
    }
    
    public String encodeMessage(String message) throws EmptyCollectionException {
        String tmpString = new String();

        if (queue.size() != 0) {

            for (int i = 0; i < message.length(); i++) {
                if (message.charAt(i) != ' ') {
                    int numberKey = queue.dequeue();
                    char tmpChar;

                    if (Character.isUpperCase(message.charAt(i))) {
                        tmpChar = (char) (((int) message.charAt(i) + numberKey - 65) % 26 + 65);
                    } else {
                        tmpChar = (char) (((int) message.charAt(i) + numberKey - 97) % 26 + 97);
                    }

                    tmpString += tmpChar;
                    queue.enqueue(numberKey);
                } else {
                    tmpString += " ";
                }
            }

            return tmpString;
        }

        throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
    }
}
