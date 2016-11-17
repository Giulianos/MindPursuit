package mindrace.model.states;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

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
	public class MovingTest {
		private Player player; //este seria el jugador que va a mover
		private Category currentCategory;
		private static final Integer fastMovement = 5;
		private static final Integer slowMovement = 1;

		WinningToken winningToken;
		StealingToken stealingToken;
		Asking asking;
		ThrowingDice throwingDice;
		ChoosingCategory choosingCategory;
		Moving moving;
		List<Player> players;
		Board board;
		Situation situation;
	
	@Before
	public void testSetUp()throws Exception{
		players = new LinkedList();
		board = new Board();
		player = new Player("Juancito", board);
		players.add(player);
		situation = new Situation(players,board);
		players.get(0).setTile(board.getTileAt(41));
		board.getTileAt(41).addPlayer(players.get(0));
		asking = new Asking();
		moving = new Moving();
		choosingCategory = new ChoosingCategory();
		stealingToken = new StealingToken();
		winningToken = new WinningToken();
		throwingDice = new ThrowingDice();
		moving.setCurrentSituation(situation);
	}
	

	/**
	 * Test method for {@link mindrace.model.states.Moving#terminate()}.
	 */
	@Test
	public void testTerminate() {
		moving.setPreviousState(winningToken);
		situation.getCurrentPlayer().setTile(board.getTileAt(41));
		moving.initialize();
		assertEquals(winningToken, moving.terminate());
		situation.getCurrentPlayer().setTile(board.getTileAt(17));
		player.getTile().addPlayer(player);
		board.getTileAt(41).removePlayer(player);
		assertEquals(asking, moving.terminate());
	}

	/**
	 * Test method for {@link mindrace.model.states.Moving#isModifier()}.
	 */
	@Test
	public void testIsModifier() {
		assertTrue(moving.isModifier());	
	}
}

