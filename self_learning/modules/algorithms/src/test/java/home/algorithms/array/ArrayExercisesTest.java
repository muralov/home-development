package home.algorithms.array;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import home.algorithms.array.ArrayExercises;

public class ArrayExercisesTest {

	@Test
	public void findMissingNumber() {
		int arr[] = { 1, 5, 3, 4, 1, 2, 5, 7 };
		ArrayExercises.findMissingNumber(arr, 8);
	}

	@Test
	public void findUniqueCharachters() {
		String str = "finduni";
		ArrayExercises.findUniqueCharacters(str);
	}

	@Test
	public void testSetRowColumnsToZero() {
		int[][] arr = { { 1, 2, 3, 4 }, { 6, 0, 7, 1 }, { 2, 1, 0, 5 }, { 4, 8, 1, 2 } };
		printMatrix(arr);
		arr = ArrayExercises.setRowColumnsToZero(arr);
		System.out.println();
		printMatrix(arr);
		System.out.println();
	}

	private void printMatrix(int[][] arr) {
		int height = arr.length;
		int width = arr[0].length;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	@Test
	public void testMoveZerosToEnd() {
		int[] arr = {1, 2, 0, 5, 4, 88, 0, 0, 0, 6};
		int[] exparr = {1, 2, 5, 4, 88, 6, 0, 0, 0, 0};
		ArrayExercises.moveZerosToEnd(arr);		
		assertArrayEquals(exparr, arr);
		
		int[] arr2 = {0, 0, 2, 0, 4,6,7,8};
		int[] exparr2 = {2, 4, 6, 7, 8,0,0,0};
		ArrayExercises.moveZerosToEnd(arr2);
		assertArrayEquals(exparr2, arr2);
	}
	
	@Test
	public void testPermutation() {
		int arr[] = {1,2,3};
		ArrayExercises.permutation(arr, 0, 2);
	}
	
	@Test
	public void testMergeArrays() {
		int a1[] = {1,3,4,7,8};
		int a2[] = {3,6,9,10};
		int actual[] = ArrayExercises.mergeArrays(a1, a2);
		int expected[] = {1,3,3,4,6,7,8,9,10};
		assertEquals(a1.length+a2.length, actual.length);
		assertArrayEquals(expected, actual);
		
		int a3[] = {5,9,11};
		int a4[] = {22};
		int expected2[] = {5,9,11,22};
		actual = ArrayExercises.mergeArrays(a3, a4);
		assertArrayEquals(expected2, actual);
	}
	
	@Test
	public void testPeakElements() {
		int[] arr = {40,10,20,5,45,50,65,90,35,25};
		Integer[] expected = {40,20,90};
		
		List<Integer> actual = ArrayExercises.peakElements(arr);
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testPeakElement() {
		int[] arr = {40,10,20,5,45,50,65,90,35,25};
		int actual = ArrayExercises.peakElement(arr, 0, 9);
		
		assertEquals(90, actual);
		
		int[] arr2 = {40,35,20,15};
		int actual2 = ArrayExercises.peakElement(arr2, 0, 3);
		assertEquals(40, actual2);
	}
	
	@Test
	public void twoSum() {
		int arr[] = {1, 0, -3, 2, 3};
		int[] exp = {2, 4};
		int[] act = ArrayExercises.twoSum(arr, 0);
		assertArrayEquals(exp, act);
		
		int arr2[] = {2, 7, 11, 15};
		int[] exp2 = {0, 1};
		int[] act2 = ArrayExercises.twoSum(arr2, 9);
		assertArrayEquals(exp2, act2);
	}

}
