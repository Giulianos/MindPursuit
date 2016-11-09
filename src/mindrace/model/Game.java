package mindrace.model;

import mindrace.model.states.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * 
 * @author francisco
 *
 */

public class Game implements Serializable {
	private State state;
	private Situation situation;
	private boolean isStateInitialized;
	
	public Game(CircularList<Player> players, Player startingPlayer, State state, Board b) throws IOException, ParserConfigurationException,SAXException{
		this.state=state;
		situation= new Situation(players, startingPlayer,b);
		isStateInitialized=false;
		for(int i=0 ; i<players.size();i++){
			players.get(i).setTile(b.getTileAt(1));
			b.getTileAt(1).addPlayer(players.get(i));
		}
		
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
		if(state.isModifier())
		{
		situation=state.getSituation();
		}
		next.setCurrentSituation(situation.clone());
		state=next;
		System.out.println("Moving to state"+ state.getClass().getSimpleName());
		
	}
	public State getState(){
		return state;
	}
	public Situation getSituation(){
		return situation;
	}
}