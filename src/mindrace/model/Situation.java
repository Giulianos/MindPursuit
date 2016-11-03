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
	private CircularList<Player> playersTurn;
	
	public Situation(CircularList<Player> players, Player currentPlayer, Board currentBoard) {
		this.playersTurn = players;
		this.currentPlayer = currentPlayer;
		this.currentBoard = currentBoard;
		this.players= new HashSet<Player>();
		for(int i= 0; i < players.size();i++ ){
			this.players.add(players.get(i));
		}
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	public Situation clone(){
		CircularList<Player> copyPlayers=new CircularList<Player>();
		for(Player p: this.players){
			copyPlayers.add(p.clone());
		}
		Situation clonedSituation= new Situation(copyPlayers,currentPlayer.clone(),currentBoard);
		return clonedSituation;
	}
	public void nextTurn(){
		currentPlayer= playersTurn.getNext(currentPlayer);
	}
	
}
