package home.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

import home.algorithms.StringExercises;

public class StringExerciseTest {

	@Test
	public void testHasUniqueCharacters() {
		String s1 = "ahjkrwoy";
		String s2 = "alioüqa";
		String s3 = "a";

		assertTrue(StringExercises.hasUniqueCharacters(s1));
		assertFalse(StringExercises.hasUniqueCharacters(s2));
		assertTrue(StringExercises.hasUniqueCharacters(s3));

	}

	@Test
	public void testReverse() {
		char[] ch = { 'H', 'e', 'l', 'l', 'o' };
		assertEquals(new String("olleH"), new String(StringExercises.reverse(ch)));
		char[] ch2 = { 'H', 'e', 'l', 'o' };
		assertEquals(new String("oleH"), new String(StringExercises.reverse(ch2)));

	}

	@Test
	public void testIsPermutation() {
		String str1 = "abcde";
		String str2 = "cbaed";
		assertTrue(StringExercises.isPermutation(str1, str2));
		str2 = "cbaex";
		assertFalse(StringExercises.isPermutation(str1, str2));
	}

	@Test
	public void reverseAndCapitalizeFirstLetter() {
		String str = "my country is india";
		String res = StringExercises.reverseAndCapitalizeFirstLetter(str);
		System.out.println("result:" + res);
	}

	@Test
	public void findMinFromRotatedArr() {
	}

	@Test
	public void testIsRotation() {
		String str1 = "waterwo";
		String str2 = "wowater";
		assertTrue(StringExercises.isRotation(str1, str2));
		
		str1 = "water";
		str2 = "erwar";
		assertFalse(StringExercises.isRotation(str1, str2));
		
		str1 = "waterbottle";
		str2 = "erbottlewat";
		assertTrue(StringExercises.isRotation(str1, str2));
	}
	
	@Test
	public void testStringExistInText() {
		assertTrue(StringExercises.stringExistInText("maktabga", "menmaktabgaboraman"));
		assertTrue(StringExercises.stringExistInText("Bob boy", "hehasletyoudownBob boy."));
	}
	
	@Test
	public void testLongestPalindrome() {
		String res = StringExercises.longestPalindromes("banana");
		assertEquals("anana", res);
		res = StringExercises.longestPalindromes("baraka");
		assertEquals("aka", res);
		res = StringExercises.longestPalindromes("aka");
		assertEquals("aka", res);
		res = StringExercises.longestPalindromes("madamimadam");
		assertEquals("madamimadam", res);
	}
	
	@Test
	public void testReverseWithRecursion() {
		String rStr = StringExercises.reverseWithRecursion("Hello");
		assertEquals("olleH", rStr);
		
		rStr = StringExercises.reverseWithRecursion("Test");
		assertEquals("tseT", rStr);
		
		rStr = StringExercises.reverseWithRecursion("Test all the tests.");
		assertEquals(".stset eht lla tseT", rStr);
	}

}
