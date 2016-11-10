package mindrace.GUI;

import java.util.HashSet;
import java.util.Set;

import mindrace.model.Category;

/**
 * @author francisco
 *
 */
public class PlayerGUI {
	private String name;
	private Set<Category> tokens;
	
	public PlayerGUI(String name, Set<Category> tokens){
		this.name=name;
		tokens= new HashSet<Category>(tokens);
	}
	
	public String getName(){
		return name;
	}
	public Set<Category> getTokens(){
		return new HashSet<Category>(tokens);
	}
	
}
