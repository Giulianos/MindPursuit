package mindrace.model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Daniella, Giuliano
 *
 */
public class TileTest {
	Tile tileStart;
	Tile tileStealable;
	Player juancito;
	Player pedro;
	Player jorge;
	Board board;
	List<Player> players;
	
	@Before
	public void testSetUp()throws Exception{
		juancito = new Player("juancito", board);
		pedro = new Player("pedro", board);
		jorge = new Player("jorge", board);
		board = new Board();
		tileStart = board.getTileAt(0);
		tileStealable = board.getTileAt(4);
		players = new LinkedList();
		players.add(juancito);
		players.add(pedro);
		players.add(jorge);
		pedro.addToken(Category.Art);
		jorge.addToken(Category.Art);
		board.getTileAt(4).addPlayer(players.get(0));
		board.getTileAt(4).addPlayer(players.get(1));
		board.getTileAt(4).addPlayer(players.get(2));
	}
	
	/**
	 * Test method for {@link mindrace.model.Tile#isStart()}.
	 */
	@Test
	public void testIsStart() {
		assertTrue(tileStart.isStart());
		assertFalse(tileStealable.isStart());
	}

	/**
	 * Test method for {@link mindrace.model.Tile#isSpecial()}.
	 */
	@Test
	public void testIsSpecial() {
		assertFalse(tileStart.isSpecial());
	}

	/**
	 * Test method for {@link mindrace.model.Tile#stealablePlayers(mindrace.model.Player)}.
	 */
	@Test
	public void testStealablePlayers() {
		Set<Player> shouldReturn = new HashSet<>();
		shouldReturn.add(jorge);
		shouldReturn.add(pedro);
		assertEquals(shouldReturn, tileStealable.stealablePlayers(juancito));

	}

}
