package mindrace.model.states;

import mindrace.model.*;

/*
 * 
 * @author Agustin Lavarello
 *
 */
public class Moving extends State{

		private Player player; //este seria el jugador que va a mover
		private Integer movement; //va a tener cuanto va a moverse
		private Category currentCategory;
		private static final Integer fastMovement = 5;
		private static final Integer slowMovement = 1;
		
		
		public void initialize(){
			this.player=this.getSituation().getCurrentPlayer();
			this.setMovment();
			player.getTile().removePlayer(player);
			this.move();
			this.setCurrentCategory();
			player.getTile().addPlayer(player);
		}
		
		public State terminate(){
			if (player.getTile().getPosition()<=movement){
				return new WinningToken();
			}
			if(currentCategory == null){
				return new ChoosingCategory();
			}
			
			return new Asking();
		}
		
		private void move() {
			this.getSituation().getCurrentPlayer().move(movement);
			
		}

		private void setMovment(){
			if (this.getPreviousState().getClass().equals(ThrowingDice.class)){
				movement = ((ThrowingDice) this.getPreviousState()).diceNumber();
			}
			if(this.getPreviousState().getClass().equals(WinningToken.class) || this.getPreviousState().getClass().equals(StealingToken.class)){
				movement = fastMovement;
			}
			if(this.getPreviousState() instanceof Asking){
				if(((Asking) this.getPreviousState()).getTimeTaken() > 15){   ///falta agregar constante 
					movement = slowMovement;
				}
				else{
					movement = fastMovement;
				}
			}
			//todo: throw exception.
		}
		
		private void setCurrentCategory() {
			if(player.getTile().getClass().equals(TileWithCategory.class)){
				currentCategory = ((TileWithCategory) (player.getTile())).getCategory();
			}
			else{
				currentCategory=null;
			}
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