package mindrace.model.states;

import mindrace.model.Situation;
import mindrace.model.states.State;
import mindrace.model.states.*;

/**
 * 
 * @author francisco
 *
 */
public class NewTurn extends ModifierState {
	
	


	public void initialize(){
		this.getSituation().nextTurn();
	}
	
	public State terminate(){
		return new ThrowingDice();
	}

}
