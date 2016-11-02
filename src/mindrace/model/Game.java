package mindrace.model;

import mindrace.model.states.*;
import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author francisco
 *
 */

public class Game {
	private State state;
	private Situation situation;
	private boolean isStateInitialized;
	private CircularList<Player> playersTurn;
	private Set<Player> players;
	
	public Game(CircularList playersTurn, Player startingPlayer, State state){
		this.state=state;
		this.playersTurn=playersTurn;
		this.players= new HashSet<Player>();
		this.players.addAll(playersTurn);
		situation= new Situation(players, startingPlayer,new Board());
		isStateInitialized=false;
	}
	
	public void  update(){
		State next;
		if(isStateInitialized){
			next=state.terminate();
			isStateInitialized=false;
		}
		else{
			next=state;
			state.initialize();
			isStateInitialized=true;
		}
		if(state.getClass().equals(Modifier.class)){
			situation=state.getSituation();
		}
		next.setCurrentSituation(situation.clone());
		state=next;
		
	}
}
