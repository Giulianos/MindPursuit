package mindrace.model;
import mindrace.*;
import mindrace.model.states.*;
import java.io.*;

/**
 * @author francisco
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Board b= new Board();
		
		Player p1= new Player("Julian",b);
		Player p2 = new Player("Agustin",b);
		
		CircularList<Player> players = new CircularList<Player>();
		players.addElement(p1);
		players.addElement(p2);
		System.out.println("hello");
		try{
		Game game= new Game(players, p1, new ThrowingDice());
		game.update();
		game.update();
		game.update();
		game.update();
		game.update();
		}
		catch(IOException e){
			//TODO
		}
		
		

	}

}
