package mindrace.model.states;

import mindrace.model.Situation;

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
		this.categoryToSteal = categoryToSteal;
	}
	/**
	 * @see mindrace.model.states.ModifierState#terminate()
	 */
	@Override
	public State terminate() {
		Category categoryToSteal;
		(currentSituation.getCurrentPlayer()).addToken(category);
		
	}

	/**
	 * @see mindrace.model.states.ModifierState#getNewSituation()
	 */
	@Override
	public Situation getNewSituation() {
	
	}

}
