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
public class ChoosingCategoryTest {
		ChoosingCategory choosingCategory;
		List<Player> players;
		Board board;
		Player player;
		Asking asking;
		Moving moving;
		Situation situation;
			
		/**
		 * Test method for {@link mindrace.model.states.WinningToken#initialize()}.
		 */
		@Before
		public void testSetUp()throws Exception{
			board = new Board();
			choosingCategory = new ChoosingCategory();
			players = new LinkedList();
			player = new Player("Juancito", board);
			players.add(player);
			asking = new Asking();
			moving = new Moving();
			situation = new Situation(players,board);
			choosingCategory.setCurrentSituation(situation);
			players.get(0).setTile(board.getTileAt(4));
			board.getTileAt(4).addPlayer(players.get(0));
			choosingCategory.setPreviousState(moving);
		}
	
	/**
	 * Test method for {@link mindrace.model.states.ChoosingCategory#terminate()}.
	 */
	@Test
	public void testTerminate() {
		assertEquals(asking, choosingCategory.terminate());
	}

	/**
	 * Test method for {@link mindrace.model.states.ChoosingCategory#isModifier()}.
	 */
	@Test
	public void testIsModifier() {
		assertFalse(choosingCategory.isModifier());
	}
}

