package mindrace.model.states;

import mindrace.model.Player;

/**
 * @author User
 */
public class WinningGame extends State {
	
	private Player winner;
	/**
	 * @see mindrace.model.states.State#initialize()
	 */
	@Override
	public void initialize() {
		
		this.winner= this.getSituation().getCurrentPlayer();
	}

	/**
	 * @see mindrace.model.states.State#terminate()
	 */
	@Override
	public State terminate() {
		return null;
	}

	/**
	 * @see mindrace.model.states.State#isModifier()
	 */
	@Override
	public boolean isModifier() {
		return false;
	}
	/**
	 * @return the winner
	 */
	public Player getWinner() {
		return winner;
	}
}
