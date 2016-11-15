package mindrace.GUI;

import java.util.List;
import java.util.Set;

import mindrace.model.Category;
import mindrace.model.Question;

/**
 * @author Giuliano, Daniella
 *
 */
public class View {
	
	Controller controller;
	
	BoardGraphics board;
	List<PlayerGraphics> playersGraphics;
	private static int numberOfPlayers;
	
	/**
	 * getPlayerGraphics returns null if element not found
	 * @param player
	 * @return
	 */
	
	public PlayerGraphics getPlayerGraphics(PlayerGUI player){
		for (PlayerGraphics playerGraphics: playersGraphics){
			if(playerGraphics.getPlayerGUI().equals(player))
				return playerGraphics;
		}
		return null;
	}
	public int start(){
		return 0;
	}
	
	public void addPlayersGraphics(){
		playersGraphics.add(player);
	}
	
	
	public void enteringNames(){
		if(numberOfPlayers!=0){
			numberOfPlayers--;
			new SettingPlayersGraphic(this);
		}
		controller.addPlayersGraphics(playersGraphics);
		this.board= new BoardGraphics(playersGraphics);
			
	}
	
	
	public void setNumberOfPlayers(){
		this.numberOfPlayers=numberOfPlayers;
	}
	
	public void openMenu(){
		new MenuGraphics(controller);
	}
	
	public void chooseNumberOfPlayers(){
		ChoosingPlayersGraphics choosing=new ChoosingPlayersGraphics();
		
	}
	public void winning(WinningGameGUI winningGame){
		
	}
	
	public void winningTokenGraphics( Set<Category> possibleTokens){
		new WinningTokenGraphics(controller, possibleTokens);
		

	
	public void movePlayer(MovingGUI moving){
		Point newPosition= TilesGUI.tilesPosition[moving.getPosition()];
		PlayerGraphics currentPlayerGraphics= getPlayerGraphics(moving.getPlayer());
		currentPlayerGraphics.setCoordinates(newPosition);
		currentPlayerGraphics.update();
		board.setCurrentPlayer(currentPlayerGraphics);
		board.draw();
		
	}
	
	public void QuestionGraphics(QuestionGUI question){
		new QuestionGraphics(controller, question);
	}
	
	public void choosingCategory(){
		new ChoosingCategory(controller);
	}
	
	public void stealingTokenGraphics(StealingTokenGUI stealing){
		new StealingTokenGraphics(controller,stealing);
	}
	
	public void nextTurn(PlayerGUI player){
		PlayerGraphics currentPlayerGraphics= getPlayerGraphics(player);
		board.setCurrentPlayer(currentPlayerGraphics);
		board.newTurn();
	}
}
