package ex1;

/**
 *
 * @author joaoc
 */
public class LinkedList<T> {

    private LinearNode<T> first;
    private LinearNode<T> last;
    private int cont;

    public LinkedList() {
        this.cont = 0;
        this.first= null;
        this.last = null;
    }

    public LinearNode<T> getFirst() {
        return first;
    }

    public void setFirst(LinearNode<T> first) {
        this.first = first;
    }

    public LinearNode<T> getLast() {
        return last;
    }

    public void setLast(LinearNode<T> last) {
        this.last = last;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public void add(T element) {
        LinearNode<T> newElement = new LinearNode<>(element);

        /**
         * Como a lista está vazia temos que apontar o FIRST e o LAST para o nó criado
         */
        if (this.cont == 0) {
            this.first = newElement;
            this.last = newElement;
        } else {
            /**
             * Caso já exista algum elemento na lista, então o last aponta para o último elemento inserido 
             */
            newElement = this.last;
            
            LinearNode<T> next = new LinearNode<>(element);
            newElement.setNext(next);
            this.last = next;
        }

        this.cont++;
    }

    private boolean isEmpty() {
        return (this.cont == 0);
    }

    public void remove(T element) {
        if (isEmpty()) {
            return;
        } else {
            LinearNode<T> atual = this.first; //atual aponta para o seguinte
            LinearNode<T> anterior = null; //atual aponta para o anterior
            
            boolean found = false;

            while (atual != null && found == false) {
                if (atual.getElement().equals(element)) {
                    found = true;
                } else {
                    anterior = atual;
                    atual = anterior.getNext();
                }     
            }
            
            if (found == true) {
                //Só existe uma elemento na lista
                if (this.cont == 1) {
                    this.first = null;
                    this.last = null; 
                    
                    /**
                     * Quando o elemento que queremos remover é o primeiro da lista, então o first aponta para o seguinte
                     * e o elemento a receber recebe null
                     **/
                } else if (atual.getElement().equals(first.getElement())) { 
                    LinearNode<T> atualHead = atual;
                    first = first.getNext();
                    atualHead.setNext(null);
                    
                    /**
                     * Quando o elemento que queremos receber é o último da lista, então o next recebe null e o last 
                     * aponta para o nó auxiliar chamado anterior
                     */
                } else if (atual.getElement().equals(last.getElement())) {
                    anterior.setNext(null);
                    last = anterior;
                } else {
                    /**
                     * Quando o elemento que queremos remover se encontra "no meio" da lista, então o anterior recebe o next do atual
                     * e fazemos um set para null
                     */
                    anterior.setNext(atual.getNext());
                    atual.setNext(null);
                }
                this.cont--;
            }
        }     
    }

    private void info() {
        System.out.println("********* Info *********");
        System.out.println("HEAD: " + this.first.getElement().toString());
        System.out.println("TAIL: " + this.last.getElement().toString());
        System.out.println("Nº de elementos na lista: " + this.cont);
    }

    public void printList() {
        LinearNode<T> tmp = this.first;      
        
        while(tmp != null) {
            System.out.println(tmp.toString());
            tmp = tmp.getNext();
        } 
        
        // Invocação da função acima
        info();  
    }

}
