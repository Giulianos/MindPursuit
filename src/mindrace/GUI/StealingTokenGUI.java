package mindrace.GUI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import mindrace.model.Category;
import mindrace.model.states.*;

/**
 * @author francisco
 *
 */
public class StealingTokenGUI {
	/** 
	 * the Maps�s key are the players to be stolen, 
	 * while in each value (the Set) is a collection
	 *  of the possible tokens to steal, doesn�t 
	 *  include the thief�s tokens.
	 */
	private Map<PlayerGUI,Set<Category>> playersWithTokensToSteal;
	private PlayerGUI stolenPlayer;
	private Category stolenToken;
	
	public StealingTokenGUI(Set<PlayerGUI> playersToSteal, PlayerGUI thief){
		this.playersWithTokensToSteal = new HashMap<PlayerGUI,Set<Category>>();
		for(PlayerGUI p: playersToSteal){
			Set<Category> tokensToSteal= p.getTokens();
			this.playersWithTokensToSteal.put(p, tokensToSteal);
		}
	}
	
	/**
	 * 
	 * Method return real map (not a copy) cause it wont be used again.
	 */
	public Map<PlayerGUI,Set<Category>> getPlayersWithTokensToSteal(){
		return playersWithTokensToSteal;
	}
	/**
	 * @return the stolenPlayer
	 */
	public PlayerGUI getStolenPlayer() {
		return stolenPlayer;
	}
	/**
	 * @param stolenPlayer the stolenPlayer to set
	 */
	public void setStolenPlayer(PlayerGUI stolenPlayer) {
		this.stolenPlayer = stolenPlayer;
	}
	/**
	 * @param stolenToken the stolenToken to set
	 */
	public void setStolenToken(Category stolenToken) {
		this.stolenToken = stolenToken;
	}
	/**
	 * @return the stolenToken
	 */
	public Category getStolenToken() {
		return stolenToken;
	}
	
}
