package mindrace.model;

import java.util.AbstractList;


/**
 * 
 * @author Agustin Lavarello
 * 
 */
public class CircularList<T> extends AbstractList<T> {

	private int size;
    private Node<T> first;
    
    
    private class Node<T> {
    	private T element;
    	private Node<T> next;
    		
    		
    	public Node(T element) {
    		this.element = element;
    		this.next = null;
    	}
    	
    	public T getElement(){
    		return this.element;
    	}	
    	
    	public Node<T> getNext() {
    		return this.next;	
    	}
    	
    	public void setNext(Node<T> n){
    		this.next = n;
    	}
    }
  
   
    public  CircularList(){
        first = null;
        size = 0;
    }

    public Node<T> getFirst(){
		return first;
	}
    
    public void addElement(T t) {
		
		Node<T> n = new Node<T>(t);
		Node<T> aux = first;
		
		if (isEmpty()) {
			first = n;
			first.setNext(n);
	
		}
		else if(first.getNext().getElement().equals(first.getElement())){
			first.setNext(n);
			n.setNext(first);
		}
		else if(aux.getNext().getNext().getElement().equals(first.getElement())){
			aux.getNext().setNext(n);
			n.setNext(first);
		}
		else {
			while(!aux.getNext().getNext().getElement().equals(first.getElement())){
				aux = aux.getNext();
			}
			aux = aux.getNext();
			aux.setNext(n);
			n.setNext(first);
		}
		size++;
		
	}

	@Override
	public T get(int index) {
		Node<T> aux = first;
		for(int i= 0; i<=index; i++){
				aux= aux.getNext();
			}
		return aux.getElement();
	}

	@Override
	public int size() {
		return size;
	}

	//busca un lemento y devuelve el proximo, si no lo encuentra devuelve null
	public T getNext(T element){
		Node<T> aux = first;
		if(aux.getElement().equals(element)){
			return aux.getNext().getElement();
		}
		aux = aux.getNext();
		while(!aux.getElement().equals(first.getElement())){
		
			if(aux.getElement().equals(element)){
				return aux.getNext().getElement();
			}
			aux = aux.getNext();
		}
		return null;
		
	}
	
	public boolean isEmpty(){
		return first == null;
	}
    
    
}

    
    
    
    
    
    