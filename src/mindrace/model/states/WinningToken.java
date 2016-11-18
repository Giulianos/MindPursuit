package mindrace.model.states;

import java.util.HashSet;
import java.util.Set;

import mindrace.model.Category;
import mindrace.model.TileWithCategory;


/**
 * @author Daniella, Giuliano
 *
 */
public class WinningToken extends State {
	private Category winningCategory;
	private Set<Category> possibleTokens;
	private boolean shouldAsk=false;

	public void initialize() {
		if (this.getPreviousState().getClass().equals(Asking.class)){
			TileWithCategory auxTile = (TileWithCategory) this.getSituation().getCurrentPlayer().getTile(); 
			winningCategory = auxTile.getCategory();
		}
		/*
		 * si no viene de asking, entonces viene de moving.
		 */
		
		else {
			/*
			 * si tiene 5 Tokens no puede ganar uno por pasar por start. 
			 */
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
		/*
		 * Si el jugador tiene 6 tokens, gano.
		 */
		if(this.getSituation().getCurrentPlayer().getTokens().size() == 6){
			return new WinningGame();
		}
		/*
		 * Si el jugador no tiene 6 tokens y viene de asking, tiene que ir a moving. (Respondio bien y gano una ficha)
		 */
		else if(this.getPreviousState().getClass().equals(Asking.class)){
			return new Moving();
		}
		/*
		 * Si el jugador no viene de asking, entonces viene de moving. Y deberia ir a
		 * asking o choosing category dependiendo del casillero en donde cayo (Paso por la salida).
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

	/* (non-Javadoc)
	 * @see mindrace.model.states.State#isModifier()
	 */
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
