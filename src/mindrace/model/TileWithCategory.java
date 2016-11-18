package mindrace.model;

/**
 * @author Daniella
 *
 */
public class TileWithCategory extends Tile{
	 Category category;
	 Boolean special;
	 
	 public TileWithCategory(Integer position, Boolean special, Category category){
		super(position);
		this.category = category;
		this.special = special;
	 }
	 
	 public Category getCategory(){
		 return category;
	 }
	 
	 public boolean isSpecial(){
		 return special;
	 }
}
