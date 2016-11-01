package mindrace.model;

import java.util.HashSet;
import mindrace.model.Category;
import java.util.Set;
/**
 * 
 * @author francisco
 *
 */

public class Player implements Cloneable{
	private Board board;
	private String name;
	private Set<Category> tokens;
	private Tile tile;
	
	public Player(String name){
		this.name = name;
		this.tokens = new HashSet<Category>();
		this.tile = board.startingTile();
	}
	
	public String getName(){
		return name;
	}
	
	public void addToken(Category category){
		if(tokens.contains(category)){
			throw new IllegalArgumentException("Has that token");
		}
		tokens.add(category);
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
		Player cloned= new Player(this.name);
		cloned.board=this.board;
		Set<Category> clonedTokens= new HashSet<Category>();
		clonedTokens.addAll(this.tokens);
		cloned.tokens=clonedTokens;
		cloned.tile=this.tile;
		return cloned;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.name.equals(obj.toString());
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

}
