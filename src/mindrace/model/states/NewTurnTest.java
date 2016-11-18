package mindrace.model.states;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mindrace.model.Board;
import mindrace.model.Player;
import mindrace.model.Situation;

/**
 * @author Daniella, Giuliano
 *
 */
public class NewTurnTest {
	List<Player> players;
	Board board;
	Player player;
	Asking asking;
	ThrowingDice throwingDice;
	Situation situation;
	NewTurn newTurn;
	
	@Before
	public void testSetUp()throws Exception{
		players = new LinkedList();
		player = new Player("Juancito", board);
		players.add(player);
		board = new Board();
		asking = new Asking();
		throwingDice = new ThrowingDice();
		newTurn = new NewTurn();
		newTurn.setPreviousState(asking);
		situation = new Situation(players,board);
		newTurn.setCurrentSituation(situation);
		players.get(0).setTile(board.getTileAt(4));
		board.getTileAt(4).addPlayer(players.get(0));
	
	}
	
	/**
	 * Test method for {@link mindrace.model.states.NewTurn#terminate()}.
	 */
	@Test
	public void testTerminate() {
		assertEquals(throwingDice, newTurn.terminate());	
	}

	/**
	 * Test method for {@link mindrace.model.states.NewTurn#isModifier()}.
	 */
	@Test
	public void testIsModifier() {
		assertTrue(newTurn.isModifier());
	}

}
