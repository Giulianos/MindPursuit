package mindrace.model.states;

import java.util.Set;

import mindrace.model.Category;
import mindrace.model.Player;
import mindrace.model.Situation;

/**
 * @author Daniella
 *
 */
public class StealingToken extends State implements Constants {
	private Player playerToSteal;
	private Category categoryToSteal;
	
	public void initialize() {
	}

	public Set<Player> getPlayersToSteal(){
		return this.getSituation().getCurrentPlayer().getTile().stealablePlayers(this.getSituation().getCurrentPlayer());
	}
	
	public void setTokenToSteal(Player playerToSteal, Category category){
		this.playerToSteal = playerToSteal;
		this.categoryToSteal = category;
	}
	/**
	 * @see mindrace.model.states.ModifierState#terminate()
	 */
	@Override
	public State terminate(){
		(this.getSituation().getCurrentPlayer()).addToken(categoryToSteal);
		if(this.getSituation().getCurrentPlayer().getTokens().size() == QUANTITY_OF_TOKENS){
			return new WinningGame();
		}
		this.getSituation().getRealPlayer(playerToSteal).removeToken(categoryToSteal);
		return new Moving();
	}

	/* (non-Javadoc)
	 * @see mindrace.model.states.State#isModifier()
	 */
	@Override
	public boolean isModifier() {
		return true;
	}
}
