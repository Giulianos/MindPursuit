package mindrace.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Daniella
 *
 */
public class Tile implements Serializable{
	private Integer position;
	private Set<Player> players = new HashSet<Player>();

	public Tile(Integer position){
		super();
		this.position = position;
	}
	
	public Integer getPosition(){
		return position;
	}
	
	public Boolean isStart(){
		return position == 1;
	}
	
	public void addPlayer(Player player){
		players.add(player);
	}
	
	public void removePlayer(Player player){
		players.remove(player);
	}
	
	public boolean equals(Object obj){
		if (obj == null)
			return false;
		if (!(obj.getClass().equals(this.getClass())))
			return false;
		Tile tile = (Tile)obj;
		return this.position.equals(tile.position);
	}
	public boolean isSpecial(){
		return false;
	}
	public Set<Player> stealablePlayers(Player thief){
		Set<Player> stealablePlayers = new HashSet<Player>();
		for(Player p : players) {
			if(!p.equals(thief)) {
				if(p.getTokens().size()>0) {
					stealablePlayers.add(p.clone());
				}
			}
		}
		return stealablePlayers;
	}
}
