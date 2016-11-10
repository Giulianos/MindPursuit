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
	 * the Maps´s key are the players to be stolen, 
	 * while in each value (the Set) is a collection
	 *  of the possible tokens to steal, doesn´t 
	 *  include the thief´s tokens.
	 */
	Map<PlayerGUI,Set<Category>> playersWithTokensToSteal;
	
	public StealingTokenGUI(Set<PlayerGUI> playersToSteal, PlayerGUI thief){
		this.playersWithTokensToSteal = new HashMap<PlayerGUI,Set<Category>>();
		for(PlayerGUI p: playersToSteal){
			Set<Category> tokensToSteal= p.getTokens();
			tokensToSteal.removeAll(thief.getTokens());
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
}
