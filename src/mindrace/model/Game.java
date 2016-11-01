package mindrace.model;

import java.lang.Thread.State;
/**
 * 
 * @author francisco
 *
 */

public class Game {
	private State state;
	private Situation situation;
	private boolean isStateInitialized;
	
	public Game(State state){
		this.state=state;
		situation= new Situation();
		isStateInitialized=false;
	}
	
	public update(){
		private State next;
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
		next.setSituation(situation.clone());
		state=next;
		
	}
}
