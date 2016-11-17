package mindrace.GUI;

import mindrace.model.Category;

/**
 * @author francisco
 *
 */
public class Theft {
		PlayerGUI playerStolen;
		Category tokenStolen;
		
		
		public Theft(PlayerGUI playerStolen, Category tokenStolen){
			this.playerStolen=playerStolen;
			this.tokenStolen=tokenStolen;
		}
		
		public PlayerGUI getPlayerStolen(){
			
			return playerStolen;
		}
		
		public Category getTokenStolen(){
			return tokenStolen;
		}
		
}
