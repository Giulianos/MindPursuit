package mindrace.model.states;

import mindrace.model.*;

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
		private static final Integer fastMovement = 5;
		private static final Integer slowMovement = 1;
		
		
		public void initialize(){
			this.setMovment();
			this.move();
			this.setCurrentCategory();	
		}
		
		public State terminate(){
			if(currentCategory == null){
	//			return new ChoosingCategory();
			}
			
			return new Asking();
		}
		
		private void move() {
			currentSituation.getCurrentPlayer().move(movement);
			
		}

		private void setMovment(){
			if (previousState.getClass().equals(ThrowingDice.class)){
				movement = ((ThrowingDice) previousState).diceNumber();
			}
			if(previousState.getClass().equals(WinningToken.class) || previousState.getClass().equals(StealingToken.class)){
				movement = fastMovement;
			}
			if(previousState instanceof Asking){
				if(((Asking) previousState).getTimeTaken() < 15){   ///falta agregar constante 
					movement = slowMovement;
				}
				movement = fastMovement;
			}
			//todo: throw exception.
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