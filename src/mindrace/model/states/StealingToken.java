package mindrace.model.states;

import mindrace.model.Category;
import mindrace.model.Player;
import mindrace.model.Situation;
import mindrace.model.states.ModifierState;

/**
 * @author User
 *
 */
public class StealingToken extends ModifierState {
	private Player playerToSteal;
	private Category categoryToSteal;
	
	/**
	 * @see mindrace.model.states.ModifierState#initialize()
	 */
	@Override
	public void initialize() {
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
		(currentSituation.getCurrentPlayer()).addToken(categoryToSteal);
		playerToSteal.removeToken(categoryToSteal);
		return new Moving();
	}

	/**
	 * @see mindrace.model.states.ModifierState#getNewSituation()
	 */
	@Override
	public Situation getNewSituation() {
		return currentSituation;
	}

}
