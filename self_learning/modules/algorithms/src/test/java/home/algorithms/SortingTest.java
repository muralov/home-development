package home.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortingTest {
	
	@Test
	public void testSort() {
		int[] numbers = new int[]{41,5,3,5,2,8,40,1};
		int[] expected = new int[]{1,2,3,5,5,8,40,41};
		int[] actual = Sorting.mergeSort(numbers);
		
		assertEquals(expected.length, actual.length);
		for(int i=0;i<expected.length;i++) {
			assertEquals(expected[i], actual[i]);
		}
		
		numbers = new int[]{5,4,11,7,33,42,40};
		expected = new int[]{4,5,7,11,33,40,42};
		actual = Sorting.mergeSort(numbers);
		
		assertEquals(expected.length, actual.length);
		for(int i=0;i<expected.length;i++) {
			assertEquals(expected[i], actual[i]);
		}
	}
	
	@Test
	public void testMerge() {
		
		int[] arr1 = new int[]{2,5,8,40};
		int[] arr2 = new int[]{1,3,5,41};
		int[] expected = new int[]{1,2,3,5,5,8,40,41};
		
		int[] actual = Sorting.merge(arr1, arr2);
		assertEquals(expected.length, actual.length);
		for(int i=0;i<expected.length;i++) {
			assertEquals(expected[i], actual[i]);
		}
		
		arr1 = new int[]{1,3};
		arr2 = new int[]{2};
		expected = new int[]{1,2,3};
		actual = Sorting.merge(arr1, arr2);
		assertEquals(expected.length, actual.length);
		for(int i=0;i<expected.length;i++) {
			assertEquals(expected[i], actual[i]);
		}
		
		arr1 = new int[]{1};
		arr2 = new int[]{3};
		expected = new int[]{1, 3};
		actual = Sorting.merge(arr1, arr2);
		assertEquals(expected.length, actual.length);
		for(int i=0;i<expected.length;i++) {
			assertEquals(expected[i], actual[i]);
		}
		
		arr1 = new int[]{1,7};
		arr2 = new int[]{2, 4, 9};
		expected = new int[]{1,2,4,7,9};
		actual = Sorting.merge(arr1, arr2);
		assertEquals(expected.length, actual.length);
		for(int i=0;i<expected.length;i++) {
			assertEquals(expected[i], actual[i]);
		}
		
		arr1 = new int[]{7,33};
		arr2 = new int[]{40, 42};
		expected = new int[]{7,33,40,42};
		actual = Sorting.merge(arr1, arr2);
		assertEquals(expected.length, actual.length);
		for(int i=0;i<expected.length;i++) {
			assertEquals(expected[i], actual[i]);
		}
	}

}
