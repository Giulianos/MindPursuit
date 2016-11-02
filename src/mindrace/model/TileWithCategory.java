package mindrace.model;

/**
 * @author Daniella
 *
 */
public class TileWithCategory extends Tile {
	 Category category;
	 Boolean special;

	 public TileWithCategory(Integer position, Boolean start, Boolean special, Category category) {
		super(position, start);
		this.category = category;
		this.special = special;
	 }
	 
	 public Boolean isSpecial() {
		 return special;
	 }
	 
	 public Category getCategory(){
		 return category;
	 }
}
