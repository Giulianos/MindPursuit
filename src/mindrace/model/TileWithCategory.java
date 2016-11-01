package mindrace.model;

/**
 * @author Daniella
 *
 */
public class TileWithCategory extends Tile {
	 Category category;

	 public TileWithCategory(Integer position, Boolean isStart, Category category) {
		super(position, isStart);
		this.category = category;
	 }
	 public Category getCategory(){
		 return category;
	 }
}
