package mindrace.model;

import mindrace.model.states.*;

import java.io.IOException;
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
	
	public Game(CircularList<Player> players, Player startingPlayer, State state) throws IOException{
		this.state=state;
		Board b= new Board();
		situation= new Situation(players, startingPlayer,b);
		isStateInitialized=false;
		}
	
	
	public void  update(){
		State next;
		if(isStateInitialized){
			next=state.terminate();
			next.setPreviousState(state);
			isStateInitialized=false;
		}
		else{
			next=state;
			state.initialize();
			isStateInitialized=true;
		}
		if(state.getClass().equals(ModifierState.class)){
			situation=state.getSituation();
		}
		next.setCurrentSituation(situation.clone());
		state=next;
		System.out.println("Moving to state"+ state.getClass().getName());
		
	}
	public State getState(){
		return state;
	}
}
