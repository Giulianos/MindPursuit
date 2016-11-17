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
		//TODO has nothing to do;
		
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
	
	public void setCategory(Category chosenCategory){
		this.chosenCategory=chosenCategory;
	}

	/* (non-Javadoc)
	 * @see mindrace.model.states.State#isModifier()
	 */
	@Override
	public boolean isModifier() {
		// TODO Auto-generated method stub
		return false;
	}

}
