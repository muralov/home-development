package home.search.binarysearch;
import static org.junit.Assert.*;
import home.search.binarysearch.BST;

import org.junit.Test;

public class BSTTest {

	@Test
	public void getTest() {
		BST<Integer, String> bst = new BST<Integer, String>();
		bst.put(2, "E");
		bst.put(5, "C");
		bst.put(7, "E");
		bst.put(3, "A");
		bst.put(4, "R");
		bst.put(1, "S");
		bst.put(6, "H");
		
		assertEquals("R", bst.get(4));
		assertEquals("S", bst.get(1));
		assertEquals("A", bst.get(3));
	}
	
	@Test
	public void putTest() {
		BST<Integer, String> bst = new BST<Integer, String>();
		bst.put(2, "E");
		bst.put(5, "C");
		bst.put(7, "E");
		bst.put(3, "A");
		bst.put(4, "R");
		bst.put(1, "S");
		bst.put(6, "H");
		
		long t1 = System.currentTimeMillis();
		assertEquals("R", bst.get(4));
		long t2 = System.currentTimeMillis();
		System.out.println((1000000000)*(t2-t1));
		
		assertEquals("S", bst.get(1));
		assertEquals("A", bst.get(3));
		assertEquals(null, bst.get(8));
		assertEquals(null, bst.get(11));
		assertNotEquals("C", bst.get(4));
		assertNotEquals("F", 3);
	}
	
}
