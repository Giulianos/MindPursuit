package mindrace.model.states;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import mindrace.model.Board;
import mindrace.model.Category;
import mindrace.model.Player;
import mindrace.model.Situation;

/**
 * @author Giuliano, Daniella
 *
 */
public class StealingTokenTest {
	Player juancito;
	Player playerToSteal;
	Category categoryToSteal;
	List<Player> players;
	Board board;
	Asking asking;
	Moving moving;
	Situation situation;
	StealingToken stealingToken;
	
	@Before
	public void testSetUp()throws Exception{
		stealingToken = new StealingToken();
		asking = new Asking();
		stealingToken.setPreviousState(asking);
		moving = new Moving();
		board = new Board();
		categoryToSteal = Category.Entertainment;
		juancito = new Player("Juancito", board);
		playerToSteal = new Player("Pedro", board);
		juancito.addToken(Category.Art);
		playerToSteal.addToken(Category.Entertainment);
		juancito.setTile(board.getTileAt(4));
		playerToSteal.setTile(board.getTileAt(4));
		players = new LinkedList();
		players.add(juancito);
		players.add(playerToSteal);
		board.getTileAt(4).addPlayer(players.get(0));
		board.getTileAt(4).addPlayer(players.get(1));
		situation = new Situation(players,board);
		stealingToken.setCurrentSituation(situation);
		stealingToken.setTokenToSteal(playerToSteal, categoryToSteal);
	}
	
	/**
	 * Test method for {@link mindrace.model.states.StealingToken#terminate()}.
	 */
	@Test
	public void testTerminate() {
		assertEquals(moving, stealingToken.terminate());
	}

	/**
	 * Test method for {@link mindrace.model.states.StealingToken#isModifier()}.
	 */
	@Test
	public void testIsModifier() {
		assertTrue(stealingToken.isModifier());
	}

	/**
	 * Test method for {@link mindrace.model.states.StealingToken#getPlayersToSteal()}.
	 */
	@Test
	public void testGetPlayersToSteal() {
		Set<Player> aux = new HashSet<>();
		aux.add(playerToSteal);
		assertEquals(aux, stealingToken.getPlayersToSteal());
	}

}
