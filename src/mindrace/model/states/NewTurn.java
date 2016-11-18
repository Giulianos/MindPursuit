package mindrace.model.states;

import mindrace.model.states.State;

/**
 * 
 * @author francisco
 *
 */
public class NewTurn extends State implements Constants{
	
	


	public void initialize(){
		this.getSituation().nextTurn();
	}
	
	public State terminate(){
		return new ThrowingDice();
	}

	
	@Override
	public boolean isModifier() {
		return true;
	}

}
