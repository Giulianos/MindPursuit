package mindrace.model.states;

import mindrace.model.Situation;

/**
 * @author Daniella
 *
 */
public abstract class ModifierState extends State {

	/**
	 * @see mindrace.model.states.State#initialize()
	 */
	@Override
	public abstract void initialize();

	/**
	 * @see mindrace.model.states.State#terminate()
	 */
	@Override
	public abstract State terminate();
	
	public abstract Situation getNewSituation();
}
