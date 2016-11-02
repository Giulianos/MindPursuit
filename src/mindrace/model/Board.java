package mindrace.model;

/**
 * @author francisco
 *
 */
public class Board{
	
	private CircularList<Tile> tiles = new CircularList<Tile>();
	public Board(){
		Tile t1 = new Tile(0, true);
		Tile t2 = new Tile(1, false);
		Tile t3= new TileWithCategory(2, false, Category.ART);
		
		tiles.addElement(t1);
		tiles.addElement(t2);
		tiles.addElement(t3);
	}
	public Tile getNext(Tile t){
		Tile ret= tiles.getNext(t);
		if (ret==null){
			throw new IllegalArgumentException();
		}
		return ret;
	}
	/**
	 * @return
	 */
	public Tile startingTile() {
		System.out.println();
		return tiles.get(0);
	}
	
}
