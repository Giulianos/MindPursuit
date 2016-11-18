package mindrace.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author User
 *
 */
public class BoardTest {
	Board board;
	@Before
	public void testSetUp()throws Exception{
		board = new Board();
	}
	
	/**
	 * Test method for {@link mindrace.model.Board#getNext(mindrace.model.Tile)}.
	 */
	@Test
	public void testGetNext() {
		assertEquals(board.getTileAt(4), board.getNext(board.getTileAt(3)));
		assertEquals(board.getTileAt(0), board.getNext(board.getTileAt(41)));
	}



	/**
	 * Test method for {@link mindrace.model.Board#startingTile()}.
	 */
	@Test
	public void testStartingTile() {
		assertEquals(board.getTileAt(0), board.startingTile());
	}

}
