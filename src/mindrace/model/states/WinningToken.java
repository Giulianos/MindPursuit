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
		(currentSituation.getCurrentPlayer()).addToken(winningCategory);
	}

	/**
	 * @see mindrace.model.states.ModifierState#terminate()
	 */
	@Override
	public State terminate() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see mindrace.model.states.ModifierState#getNewSituation()
	 */
	@Override
	public Situation getNewSituation() {
		// TODO Auto-generated method stub
		return null;
	}

}
