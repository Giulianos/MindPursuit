package mindrace.model.states;

import mindrace.model.Situation;
import mindrace.model.states.State;

/**
 * 
 * @author francisco
 *
 */
public class NewTurn extends State {
	
	
	/**
	 * @param previousState
	 */
	public NewTurn(State previousState) {
		super(previousState);
	}

	public void initialize(){
		previousState=null;
	}
	
	public State terminate(){
		return new ThrowingDice(this);
	}

}
