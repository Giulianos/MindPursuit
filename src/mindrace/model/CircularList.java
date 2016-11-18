package mindrace.model;

import java.io.Serializable;
import java.util.AbstractList;


/**
 * 
 * @author Agustin Lavarello
 * 
 */
public class CircularList<T> implements Serializable{

	private int size;
    private Node<T> first;
    static final Integer cero = 0;
    
    
    private class Node<T> implements Serializable{
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
    
    public CircularList(CircularList<T> circularList){
		for(int i=0; i<circularList.size(); i++) {
			this.add(circularList.get(i), i);
		}
	}

    public Node<T> getFirst(){
		return first;
	}
    
    public void add(T element) {
		
		Node<T> n = new Node<T>(element);
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

	public T get(int index) {
		if(index > size) {
			throw new IllegalArgumentException();
		}
		Node<T> aux = first;
		for(int i= 0; i<index; i++){
				aux = aux.getNext();
			}
		return aux.getElement();
	}


	public int size() {
		return size;
	}

	/**
	 * 
	 * Searches for an element and returns the next one
	 * 
	 * @param element
	 * @return
	 */
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
		throw new IllegalArgumentException("Element is not on the list"); 
		
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void add(T element, Integer index){
		if(index > size){
			throw new IllegalArgumentException();
		}
		Node<T> node = first;
		Node<T> aux;
		if (index.equals(cero)) {
			for(int i=0; i<size-1; i++){
				node = node.getNext();
			}
			
			node.setNext(new Node<T>(element));
			node.getNext().setNext(first);	
			first = node.getNext();
		}
		else {
			for(int i=0; i<index-1; i++){
				node = node.getNext();
			}
			aux = node.getNext();
			node.setNext(new Node<T>(element));
			node.getNext().setNext(aux);
		}
		
	}
	
	public T get(T t){
		for (int i=0; i<this.size;i++){
			if(this.get(i).equals(t))
				return get(i);
		}
		return null;
	}
    
}