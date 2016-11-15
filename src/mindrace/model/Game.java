package mindrace.model;

import mindrace.model.states.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
	
	public Game(List<String> playersNames, State state) throws IOException, ParserConfigurationException,SAXException{
		this.state=state;
		Board board= new Board();
		List<Player> players =iniciatePlayers(playersNames, board);
		situation= new Situation(players,board);
		isStateInitialized=false;
		for(int i=0 ; i<players.size();i++){
			players.get(i).setTile(board.getTileAt(0));
			board.getTileAt(0).addPlayer(players.get(i));
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
		
	}
	public State getState(){
		return state;
	}
	public Situation getSituation(){
		return situation;
	}
	public Player getPlayer(String name){
		return situation.getRealPlayer(name);
	}
	public List<Player> iniciatePlayers(List<String> playersToCreate, Board board){
		
		List<Player> players= new LinkedList<Player>();
		for (String names: playersToCreate){
			players.add(new Player(names,board));
		}
		return players;
	}
}