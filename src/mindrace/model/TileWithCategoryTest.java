package mindrace.model;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author User
 *
 */
public class TileWithCategoryTest {
	Tile notSpecialTile;
	Tile specialTile;
	Board board;
	
	@Before
	public void testSetUp()throws Exception{
		board = new Board();
		notSpecialTile = board.getTileAt(1); // its a Sport tile
		specialTile = board.getTileAt(20); // its a special tile from Science Category
	}
	/**
	 * Test method for {@link mindrace.model.TileWithCategory#isSpecial()}.
	 */
	@Test
	public void testIsSpecial() {
		assertTrue(specialTile.isSpecial());
		assertFalse(notSpecialTile.isSpecial());
	}

	/**
	 * Test method for {@link mindrace.model.TileWithCategory#getCategory()}.
	 */
	@Test
	public void testGetCategory() {
		assertEquals(Category.Sport, ((TileWithCategory)notSpecialTile).getCategory());
		assertEquals(Category.Science, ((TileWithCategory)specialTile).getCategory());
	}

}
