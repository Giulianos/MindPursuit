package mindrace.GUI;

import mindrace.model.Category;
import mindrace.model.Player;
import mindrace.model.Tile;

/**
 * @author francisco
 *
 */
public class MovingGUI {
	private PlayerGUI player;
	private int position;

	public MovingGUI( PlayerGUI player, int position){
		this.player=player;
		this.position=position;
	}
	
	public PlayerGUI getPlayer(){
		return player;
	}
	
	public int getPosition(){
		return position;
	}
}
