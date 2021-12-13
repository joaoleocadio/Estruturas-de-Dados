package Tree;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.BinarySearchTreeADT;

/**
 *
 * @author joaoc
 */
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T>{

    public LinkedBinarySearchTree() {
    }

    public LinkedBinarySearchTree(T element) {
        super(element);
    }
   
    
    @Override
    public void addElement(T element) {
        BinaryTreeNode<T> temp = new BinaryTreeNode<T> (element);
        Comparable<T> comparableElement = (Comparable<T>)element;
        
        if (isEmpty()) {
            root = temp;
        } else {
            BinaryTreeNode<T> current = root;
            boolean added = false;
            
            while(!added) {
                if (comparableElement.compareTo(current.element) < 0) {
                    if (current.left == null) {
                        current.left = temp;
                        added = true;
                    } else {
                        current = current.left;
                    }                
                } else {
                    if (current.right == null) {
                        current.right = temp;
                        added = true;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
        count++;
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException{
        T result = null;
        
        if (!isEmpty()) {
            if (((Comparable)targetElement).equals(root.element)) {
                result = root.element;
                root = replacement(root);
                count--;
            } else {
                BinaryTreeNode<T> current, parent = root;
                boolean found = false;
                
                if (((Comparable)targetElement).compareTo(root.element) < 0) {
                    current = root.left;
                } else {
                    current = root.right;
                }
                
                while (current != null && !found) {
                    if (targetElement.equals(current.element)) {
                        found = true;
                        count--;
                        result = current.element;
                        
                        if (current == parent.left) {
                            parent.left = replacement(current);
                        } else {
                            parent.right = replacement(current);
                        }
                    } else {
                        parent = current;
                        
                        if (((Comparable) targetElement).compareTo(current.element) < 0)  {
                            current = current.left;
                        } else {
                            current = current.right;
                        }                        
                    }
                }
                if (!found) {
                    throw new ElementNotFoundException("binary search tree");
                }
            }
        }
        
        return result;
    }
    
    protected BinaryTreeNode<T> replacement (BinaryTreeNode<T> node) {
        BinaryTreeNode<T> result = null;
        
        if ((node.left == null) && (node.right == null)) { //Quando o node é uma folha
            result = null;
        } else if ((node.left != null) && (node.right == null)) { // Quando o node só tem um filho à esquerda, o node é substituído pelo seu filho
            result = node.left;
        } else if ((node.left == null) && (node.right != null)) { // Quando o node só tem um filho à direita, o node é substituído pelo seu filho
            result = node.right;
        } else {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;
            
            while (current.left != null) { // Chegar ao final do filho direito do lado esquerdo
                parent = current;
                current = current.left;
            }
            
            if (node.right == current) { // se o node sem filho á esquerda for o igual ao filho direito do node a remover o filho esquerdo passa a ser filho esquerdo do filho direito
                current.left = node.left;
            } else { // se o node filho da direita tiver nodes á esquerda, esse node substituirá o node removido e o node pai dele passará a ser seu filho á direita
                parent.left = current.right;
                current.right = node.right;
                current.left = node.left;
            }
            result = current;
        }
        
        return result;
    }

    @Override
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException {
        removeElement(targetElement);
        
        try {
            while (contains((T) targetElement)) {
                removeElement(targetElement);
            }
        } catch (Exception ElementNotFoundException) {
            
        }
    }

    @Override
    public T removeMin() throws EmptyCollectionException {
        T result = null;
        
        if (isEmpty()) {
            throw new EmptyCollectionException("binary search tree");
        } else {
            if (root.left == null) {
                result = root.element;
                root = root.right;
            } else {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.left;
                
                while (current.left != null) {
                    parent = current;
                    current = current.left;
                }
                
                result = current.element;
                parent.left = current.right;
            }
            
            count--;
        }
        
        return result;
    }

    @Override
    public T removeMax() throws EmptyCollectionException {
        T result = null;
        
        if (isEmpty()) {
            throw new EmptyCollectionException("binary search tree");
        } else {
            if (root.right == null) {
                result = root.element;
                root = root.left;
            } else {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.right;
                
                while (current.right != null) {                    
                    parent = current;
                    current = current.right;
                }
                
                result = current.element;
                parent.right = current.left;
            }
            
            count--;
        }
        
        return result;
    }

    @Override
    public T findMin() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTY_COLLECTION);
        }
        
        BinaryTreeNode<T> found = root;
        
        while (found.getLeft() != null) {
            found = found.getLeft();
        }
        
        return found.getElement();
    }

    @Override
    public T findMax() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTY_COLLECTION);
        }
        
        BinaryTreeNode<T> found = root;
        
        while (found.getRight() != null) {            
            found = found.getRight();
        }
        
        return found.getElement();
    }
    
}
