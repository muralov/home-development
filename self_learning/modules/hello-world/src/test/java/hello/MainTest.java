package hello;

import static org.junit.Assert.*;

import org.junit.Test;

import hello.Main;

public class MainTest {
	
	@Test
	public void testIsPalindrome() {
		assertTrue(Main.isPalindrome("arra"));
		assertTrue(Main.isPalindrome("aka"));
		assertTrue(Main.isPalindrome("a"));
		assertTrue(Main.isPalindrome("barab"));
		
		assertTrue(Main.isPalindrome("madamimadam"));
		
		assertFalse(Main.isPalindrome("arr"));
		assertFalse(Main.isPalindrome("arrab"));
		assertFalse(Main.isPalindrome("ar"));
	}

}
