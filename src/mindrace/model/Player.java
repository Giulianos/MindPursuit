package mindrace.model;

import java.io.Serializable;
import java.util.HashSet;
import mindrace.model.Category;
import java.util.Set;
/**
 * 
 * @author francisco
 *
 */

public class Player implements Cloneable, Serializable{
	private Board board;
	private String name;
	private Set<Category> tokens;
	private Tile tile;
	
	public Player(String name, Board b){
		this.name = name;
		this.tokens = new HashSet<Category>();
		this.board=b;
		this.tile = board.startingTile();
	}
	
	public String getName(){
		return name;
	}
	public Tile getTile(){
		return tile;
	}
	
	public void addToken(Category category){
		tokens.add(category);
	}
	public void removeToken(Category category){
		if(!tokens.contains(category)){
			throw new IllegalArgumentException("Doesn�t have that token");
		}
		tokens.remove(category);
	}
	
	public void move(int quantity){
		if(quantity<0){
			throw new IllegalArgumentException("quantity must be non negative");
		}
		for (int i=quantity; i>0;i--){
			tile=board.getNext(tile);
		}
	}
	public Player clone(){
		Player cloned= new Player(this.name, board);
		Set<Category> clonedTokens= new HashSet<Category>();
		clonedTokens.addAll(this.tokens);
		cloned.tokens=clonedTokens;
		cloned.tile=this.tile;
		return cloned;
	}
	public void setBoard(Board b){
		this.board=b;
	}
	public Set<Category> getTokens() {
		Set<Category> tokensCopy = new HashSet<Category>();
		tokensCopy.addAll(this.tokens);
		return tokensCopy;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		if(!obj.getClass().equals(this.getClass())){
			return false;
		}
		Player aux= (Player) obj;
		return this.name.equals(aux.getName());
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String string =this.name;
		for(Category c: tokens){
			string+=c.toString();
		}
		return string;
	}
	public void setTile(Tile tile){
		this.tile=tile;
	}

}
