package home.algorithms.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayExercises {

	public static int findMissingNumber(int[] arr, int n) {
		// int arr[] = {1, 5, 3, 4, 1, 2}; n = 6, where 1 is repeating twice and
		// 6 is missing.

		int[] hash = new int[n];

		for (int i = 0; i < arr.length; i++) {
			hash[arr[i] - 1]++;
			if (hash[arr[i] - 1] > 1) {
				System.out.println(arr[i] + " repeated");
			}
		}

		for (int i = 0; i < n; i++) {
			if (hash[i] == 0)
				System.out.println(i + 1 + " missing");
		}

		return -1;
	}

	public static void findUniqueCharacters(String str) {
		// int arr[] = {1, 5, 3, 4, 1, 2}; n = 6, where 1 is repeating twice and
		// 6 is missing.
		char[] chs = str.toCharArray();
		int[] hash = new int[256];

		for (int i = 0; i < chs.length; i++) {
			hash[(int) chs[i]]++;
		}

		for (char ch : chs) {
			if (hash[(int) ch] == 1)
				System.out.println(ch + ", ");
		}
	}

	public static int[][] setRowColumnsToZero(int[][] m) {
		int height = m.length;
		int width = m[0].length;
		boolean flag[][] = new boolean[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (m[i][j] == 0 && !flag[i][j]) {
					// set rows and cols to zero
					for (int k = 0; k < height; k++) {
						if (m[k][j] != 0)
							flag[k][j] = true;
						m[k][j] = 0;
					}
					for (int k = 0; k < width; k++) {
						if (m[i][k] != 0)
							flag[i][k] = true;
						m[i][k] = 0;
					}
				}
			}
		}
		return m;
	}

	public static void removeDuplicates(int[] arr) {
		// 1. use hash to solve this
		// 2. use set
		// 2. sort and remove duplicates
	}

	public static void moveZerosToEnd(int[] arr) {
		// Given an array, 1 2 0 5 4 88 0 0 0 6. make it, 1 2 5 4 88 6 0 0 0 0
		// 0 0 2 0 4 6 7 8 make 2 4 6 7 8 0 0 0

		int movInx = 0;
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			if (val == 0) {
				int j = i + 1;
				movInx = i;
				while (j < arr.length) {
					if (arr[j] != 0) {
						swap(arr, movInx, j);
						movInx++; // move the 0 shift index iff the next element
									// is not zero
					}
					j++;
					i++;
					if (j == arr.length)
						return;
				}
			}
		}
	}

	private static void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static int[] mergeArrays(int[] arr1, int[] arr2) {
		int size = arr1.length + arr2.length;
		int arr[] = new int[size];
		int i = arr1.length-1, j = arr2.length-1, k = size-1;
		while (i >= 0 && j >= 0) {
			if (arr1[i] <= arr2[j]) {
				arr[k] = arr2[j];
				j--;
			} else if (arr1[i] > arr2[j]) {
				arr[k] = arr1[i];
				i--;
			}
			k--;
		}
		while(i>=0) {
			arr[i] = arr1[i];
			i--;
		}
		while(j>=0) {
			arr[j] = arr2[j];
			j--;
		}

		return arr;
	}
	
	public static List<Integer> peakElements(int arr[]) {
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < arr.length - 1; i++) {
			if (i == 0) {
				if (arr[i] > arr[i + 1])
					res.add(arr[i]);
			} else if (i == arr.length - 1) {
				if (arr[i] > arr[i - 1])
					res.add(arr[i]);
			} else {
				if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
					res.add(arr[i]);
			}
		}

		return res;
	}

	public static int peakElement(int arr[], int lo, int hi) {
		int mid = (lo + hi) / 2;
		
		
		if (mid == 0) {
			if (arr[mid] > arr[mid + 1])
				return arr[mid];
		} else if (mid == arr.length - 1) {
			if (arr[mid] > arr[mid - 1])
				return arr[mid];
		} else {
			if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
				return arr[mid];
		}
		
		if (arr[mid] < arr[mid + 1]) {
			return peakElement(arr, mid+1, hi);
		} else {
			return peakElement(arr, lo, mid-1);
		}
	}
	
	//TODO: the following methods need to be implemented

	// a+b = ab, ba
	// ab+c = cab, acb, abc
	// ba+c = cba, bca, bac
	// 1+2 = 12, 21 (swap 1,1; swap 1,2)
	// 12+3 = 312, 132, 123 (swap 1,3; swap 2,3; swap 3,3)
	// 21+3 = 321, 231, 213 (swap )
	static List<String> result = new ArrayList<>();

	public static void permute(int[] arr, int start, int n) {
		if (start == n) {
			for (int a : arr) {
				System.out.print(a);
			}
			System.out.println();
		}
		for (int i = start; i < n; i++) {
			swap(arr, start, i);
			permute(arr, i + 1, n);
			swap(arr, start, i);
		}
	}
	
	public static int[] twoSum(int[] arr, int sum) {
		int res[] = new int[2];
		Map<Integer, Integer> hash = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			if(hash.containsKey(arr[i])) {
				res[0] = hash.get(arr[i]);
				res[1] = i;
				return res;
			} else {
				hash.put(sum - arr[i], i);
			}
		}
		
		return null;
	}

	// start with 1, 123, 213, 321 (swap 1,1; swap 1,2; swap 1,3)
	// start with 2, 213, 231, 132 (swap 2,1; swap 2,2; swap 2,3)
	// start with 3, 312, 132, 123 (swap 3,1; swap 3,2; swap 3,3)
	public static List<String> permutation(int[] arr, int lo, int hi) {
		if (lo == hi) {
			for (int i = 0; i <= hi; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}

		for (int i = lo; i <= hi; i++) { //0, 1, 2
			swap(arr, lo, i);   //0,0; 0,1; 0,2
			permutation(arr, i+1, hi);  //1,2; 2,2
			swap(arr, lo, i);
		}
		return result;
	}
	
}
