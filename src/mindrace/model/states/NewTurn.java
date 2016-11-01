package mindrace.model.states;

import mindrace.model.states.State;

/**
 * 
 * @author francisco
 *
 */
public class NewTurn extends State {
	
	
	public void initialize(){
		previousState=null;
	}
	
	public State terminate(){
		return new ThrowingDice(this);
	}

}
