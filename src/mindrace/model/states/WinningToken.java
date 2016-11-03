package mindrace.model.states;

import mindrace.model.Category;
import mindrace.model.Situation;
import mindrace.model.states.ModifierState;

/**
 * @author Daniella
 *
 */
public class WinningToken extends ModifierState {
	private Category winningCategory;
	/**
	 * @see mindrace.model.states.ModifierState#initialize()
	 */
	@Override
	public void initialize() {
		(this.getSituation().getCurrentPlayer()).addToken(winningCategory);
	}

	/**
	 * @see mindrace.model.states.ModifierState#terminate()
	 */
	@Override
	public State terminate() {
		if(this.getPreviousState().equals(Moving.class)){
			return new ChoosingCategory();
		}
		return new Moving();
	}



}
