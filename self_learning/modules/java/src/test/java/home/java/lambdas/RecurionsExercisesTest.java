package home.java.lambdas;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecurionsExercisesTest {

	@Test
	public void sumsq() {
		assertEquals(0, RecurionsExercises.sumsq(0));
		assertEquals(1, RecurionsExercises.sumsq(1));
		
		assertNotSame(4, RecurionsExercises.sumsq(2));
		assertEquals(14, RecurionsExercises.sumsq(3));
		assertEquals(91, RecurionsExercises.sumsq(6));
	}
	
	@Test
	public void factorial() {
		assertEquals(1, RecurionsExercises.factorial(0));
		assertEquals(1, RecurionsExercises.factorial(1));
		
		assertEquals(6, RecurionsExercises.factorial(3));
		assertEquals(24, RecurionsExercises.factorial(4));
		assertEquals(120, RecurionsExercises.factorial(5));
	}
	
	@Test
	public void fibonacci() {
		assertEquals(1, RecurionsExercises.fibonacci(0));
		assertEquals(1, RecurionsExercises.fibonacci(1));
		
		assertEquals(3, RecurionsExercises.fibonacci(3));
		assertEquals(5, RecurionsExercises.fibonacci(4));
		assertNotSame(9, RecurionsExercises.fibonacci(5));
	}
	
	@Test
	public void nextFactor() {
		assertEquals(9, RecurionsExercises.nextFactor(4, 27));
		
		assertEquals(4, RecurionsExercises.nextFactor(2, 28));
		
		assertNotSame(9, RecurionsExercises.nextFactor(4, 51));
	}
	
}
