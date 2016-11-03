package mindrace.model.states;

import mindrace.model.Category;
import mindrace.model.states.State;

/**
 * @author francisco
 *
 */
public class ChoosingCategory extends State {

		private Category chosenCategory;
	/** 
	 * @see mindrace.model.states.State#initialize()
	 * Class must be provided with chosenCategory(form UI) before initializing
	 */
	@Override
	public void initialize() {
		//TODO has nothing to to;
		
	}

	/** 
	 * @see mindrace.model.states.State#terminate()
	 */
	@Override
	public State terminate() {
		return new Asking();
	}
	public Category getCategory(){
		return chosenCategory;
	}

}
