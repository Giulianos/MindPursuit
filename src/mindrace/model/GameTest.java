package mindrace.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sun.corba.se.spi.orbutil.fsm.State;

import mindrace.model.states.ThrowingDice;

/**
 * @author Daniella, Giuliano
 *
 */
public class GameTest {
	Game game;
	Board board;
	List<String> players;
	@Before
	public void testSetUp()throws Exception{
		players = new LinkedList<String>();
		players.add("juancito");
		players.add("pedro");
		game = new Game(players,new ThrowingDice());
		board = new Board();
	}

	/**
	 * Test method for {@link mindrace.model.Game#getSituation()}.
	 */
	@Test
	public void testGetSituation() {
		assertEquals(Situation.class, game.getSituation().getClass());
	}

	/**
	 * Test method for {@link mindrace.model.Game#getPlayer(java.lang.String)}.
	 */
	@Test
	public void testGetPlayer() {
		assertEquals(new Player("juancito", board), game.getPlayer("juancito"));
	}

	/**
	 * Test method for {@link mindrace.model.Game#iniciatePlayers(java.util.List, mindrace.model.Board)}.
	 */
	@Test
	public void testIniciatePlayers() {
		List<Player> itShouldReturn = new LinkedList();
		itShouldReturn.add(new Player("juancito", board));
		itShouldReturn.add(new Player("pedro", board));
		assertEquals(itShouldReturn, game.iniciatePlayers(players, board));
	}

}
