package mindrace.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Giuliano
 *
 */
public class Situation implements Cloneable{
	private Set<Player> players;
	private Player currentPlayer;
	private Board currentBoard;
	
	public Situation(Set<Player> players, Player currentPlayer, Board currentBoard) {
		this.players = players;
		this.currentPlayer = currentPlayer;
		this.currentBoard = currentBoard;
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	public Situation clone(){
		Set<Player> copyPlayers=new HashSet<Player>();
		for(Player p: this.players){
			copyPlayers.add(p.clone());
		}
		Situation clonedSituation= new Situation(copyPlayers,currentPlayer.clone(),currentBoard);
		return clonedSituation;
	}
	
}
