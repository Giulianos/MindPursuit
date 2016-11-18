package mindrace.model.states;

import mindrace.model.*;

/*
 * 
 * @author Agustin Lavarello
 *
 */
public class Moving extends State implements Constants{

		/**
		 * player is the player to be moved
		 */
		private Player player; 
		/**
		 * movement has the number of the dice
		 */
		private Integer movement; 
		private Category currentCategory;
		private  static final Integer fastMovement = 5;
		private  static final Integer slowMovement = 1;
		private final static int FAST_TIME=15000; 
		private static final int QUANTITY_OF_TOKENS=6;
		
		/**
		 * initialize will update the position of the player. 
		 */
		public void initialize(){
			this.player=this.getSituation().getCurrentPlayer();
			this.setMovment();
			player.getTile().removePlayer(player);
			this.move();
			this.setCurrentCategory();
			player.getTile().addPlayer(player);
		}
		
		/**
		 * The player that goes throw starting tile, but already
		 * has 5 tokens won´t receive token.
		 */
		
		public State terminate(){
			if (player.getTile().getPosition()<movement && this.getSituation().getCurrentPlayer().getTokens().size() <= QUANTITY_OF_TOKENS-1){
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
			else if(this.getPreviousState().getClass().equals(WinningToken.class) || this.getPreviousState().getClass().equals(StealingToken.class)){
				movement = fastMovement;
			}
			else if(this.getPreviousState() instanceof Asking){
				if(((Asking) this.getPreviousState()).getTimeTaken() > FAST_TIME){   
					movement = slowMovement;
				}
				else{
					movement = fastMovement;
				}
			}
			else{
			throw new IllegalArgumentException("method called wrongly");
			}
		}
		
		private void setCurrentCategory() {
			if(player.getTile().getClass().equals(TileWithCategory.class)){
				currentCategory = ((TileWithCategory) (player.getTile())).getCategory();
			}
			else{
				currentCategory=null;
			}
		}
		public Player getPlayer(){
			return player;
		}

		@Override
		public boolean isModifier() {
			return true;
		}
		
	}