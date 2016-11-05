package mindrace.model.states;

import java.util.HashSet;
import java.util.Set;

import mindrace.model.Category;
import mindrace.model.Situation;
import mindrace.model.TileWithCategory;
import mindrace.model.states.ModifierState;

/**
 * @author Daniella
 *
 */
public class WinningToken extends State {
	private Category winningCategory;
	private Set<Category> possibleTokens;
	private boolean shouldAsk=false;

	/**
	 * @see mindrace.model.states.ModifierState#initialize()
	 */
	@Override
	public void initialize() {
		if (this.getPreviousState().getClass().equals(Asking.class)){
			TileWithCategory auxTile = (TileWithCategory) this.getSituation().getCurrentPlayer().getTile(); 
			winningCategory = auxTile.getCategory();  
			(this.getSituation().getCurrentPlayer()).addToken(winningCategory);
		}
		/**
		 * si no viene de asking, entonces viene de moving.
		 */
		else{
			shouldAsk=true;
			/**
			 * @see http://stackoverflow.com/a/27980614
			 */
			
			possibleTokens = new HashSet<Category>(); 
			for(Category c: Category.values()){
				possibleTokens.add(c);
			}
			for(Category c: this.getSituation().getCurrentPlayer().getTokens()){
				possibleTokens.remove(c);
			}
		}
	}

	public Set<Category> getPossibleTokens(){
		return possibleTokens;
	}
	
	public void setChosenCategory(Category category){
		winningCategory = category;
	}
	
	/**
	 * @see mindrace.model.states.ModifierState#terminate()
	 */
	@Override
	public State terminate() {
		if(winningCategory==null){
			throw new NullPointerException();
		}
		if(this.getPreviousState().getClass().equals(Asking.class)){
			return new Moving();
		} else if (this.getSituation().getCurrentPlayer().getTile().getClass().equals(TileWithCategory.class)){
			(this.getSituation().getCurrentPlayer()).addToken(winningCategory);
			return new Asking();
		} else {
			(this.getSituation().getCurrentPlayer()).addToken(winningCategory);
			return new ChoosingCategory();
		}
	}
	public boolean shouldAsk(){
		return this.shouldAsk;
	}

	/* (non-Javadoc)
	 * @see mindrace.model.states.State#isModifier()
	 */
	@Override
	public boolean isModifier() {
		// TODO Auto-generated method stub
		return true;
	}
}
