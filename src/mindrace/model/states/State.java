
package mindrace.model.states;

import java.io.Serializable;

import mindrace.model.Situation;

/**
 * @author Giuliano
 *
 */
abstract public class State implements Serializable, Constants {
	
	private State previousState;
	private Situation currentSituation;
	
	/**
	 * initialize method will make all the actions that don´t need input from the user
	 */
	abstract public void initialize();

	/**
	 * terminate will decide which state will be the next
	 * 
	 * @return next state
	 */
	abstract public State terminate();
	
	/**
	 * @param currentSituation the currentSituation to set
	 */
	public void setCurrentSituation(Situation currentSituation) {
		this.currentSituation = currentSituation;
	}
	public Situation getSituation(){
		return currentSituation;
	}
	public void setPreviousState(State previousState){
		this.previousState=previousState;
	}
	public State getPreviousState(){
		return previousState;
	}
	abstract public boolean isModifier();
}
