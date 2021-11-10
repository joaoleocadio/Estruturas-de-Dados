package ex1;

import Stack.ArrayStack;
import Stack.EmptyCollectionException;
import java.util.Scanner;

/**
 *
 * @author joaoc
 */
public class Calculadora {
    
    private ArrayStack<Integer> stack;
    private String expression = null;

    public Calculadora() {
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
    
    private boolean stringToInt(String text){
        try {
            int result = Integer.parseInt(text);
            stack.push(result);
            return true;
        }catch (Exception ex){
            return false;
        }
    }    
    
    private boolean calculate(String text) {
        if(text.equals("+")){
            try {
                int value1 = stack.pop();
                int value2 = stack.pop();
                int result = value2 + value1;
                stack.push(result);
            } catch (Exception e) {
                return false;
            }
            return true;
        }else if (text.equals("-")){
            try {
                int value1 = stack.pop();
                int value2 = stack.pop();
                int result = value2 - value1;
                stack.push(result);
            } catch (Exception e) {
                return false;
            }
            return true;
        }else if (text.equals("*")){
            try {
                int value1 = stack.pop();
                int value2 = stack.pop();
                int result = value2 * value1;
                stack.push(result);
            } catch (Exception e) {
                return false;
            }
            return true;
        }else if (text.equals("/")){
            try {
                int value1 = stack.pop();
                int value2 = stack.pop();
                int result = value2 / value1;
                stack.push(result);
            } catch (Exception e) {
                return false;
            }
            return true;
        }else {
            return false;
        }
    }
    
    public int execute() throws EmptyCollectionException {
        if(expression.length() < 5 || expression == null){ //_Verificar se a string tem pelo menos 3 elementos ou que não é null
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        } else {
            //expression = expression + " "; //Adicionar ultimo espaço á expressão
            int lastPositionWithoutSpace = 0;
            stack = new ArrayStack<Integer>();
            for(int i = 0; i < expression.length(); i++){
                if(expression.charAt(i)== ' '){ //Procurar espaço branco
                    String tmp = expression.substring(lastPositionWithoutSpace, i); //criar subString
                    boolean resultStringToInt = stringToInt(tmp); //Tentar converter para int
                    if(resultStringToInt == false){ // Se não for int
                        if(stack.size() < 2){ // E se não existir pelo menos dois elementos na stack                        
                            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
                        }else { // Se existirem pelo menos dois elementos pode se tentar fazer operação
                            boolean resultMakeOperation = calculate(tmp);
                            if(resultMakeOperation == false){
                                throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
                            }else{
                                lastPositionWithoutSpace = i + 1; //guardar a ultima posição a seguir ao espaço
                            }
                        }
                    }else{
                        lastPositionWithoutSpace = i + 1; //guardar a ultima posição a seguir ao espaço
                    }
                }
            }
        }
        try {
            return stack.peek();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
}
