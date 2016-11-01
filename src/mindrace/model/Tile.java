package mindrace.model;

/**
 * @author Daniella
 *
 */
public class Tile {
	Integer position;
	Boolean isStart;
	Set<Player> Players;

	public Tile(Integer position, Boolean isStart, Set<Player> players) {
		super();
		this.position = position;
		this.isStart = isStart;
		Players = players;
	}
	
	public Boolean isStart(){
}
