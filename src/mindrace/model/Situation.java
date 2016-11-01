package mindrace.model;

import java.util.Set;

/**
 * @author Giuliano
 *
 */
public class Situation {
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
	
}
