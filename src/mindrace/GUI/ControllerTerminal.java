package mindrace.GUI;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.View;

import mindrace.model.Board;
import mindrace.model.Category;
import mindrace.model.CircularList;
import mindrace.model.Game;
import mindrace.model.Player;
import mindrace.model.Question;
import mindrace.model.states.Asking;
import mindrace.model.states.ChoosingCategory;
import mindrace.model.states.Moving;
import mindrace.model.states.StealingToken;
import mindrace.model.states.ThrowingDice;
import mindrace.model.states.WinningToken;

/**
 * @author francisco
 *
 */
public class ControllerTerminal {
	View view;
	boolean running=true;
	boolean diceThrown=false;
	Player actualPlayer= game.getSituation().getCurrentPlayer();
	PlayerGUI playerGUI;
	private static final int START_GAME=0;
	private static final int LOAD_GAME=1;
	
	; // this should be de beginning of the game, should return a set of the players´s names, unless it is being loaded
	
		
				
	public void startGame() throws Exception{ //should especify which exceptions			
		int menuOption=view.start();
		if(menuOption==START_GAME){
			/**
			 * the order in which names are written in the computer will be the same as in the game
			 */
			List<String> playersNames= view.enteringNames();
			Game game= new Game(playersNames, new ThrowingDice());
		}
		else{
			// here should be the call for the loading
		}
		// Aclaracion todo el codigo esta con advertencias porque en el else debe ir Game.
		
		
		while(running){
				
			switch (game.getState().getClass().getSimpleName()) {
			case "NewTurn":
				
				game.update();
				game.update();
				actualPlayer=game.getSituation().getCurrentPlayer();
				view.newTurn(createPlayerGUI(actualPlayer));
				break;
				
			case "ThrowingDice":
				ThrowingDice throwingState = (ThrowingDice) game.getState();
				while(!diceThrown){
					Thread.sleep(10);
				}
				diceThrown=false;
				game.update();
				ThrowingDiceGUI throwDice= new ThrowingDiceGUI(throwingState.diceNumber());
				view.throwDice(throwDice);
				game.update();
				break;
				
			case "Moving":
				Moving movingState = (Moving) game.getState();
				actualPlayer=game.getSituation().getCurrentPlayer();
				game.update();
				game.update();
				playerGUI= createPlayerGUI(actualPlayer);
				MovingGUI movingGUI = new MovingGUI(playerGUI, actualPlayer.getTile().getPosition());
				view.move(movingGUI);
				
				break;
			case "ChoosingCategory":
				
				ChoosingCategory choosingState= (ChoosingCategory)game.getState();
				game.update();
				Category chosenCategory= view.chooseCategory();
				choosingState.setCategory(chosenCategory);
				game.update();
				break;
				
			case "StealingToken":
				
				StealingToken stealingState= (StealingToken)game.getState();
				game.update();
				Set<PlayerGUI> playersToSteal;
				for (Player p: stealingState.getPlayersToSteal() ){
						playersToSteal.add(createPlayerGUI(p));
				}
				StealingTokenGUI stealingTokenGUI= new StealingTokenGUI(playersToSteal, createPlayerGUI(actualPlayer));
				Theft theft= view.stealing(stealingTokenGUI); // Stealing debe devolver Theft
				stealingState.setTokenToSteal(game.getPlayer(theft.getPlayerStolen().getName()), theft.getTokenStolen());
				game.update();
				break;	
				
				
			case "WinningToken":
				
				WinningToken winningState= (WinningToken)game.getState();
				game.update();
				if(winningState.shouldAsk()){
					Set<Category> possibleTokens= winningState.getPossibleTokens();
					Category chosenToken= view.chooseTokenToWin(possibleTokens);	
				winningState.setChosenCategory(chosenToken);
				}
				game.update();
				break;
				
			case "Asking":
				
				Asking askingState= (Asking)game.getState();
				game.update();
				long y= System.currentTimeMillis();
				
				/**
				 * view.ask will only show the wuestion with te corresponding options, and will return the user´s choice (option);
				 */
				
				int option=view.ask(createQuestionGUI(askingState.getQuestion())); 
				long z= System.currentTimeMillis()-y;
				askingState.setAnswer(option, (int)(z/1000));
				game.update();
				/**
				 * view.endAsk will show the question with answers again, telling the user if his answer was correct or not.
				 */
				view.endAsk(askingState.getQuestion(),option,askingState.getQuestion().isCorrect(option));
				
				break;	
				
		
		    Case "WinningGame":
		    	
		    	WinningGame winningGame= (WinningGame) game.getState();
				view.winning(createWinningGameGUI(winningGame));
				running=false;
				break;
			default:
				break;
			}
			
		}
	}	

		
		private QuestionGUI2 createQuestionGUI(Question question){
			return new QuestionGUI2(question.getQuestion(),question.getOptions());
		}
		
		private WinningGameGUI createWinningGameGUI(WinningGame winningGame){
			return new WinningGameGUI(createPlayerGUI(winningGame.getWinner()));
		}
		
		private PlayerGUI createPlayerGUI(Player player){
			PlayerGUI playerGUI = new PlayerGUI(player.getName(),player.getTokens());
			return playerGUI;
			
		}
}
