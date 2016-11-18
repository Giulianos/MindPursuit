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
		this.tokens= new HashSet<Category>(tokens);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the tokens
	 */
	public Set<Category> getTokens() {
		return tokens;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		
		if(!obj.getClass().equals(this.getClass())){
			return false;
		}
		
		PlayerGUI other = (PlayerGUI) obj;
		return other.getName().equals(name);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode();
	}

}