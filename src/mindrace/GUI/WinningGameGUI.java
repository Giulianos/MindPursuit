package mindrace.GUI;

/**
 * @author francisco
 *
 */
public class WinningGameGUI {
		private PlayerGUI winner;
		
		public WinningGameGUI(PlayerGUI winner){
			this.winner=winner;
		}
		public PlayerGUI getWinner(){
			return winner;
		}
}
