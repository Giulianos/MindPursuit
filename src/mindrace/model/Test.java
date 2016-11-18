package mindrace.model;
import mindrace.*;
import mindrace.model.states.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

/**
 * @author francisco
 *
 */
public class Test {

	/**
	 * @param args1
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
		List<String> players;
		Game game;
		boolean flag = true;
			try{
				
				System.out.println("Bienvenido al carrera de Mente. Disfrute de su partida");
				Scanner reader= new Scanner(System.in);
				System.out.println("Cargar partida?");
				String rta1 = reader.nextLine();
				if(rta1.equals("yes"))
				{
					ObjectInputStream file =  new ObjectInputStream(
							new BufferedInputStream(
									new FileInputStream("game.out")));
					game = (Game) file.readObject();
					file.close();
				}
				else
				{
					players = new LinkedList<String>();
					players.add("julian");
					players.add("roberto");
					game = new Game(players,new ThrowingDice());
				}
				while(true && flag){
					System.out.println(game.getSituation().getCurrentPlayer());
					System.out.println("Posicion: "+game.getSituation().getCurrentPlayer().getTile().getPosition());
				switch (game.getState().getClass().getSimpleName()) {
				case "NewTurn":
					System.out.println("Desea guardar el juego?");
					String rta = reader.next();
					if(rta.equals("yes"))
					{
						ObjectOutputStream file =  new ObjectOutputStream(
								new BufferedOutputStream(
										new FileOutputStream("game.out")));
						file.writeObject(game);
						flag = false;
						file.close();
					}
					else
					{
						game.update();
						game.update();
					}
					break;
				case "ThrowingDice":
					game.update();
					System.out.println("Salio el dado: " + ((ThrowingDice)game.getState()).diceNumber());
					game.update();
					
					break;
				case "Moving":
					game.update();
					game.update();
					
					break;
				case "ChoosingCategory":
					
					ChoosingCategory choosingState= (ChoosingCategory)game.getState();
					game.update();
					for (int i=1; i<= Category.values().length;i++){
					System.out.println("Opcion " + i +  " :"+Category.values()[i-1]);
					}
					int a =reader.nextInt();
					choosingState.setCategory(Category.values()[a-1]);
					game.update();
					break;
					
				case "StealingToken":
					
					StealingToken stealingState= (StealingToken)game.getState();
					game.update();
					System.out.println("Las opciones a robar son:");
					for (int i = 1; i<=stealingState.getPlayersToSteal().toArray().length;i++ ){
							System.out.println("Jugador " + i+ stealingState.getPlayersToSteal().toArray()[i-1]);
							
						
					}
					System.out.println("Ingrese numero de jugador");
					int c = reader.nextInt();
					System.out.println("Ingrese opcion de token");
					int d = reader.nextInt();
					stealingState.setTokenToSteal((Player)stealingState.getPlayersToSteal().toArray()[c-1],
							(Category)stealingState.getPlayersToSteal().toArray(new Player[0])[c-1].getTokens().toArray()[d-1]);
					game.update();
					break;	
				case "WinningToken":
					
					WinningToken winningState= (WinningToken)game.getState();
					game.update();
					if(winningState.shouldAsk()){
							System.out.println("Elige una Categoria");
					for (int i = 1; i<=winningState.getPossibleTokens().size();i++ ){
							System.out.println("Token " + i+ (Category)winningState.getPossibleTokens().toArray()[i-1]);	
					}
					int e = reader.nextInt();
					winningState.setChosenCategory(((Category)winningState.getPossibleTokens().toArray()[e-1]));
					}
					game.update();
					break;
				case "Asking":
					
					Asking askingState= (Asking)game.getState();
					game.update();
					System.out.println("Estas son las opciones");
					Question question=askingState.getQuestion();
					System.out.println(question);
					System.out.println("Elije una respuesta");
					long y= System.currentTimeMillis();
					int f = reader.nextInt();
					long z= System.currentTimeMillis()-y;
					System.out.println((int)(z/1000));
					askingState.setAnswer(f-1, (int)(z/1000));
					game.update();
					
					break;	
					
	
				default:
					break;
				}
				
				}
			}
			catch(Exception e)
			{
				
			}
		
		
	}

}
