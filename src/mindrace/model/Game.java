package mindrace.model;

import mindrace.model.states.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * 
 * @author francisco
 *
 */

public class Game {
	private State state;
	private Situation situation;
	private boolean isStateInitialized;
	private QuestionSet questions;
	
	public Game(CircularList<Player> players, Player startingPlayer, State state, Board b) throws IOException, ParserConfigurationException,SAXException{
		this.state=state;
		situation= new Situation(players, startingPlayer,b);
		isStateInitialized=false;
		questions = new QuestionSet();
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
			situation=state.getSituation();
		}
		next.setCurrentSituation(situation.clone());
		state=next;
		System.out.println("Moving to state"+ state.getClass().getName());
		
	}
	public State getState(){
		return state;
	}
	public QuestionSet getQuestionSet(){
		return questions;
	}
}
