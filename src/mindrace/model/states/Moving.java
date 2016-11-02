import mindrace.model.Category;
import mindrace.model.Player;
import mindrace.model.Situation;
import mindrace.model.ThrowingDice;
import mindrace.model.states.ModifierState;
import mindrace.model.states.State;

/*
 * 
 * @author Agustin Lavarello
 *
 */
public class Moving extends ModifierState{

		Player player; //este seria el jugador que va a mover
		State previousState;
		Integer movement; //va a tener cuanto va a moverse
		Category currentCategory;
		Situation currentSituation;
		static final Integer fastMovement = 5;
		static final Integer slowMovement = 1;
		
		
		public Moving(State previousState){
			this.previousState = previousState;
		}
		
		public void initialize(){
			this.setMovment();
			this.move();
			this.setCurrentCategory();

			
			
		}
		
		public State terminate(){
			if(currentCategory == null){
				return new ChoosingCategory(this);
			}
			
			return new Asking(this);
		}
		
		private void move() {
			currentSituation.getActualPlayer().move(movement) // metodopara setear la posicion del jugador
			
		}

		private void setMovment(){
			if (previousState instanceof ThrowingDice){
				movement = ((ThrowDice) previousSate).getNumberOfTheDice;
			}
			if(lastState instanceof WinningToken || lastState instanceof StillToken)){
				movement = fastMovement;
			}
			if(previousState instanceof Asking){
				if(((Asking) previousState).getTimeTaken() < currentSituation.getTimeTaken()){
					movement = slowMovement;
				}
				movement = fastMovement;
			}
		}
		
		private void setCurrentCategory() {
			if(player.getTile().getClass().equals(TileWithCategory.class)){
				currentCategory = ((TileWithCategory) (player.getTile())).getCategory();
			}
		}
		
		public void setCurrentSituation(Situation currentSituation) {
			this.currentSituation = currentSituation;
		}

		/* (non-Javadoc)
		 * @see mindrace.model.states.ModifierState#getNewSituation()
		 */
		@Override
		public Situation getNewSituation() {
			return currentSituation;
		}

		
	}