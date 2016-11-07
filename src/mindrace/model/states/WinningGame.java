package mindrace.model.states;

/**
 * @author User
 */
public class WinningGame extends State {
	/**
	 * @see mindrace.model.states.State#initialize()
	 */
	@Override
	public void initialize() {
	}

	/**
	 * @see mindrace.model.states.State#terminate()
	 */
	@Override
	public State terminate() {
		return null;
	}

	/**
	 * @see mindrace.model.states.State#isModifier()
	 */
	@Override
	public boolean isModifier() {
		return false;
	}
}
