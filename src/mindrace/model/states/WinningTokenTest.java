package mindrace.model.states;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mindrace.model.Board;
import mindrace.model.Category;
import mindrace.model.CircularList;
import mindrace.model.Player;
import mindrace.model.Situation;

/**
 * @author User
 *
 */
public class WinningTokenTest {
	ChoosingCategory choosingCategory;
	List<Player> players;
	Board board;
	Player player;
	Asking asking;
	Moving moving;
	Situation situation;
	WinningToken winningToken;
	
	/**
	 * Test method for {@link mindrace.model.states.WinningToken#initialize()}.
	 */
	@Before
	public void testSetUp()throws Exception{
		choosingCategory = new ChoosingCategory();
		players = new LinkedList();
		player = new Player("Juancito", board);
		players.add(player);
		board = new Board();
		asking = new Asking();
		moving = new Moving();
		situation = new Situation(players,board);
		winningToken = new WinningToken();
		winningToken.setCurrentSituation(situation);
		players.get(0).setTile(board.getTileAt(4));
		board.getTileAt(4).addPlayer(players.get(0));
	}

	/**
	 * Test method for {@link mindrace.model.states.WinningToken#terminate()}.
	 */
	@Test
	public void testTerminate() {
		winningToken.setPreviousState(asking);
		winningToken.setChosenCategory(Category.Art);
		assertEquals(moving, winningToken.terminate());
		winningToken.setPreviousState(moving);
		situation.getCurrentPlayer().setTile(board.getTileAt(17));
		assertEquals(choosingCategory, winningToken.terminate());
		situation.getCurrentPlayer().setTile(board.getTileAt(4)); // 4 es un tile con categoria
		assertEquals(asking, winningToken.terminate());
	}

	/**
	 * Test method for {@link mindrace.model.states.WinningToken#isModifier()}.
	 */
	@Test
	public void testIsModifier() {
		assertTrue(winningToken.isModifier());
	}

	/**
	 * Test method for {@link mindrace.model.states.WinningToken#getPossibleTokens()}.
	 */
	@Test
	public void testGetPossibleTokens() {
		Set<Category> possibleTokens = new HashSet<>(); 
		for(Category c: Category.values()){
			possibleTokens.add(c);
		}
		winningToken.setPreviousState(moving);
		winningToken.initialize();
		assertEquals(possibleTokens, winningToken.getPossibleTokens());
	}

	/**
	 * Test method for {@link mindrace.model.states.WinningToken#shouldAsk()}.
	 */
	@Test
	public void testShouldAsk() {
		winningToken.setPreviousState(asking);
		assertFalse(winningToken.shouldAsk());
		winningToken.setPreviousState(moving);
		winningToken.initialize();
		assertTrue(winningToken.shouldAsk());
	}

}
