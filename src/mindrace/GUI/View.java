package mindrace.GUI;

import java.awt.Point;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import mindrace.controller.Controller;
import mindrace.model.Category;
import mindrace.model.Question;

/**
 * @author Giuliano, Daniella
 *
 */
public class View {
	
	private Controller controller;
	private TilesGUI tiles= new TilesGUI();
	
	BoardGraphics board;
	List<PlayerGraphics> playersGraphics= new LinkedList<PlayerGraphics>();
	private static int numberOfPlayers;
	
	/**
	 * getPlayerGraphics returns null if element not found
	 * @param player
	 * @return
	 */
	
	public PlayerGraphics getPlayerGraphics(PlayerGUI player){
		for (PlayerGraphics playerGraphics: playersGraphics){
			if(playerGraphics.getName().equals(player.getName()))
				return playerGraphics;
		}
		return null;
	}
	public void addPlayersGraphics(PlayerGraphics player){
		playersGraphics.add(player);
	}
	
	
	public void enteringNames() throws IOException, ParserConfigurationException, SAXException{
		if(numberOfPlayers!=0){
			numberOfPlayers--;
			new SettingPlayersGraphics(this);
		}
		else{
		controller.addPlayersGraphics(playersGraphics);
		this.board= new BoardGraphics(playersGraphics, controller);
		}
			
	}

	
	
	public void setNumberOfPlayers(int numberOfPlayers){
		this.numberOfPlayers=numberOfPlayers;
	}
	
	public void openMenu(){
		new MenuGraphics(controller);
	}
	
	public void chooseNumberOfPlayers(){
		ChoosingPlayersGraphics choosing=new ChoosingPlayersGraphics(controller, this);
		
	}
	public void winning(WinningGameGUI winningGame){
		
	}
	
	public void winningTokenGraphics( Set<Category> possibleTokens){
		new WinningTokenGraphics(controller, possibleTokens);
	}

	public void movePlayer(MovingGUI moving){
		Point newPosition= tiles.getTilesPositions().get(moving.getPosition());
		PlayerGraphics currentPlayerGraphics= getPlayerGraphics(moving.getPlayer());
		currentPlayerGraphics.setCoordinates(newPosition);
		currentPlayerGraphics.update();
		board.setCurrentPlayer(currentPlayerGraphics);
		board.setCurrentPlayerGUI(moving.getPlayer());
		board.draw();
		
	}
	
	public void setController(Controller controller){
		this.controller=controller;
	}
	
	public void questionGraphics(QuestionGUI question){
		new QuestionGraphics(controller,question);
	}
	
	public void choosingCategory(){
		new ChoosingCategoryGraphics(controller);
	}
	
	public void stealingTokenGraphics(StealingTokenGUI stealing){
		new StealingTokenGraphics(controller,stealing);
	}
	
	public void nextTurn(PlayerGUI player){
		PlayerGraphics currentPlayerGraphics= getPlayerGraphics(player);
		board.setCurrentPlayer(currentPlayerGraphics);
		board.setCurrentPlayerGUI(player);
		board.newTurn();
	}
	public void updateBoard(PlayerGUI player){
		board.setCurrentPlayer(player);
	}
}
