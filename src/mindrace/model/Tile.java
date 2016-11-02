package mindrace.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Daniella
 *
 */
public class Tile {
	private Integer position;
	private Boolean start;
	private Set<Player> players = new HashSet<Player>();

	public Tile(Integer position, Boolean start) {
		super();
		this.position = position;
		this.start = start;
	}
	
	public Integer getPosition(){
		return position;
	}
	
	public Boolean isStart(){
		return start;
	}
	
	public void addPlayer(Player player){
		players.add(player);
	}
	
	public void removePlayer(Player player){
		players.remove(player);
	}
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj.getClass().equals(this.getClass())))
			return false;
		Tile tile = (Tile)obj;
		return this.position.equals(tile.position);
	}
}
