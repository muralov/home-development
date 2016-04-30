package home.information_retrieval;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordEditDistanceTest {

	@Test
	public void testCalculate() {
		String word1 = "intention";
		String word2 = "execution";
		WordEditDistance wed = new WordEditDistance(word1, word2);
		int distance = wed.calculate();
		assertEquals(8, distance);
		
		word1 = "ABC";
		word2 = "ABD";
		wed = new WordEditDistance(word1, word2);
		assertEquals(2, wed.calculate());
		
		word1 = "ABC";
		word2 = "ABC";
		wed = new WordEditDistance(word1, word2);
		assertEquals(0, wed.calculate());
		
	}
	
	@Test
	public void testMin() {
		int a = 10, b = 11, c = 15;
		assertEquals(a, WordEditDistance.min(a, b, c));
		a = 11; b = 10; c = 15;
		assertEquals(b, WordEditDistance.min(a, b, c));
		a = 15; b = 11; c = 10;
		assertEquals(c, WordEditDistance.min(a, b, c));
		a = 10; b = 15; c = 11;
		assertEquals(a, WordEditDistance.min(a, b, c));
		a = 15; b = 10; c = 11;
		assertEquals(b, WordEditDistance.min(a, b, c));
	}

}
