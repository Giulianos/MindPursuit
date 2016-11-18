package mindrace.model.states;

import mindrace.model.Category;
import mindrace.model.states.State;

/**
 * @author francisco
 *
 */
public class ChoosingCategory extends State implements Constants {

		private Category chosenCategory;
	/** 
	 * @see mindrace.model.states.State#initialize()
	 * Class must be provided with chosenCategory(form UI) before initializing
	 */
	@Override
	
	/**
	 * Initilize method in ChoosingCategory has nothing to do.
	 */
	public void initialize() {
		
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
	@Override
	public boolean isModifier() {
		return false;
	}

}
