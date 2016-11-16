package mindrace.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import mindrace.GUI.*;
import mindrace.model.Category;
import mindrace.model.Game;
import mindrace.model.Player;
import mindrace.model.Question;
import mindrace.model.states.Asking;
import mindrace.model.states.ChoosingCategory;
import mindrace.model.states.Moving;
import mindrace.model.states.State;
import mindrace.model.states.StealingToken;
import mindrace.model.states.ThrowingDice;
import mindrace.model.states.WinningToken;

/**
 * @author francisco
 *
 */
public class Controller {
	
	Game game;
	View view;
	
	
	public ThrowingDiceGUI throwDice(){
			game.update();
			ThrowingDice state= (ThrowingDice) game.getState();
			ThrowingDiceGUI throwDiceGUI= createThrowingDiceGUI(state);
			game.update();
			return throwDiceGUI;
			
	}
	
	/**
	 * @param state
	 * @return
	 */
	private ThrowingDiceGUI createThrowingDiceGUI(ThrowingDice state) {
		return new ThrowingDiceGUI(state.diceNumber());
	}

	public void initialize(){
		view.chooseNumberOfPlayers();
	}
	
	public void numberOfPlayers(int numberOfPlayers){
		view.setNumberOfPlayers(numberOfPlayers);
	}
	
	public void addPlayersGraphics(List<PlayerGraphics> playersGraphics) throws IOException, ParserConfigurationException, SAXException{
		List<String> playersNames= new LinkedList<String>();
		for (PlayerGraphics player: playersGraphics)
			playersNames.add(player.getName());
		
		this.game= new Game(playersNames, new ThrowingDice());
	}
	
	public void move(){
		game.update();
		
		Moving state= (Moving) game.getState();
		
		MovingGUI movingGUI = createMovingGUI(state);
		
		view.movePlayer(movingGUI);
		
		game.update();
		if (game.getState().getClass().equals(WinningToken.class)){
			
			game.update();
			
			WinningToken winning = (WinningToken) game.getState();
			
			view.winningTokenGraphics( winning.getPossibleTokens() );
			game.update();
		}else if (game.getState().getClass().equals(Asking.class)){
			game.update();
			Asking asking= (Asking) game.getState();
			QuestionGUI questionGUI = createQuestionGUI(asking.getQuestion());
			
			view.questionGraphics(questionGUI);
		}else{
		
		/**
		 * if I�m here means next state is ChoosingCategory
		 * 
		 */
		view.choosingCategory();
		}
		
		return ;
		
	}
	
	/**
	 * @param state
	 * @return
	 */
	private MovingGUI createMovingGUI(Moving state) {
		Player player = state.getPlayer();
		String name = player.getName();
		PlayerGUI playerGUI = new PlayerGUI(name,player.getTokens());
		return new MovingGUI(playerGUI,state.getPlayer().getTile().getPosition());
	}

	public void chosenCategory(Category category){
		game.update();
		
		ChoosingCategory state= (ChoosingCategory) game.getState();
		state.setCategory(category);
		
		game.update();
		
		Asking asking= (Asking) game.getState();
		
		game.update();
		
		QuestionGUI questionGUI = createQuestionGUI(asking.getQuestion());
		
		view.questionGraphics(questionGUI);
		
		
	}
	
	
	/**
	 * @param question
	 * @return
	 */
	private QuestionGUI createQuestionGUI(Question question) {
		return new QuestionGUI(question.getQuestion(),question.getOptions(),question.getCorrectAnswer());
	}

	public void answered(QuestionGUI questionGUI){
	
		
		Asking state= (Asking) game.getState();
		
		state.setAnswer(questionGUI.getAnswer());
		
		System.out.println("1"+game.getState().getClass());
		
		game.update();
		System.out.println("2"+game.getState().getClass());
		
		
		
		if(game.getState().getClass().equals(StealingToken.class)){
			game.update();
			
			StealingTokenGUI stealing = createStealingTokenGUI((StealingToken)game.getState());
			view.stealingTokenGraphics( stealing);
		}
		else if(game.getState().getClass().equals(WinningToken.class)){
					game.update();
					WinningToken winning = (WinningToken) game.getState();
					view.showToken(winning.getWinningCategory());
					game.update();
			
		}
		else if (game.getState().getClass().equals(Moving.class)){
			this.move();
		}
		else{
		nextTurn();
		}
		
	}
	
	
	/**
	 * @param state
	 * @return
	 */
	private StealingTokenGUI createStealingTokenGUI(StealingToken state) {
		Player currentPlayer =  state.getSituation().getCurrentPlayer();
		String thieftName = currentPlayer.getName();
		PlayerGUI thieft = new PlayerGUI(thieftName,currentPlayer.getTokens());
		Set<PlayerGUI> setOfPlayers = new HashSet<PlayerGUI>();
		for(Player each : state.getPlayersToSteal())
		{
			setOfPlayers.add(new PlayerGUI(each.getName(),each.getTokens()));
		}
		return new StealingTokenGUI(setOfPlayers,thieft);
	}

	public void tokenStolen(StealingTokenGUI stealingTokenGUI){
		StealingToken stealingToken = (StealingToken) game.getState();
		String playersName = stealingTokenGUI.getStolenPlayer().getName();
		stealingToken.setTokenToSteal(game.getPlayer(playersName), stealingTokenGUI.getStolenToken());
		
		game.update();
		/**
		 * next Turn
		 */
		nextTurn();
 	}
	
	private void nextTurn(){
		game.update();
		game.update();
		PlayerGUI playerGUI= createPlayerGUI(game.getSituation().getCurrentPlayer());
		view.nextTurn(playerGUI);
	}

	/**
	 * @param currentPlayer
	 * @return
	 */
	private PlayerGUI createPlayerGUI(Player currentPlayer) {
		return new PlayerGUI(currentPlayer.getName(),currentPlayer.getTokens());
	}

	/**
	 * @param view2
	 */
	public void setView(View view) {
		this.view=view;
		
	}
	
	

}
