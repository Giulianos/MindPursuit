package mindrace.controller;

import java.util.LinkedList;
import java.util.List;

import mindrace.GUI.*;
import mindrace.model.Category;
import mindrace.model.Game;
import mindrace.model.states.Asking;
import mindrace.model.states.ChoosingCategory;
import mindrace.model.states.Moving;
import mindrace.model.states.StealingToken;
import mindrace.model.states.ThrowingDice;
import mindrace.model.states.WinningToken;
import mindrace.GUI.View;

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
	
	public void initialize(){
		view.chooseNumberOfPlayers();
	}
	
	public void numberOfPlayers(int numberOfPlayers){
		view.setNumberOfPlayers(numberOfPlayers);
	}
	
	public void addPlayersGraphics(List<PlayerGraphics> playersGraphics){
		List<String> playersNames= new LinkedList<String>();
		for (PlayerGraphics player: playersGraphics)
			playersNames.add(player.getName());
	}
	
	public void move(){
		game.update();
		
		Moving state= (Moving) game.getState();
		
		MovingGUI movingGUI = createMovingGUI(state);
		
		view.movePlayer(movingGUI);
		
		game.update();
		if (game.getState().equals(WinningToken.class)){
			
			game.update();
			
			WinningToken winning = (WinningToken) game.getState();
			
			view.winningTokenGraphics( winning.getPossibleTokens() );
			game.update();
		}
		
		else if (game.getState().equals(Asking.class)){
			Asking asking= (Asking) game.getState();
			QuestionGUI questionGUI = createQuestionGUI(asking.getQuestion());
			
			view.questionGraphics(questionGUI);
		}
		
		/**
		 * if I´m here means next state is ChoosingCategory
		 * 
		 */
		view.choosingCategory();
		
		return ;
		
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
	
	
	public void answered(QuestionGUI questionGUI){
	
		
		Asking state= (Asking) game.getState();
		
		state.setAnswer(questionGUI.getAnswer);
		
		game.update();
		
		
		
		if(game.getState().equals(StealingToken.class)){
			game.update();
			
			StealingTokenGUI stealing = createStealingTokenGUI(game.getState());
			view.stealingTokenGraphics( stealing);
		}
		else if(game.getState().equals(WinningToken.class)){
					game.update();
			
					WinningToken winning = (WinningToken) game.getState();
			
					view.winningTokenGraphics( winning.getPossibleTokens() );
					game.update();
			
		}
		else if (game.getState().equals(Moving.class)){
			game.update();
			game.update();
		}
		
		nextTurn();
		
		
	}
	
	
	public void tokenStolen(StealingTokenGUI stealingTokenGUI){
		StealingToken stealingToken = (StealingToken) game.getState();
		
		stealingToken.setTokenToSteal(game.getPlayer(stealingTokenGUI.getPlayerStolen())), stealingTokenGUI.getTokenToSteal());
		
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
	
	

}
