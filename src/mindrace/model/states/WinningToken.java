package mindrace.model.states;

import java.util.HashSet;
import java.util.Set;

import mindrace.model.Category;
import mindrace.model.TileWithCategory;


/**
 * @author Daniella, Giuliano
 *
 */
public class WinningToken extends State implements Constants{
	private Category winningCategory;
	private Set<Category> possibleTokens;
	private boolean shouldAsk=false;

	public void initialize() {
		if (this.getPreviousState().getClass().equals(Asking.class)){
			TileWithCategory auxTile = (TileWithCategory) this.getSituation().getCurrentPlayer().getTile(); 
			winningCategory = auxTile.getCategory();
		}
		/**
		 * if previous state is not asking, then it is moving.
		 * @see stateMachine
		 */
		
		else {
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
		(this.getSituation().getCurrentPlayer()).addToken(winningCategory);
		/**
		 * if the player has 6 tokens then he is the winner
		 */
		if(this.getSituation().getCurrentPlayer().getTokens().size() == QUANTITY_OF_TOKENS){
			return new WinningGame();
		}
		/**
		 *If the player owns 6 tokens and previous state is asking, 
		 *then next state is moving(Answers correctly and wins 1 token.
		 */
		else if(this.getPreviousState().getClass().equals(Asking.class)){
			return new Moving();
		}
		/**
		 * If previous state is not asking, then it´s moving. The player should go
		 * to Asking or ChoosingCategory depending on the tile
		 */
		else if (this.getSituation().getCurrentPlayer().getTile().getClass().equals(TileWithCategory.class)){
			return new Asking();
		} else {
			return new ChoosingCategory();
		}
	}
	public boolean shouldAsk(){
		return this.shouldAsk;
	}
	@Override
	public boolean isModifier() {
		return true;
	}
	
	/**
	 * @return the winningCategory
	 */
	public Category getWinningCategory() {
		return winningCategory;
	}
}
