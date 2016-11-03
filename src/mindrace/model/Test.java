package mindrace.model;
import mindrace.*;
import mindrace.model.states.*;
import java.io.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

/**
 * @author francisco
 *
 */
public class Test {
	//hola como estas ?

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		Board b= new Board();
//		
//		Player p1= new Player("Julian",b);
//		Player p2 = new Player("Agustin",b);
//		
//		CircularList<Player> players = new CircularList<Player>();
//		players.addElement(p1);
//		players.addElement(p2);
//		System.out.println("hello");
//		try{
//		Game game= new Game(players, p1, new ThrowingDice());
//		game.update();
//		game.update();
//		game.update();
//		game.update();
//		game.update();
//		}
//		catch(IOException e){
//			//TODO
//		}
//		
//		
//
//	}
	public static void main(String[] args) {
		Board b;
		try {
			b = new Board();
			TileWithCategory tileN = (TileWithCategory)b.getTileAt(42);
			System.out.println(tileN.getPosition());
			Player p1 = new Player("agustin", b);
			Player p2 = new Player("Julian", b);
			CircularList<Player> players = new CircularList<Player>();
			players.add(p1);
			players.add(p2);
			Game game = new Game(players, p1,new ThrowingDice(), b);
			game.update();
			game.update();
			game.update();
			game.update();
			((Asking)(game.getState())).addQuestionSet(game.getQuestionSet());
			game.update();
			((Asking)game.getState()).setAnswer(1, 10);
			game.update();
			game.update();
			game.update();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
