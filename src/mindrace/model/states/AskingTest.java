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
 * @author Giuliano, Daniella
 *
 */
public class AskingTest {

	
	Situation situation;
	Board board;
	List<Player> players;
	Asking asking;
	
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		board = new Board();
		players = new LinkedList<>();
		players.add(new Player("Juan", board));
		asking = new Asking();
		situation = new Situation(players, board);
		asking.setCurrentSituation(situation);
	}

	/**
	 * Test method for {@link mindrace.model.states.Asking#terminate()}.
	 */
	@Test
	public void testTerminate() {
		situation.getCurrentPlayer().setTile(board.getTileAt(8));
		board.getTileAt(8).addPlayer(situation.getCurrentPlayer());
		asking.setPreviousState(new Moving());
		asking.initialize();
		//Can´t test slow answering due to the fact that time is measured by model
		//(An alternative would be to sleep thread for 15secs to test that)
		asking.setAnswer(asking.getQuestion().getCorrectAnswer());
		assertEquals(new WinningToken(), asking.terminate());
		asking.setAnswer(asking.getQuestion().getCorrectAnswer()+1);
		assertEquals(new NewTurn(), asking.terminate()); 
	}

	/**
	 * Test method for {@link mindrace.model.states.Asking#isModifier()}.
	 */
	@Test
	public void testIsModifier() {
		assertFalse(asking.isModifier());
	}

}
