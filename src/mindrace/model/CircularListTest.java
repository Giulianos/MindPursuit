package mindrace.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Daniella, Giuliano
 *
 */
public class CircularListTest {

	private CircularList<Integer> circularList;
	
	
	/**
	 * Test method for {@link mindrace.model.CircularList#CircularList()}.
	 */
	@Before
	public void testCircularList() {
		circularList = new CircularList<Integer>();
	}
	
	/**
	 * Test method for {@link mindrace.model.CircularList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddT() {
		circularList.add(3);
		assertEquals(new Integer(3), circularList.get(0));
	}

	/**
	 * Test method for {@link mindrace.model.CircularList#get(int)}.
	 */
	@Test
	public void testGetInt() {
		circularList.add(4);
		circularList.add(4);
		circularList.add(4);
		circularList.add(7);
		assertEquals(new Integer(7), circularList.get(3));
	}

	/**
	 * Test method for {@link mindrace.model.CircularList#size()}.
	 */
	@Test
	public void testSize() {
		circularList.add(4);
		assertEquals(1, circularList.size());
	}

	/**
	 * Test method for {@link mindrace.model.CircularList#getNext(java.lang.Object)}.
	 */
	@Test
	public void testGetNext() {
		circularList.add(4);
		circularList.add(7);
		assertEquals(new Integer(7), circularList.getNext(4));
	}

	/**
	 * Test method for {@link mindrace.model.CircularList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(circularList.isEmpty());
		circularList.add(1);
		assertFalse(circularList.isEmpty());
	}

	/**
	 * Test method for {@link mindrace.model.CircularList#add(java.lang.Object, java.lang.Integer)}.
	 */
	@Test
	public void testAddTInteger() {
		circularList.add(4);
		circularList.add(3, 0);
		assertEquals(new Integer(3), circularList.get(0));
	}

	/**
	 * Test method for {@link mindrace.model.CircularList#get(java.lang.Object)}.
	 */
	@Test
	public void testGetT() {
		circularList.add(4);
		assertEquals(new Integer(4), circularList.get(0));
	}

}
