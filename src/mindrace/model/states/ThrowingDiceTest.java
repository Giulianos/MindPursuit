package mindrace.model.states;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import mindrace.model.Board;
import mindrace.model.Category;
import mindrace.model.Player;
import mindrace.model.Situation;

/**
 * @author Daniella, Giuliano
 *
 */
public class ThrowingDiceTest {
	private Integer diceNumber;
	private Random randomNumber;
	private static final int  MINIMALNUMBER = 1;
	private static final int MAXIMALNUMBER = 6;
	Player juancito;
	Player pedro;
	Category categoryToSteal;
	List<Player> players;
	Board board;
	NewTurn newTurn;
	Situation situation;
	ThrowingDice throwingDice;
	Moving moving;
	
	@Before
	public void testSetUp()throws Exception{
		newTurn = new NewTurn();
		throwingDice = new ThrowingDice();
		throwingDice.setPreviousState(newTurn);
		randomNumber = new Random();
		board = new Board();
		juancito = new Player("Juancito", board);
		pedro = new Player("Pedro", board);
		juancito.addToken(Category.Art);
		pedro.addToken(Category.Entertainment);
		juancito.setTile(board.getTileAt(4));
		pedro.setTile(board.getTileAt(4));
		players = new LinkedList();
		players.add(juancito);
		players.add(pedro);
		board.getTileAt(4).addPlayer(players.get(0));
		board.getTileAt(4).addPlayer(players.get(1));
		situation = new Situation(players,board);
		throwingDice.setCurrentSituation(situation);
		moving = new Moving();
		diceNumber = throwingDice.throwDice();
		
	}


	/**
	 * Test method for {@link mindrace.model.states.ThrowingDice#terminate()}.
	 */
	@Test
	public void testTerminate() {
		assertEquals(moving, throwingDice.terminate());
	}

	/**
	 * Test method for {@link mindrace.model.states.ThrowingDice#isModifier()}.
	 */
	@Test
	public void testIsModifier() {
		assertFalse(throwingDice.isModifier());
	}

	/**
	 * Test method for {@link mindrace.model.states.ThrowingDice#throwDice()}.
	 */
	@Test
	public void testThrowDice() {
		assertTrue((diceNumber>=MINIMALNUMBER) && (diceNumber<=MAXIMALNUMBER));
	}

}
