package mindrace.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Giuliano
 *
 */
public class Situation implements Cloneable, Serializable{
	private Player currentPlayer;
	private Board currentBoard;
	private CircularList<Player> playersTurn;
	private static int FIRST=0;
	
	public Situation(List<Player> players, Board currentBoard) {
		this.currentBoard = currentBoard;
		this.playersTurn = new CircularList<Player>();
		for(int i=0; i<players.size();i++){
			playersTurn.add(players.get(i));
		}
		this.currentPlayer=players.get(FIRST);
	}
	/**
	 * this constructor is used for clonation
	 * @param players
	 * @param currentPlayer
	 * @param currentBoard
	 */
	public Situation(CircularList<Player> players, Player currentPlayer, Board currentBoard) {
		this.playersTurn = players;
		this.currentPlayer = currentPlayer;
		this.currentBoard = currentBoard;
		this.playersTurn = new CircularList<Player>();
		for(int i=0; i<players.size();i++){
			playersTurn.add(players.get(i));
		}
	}
	
	public Player getCurrentPlayer() {
		return playersTurn.get(currentPlayer);
	}
	public Situation clone(){
		CircularList<Player> copyPlayers= clonePlayersTurn();
		Situation clonedSituation= new Situation(copyPlayers,currentPlayer.clone(),currentBoard);
		return clonedSituation;
	}
	public void nextTurn(){
		currentPlayer= playersTurn.getNext(currentPlayer);
	}
	public Player getRealPlayer(Player player){
		return playersTurn.get(player);
	}
	public Player getRealPlayer(String name){
		Player player= new Player(name, currentBoard);
		return getRealPlayer(player);
	}
	public void  addPlayersTurn(CircularList<Player> playersTurn){
		this.playersTurn=playersTurn;
	}
	/**
	 * @return the playersTurn
	 */
	
	public CircularList<Player> clonePlayersTurn(){
		CircularList<Player> copyPlayers=new CircularList<Player>();
		for(int i=0; i<playersTurn.size(); i++){
			copyPlayers.add(playersTurn.get(i).clone());
		}
		return copyPlayers;
	}
	
}
