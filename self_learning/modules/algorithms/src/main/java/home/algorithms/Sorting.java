package home.algorithms;

public class Sorting {

	public static int[] mergeSort(int[] numbers) {

		if (numbers.length > 2) {
			int middle = numbers.length / 2;

			// divide the array into two sub-arrays
			int[] subArr1 = new int[middle];
			int[] subArr2 = new int[numbers.length - middle];
			for (int i = 0; i < numbers.length; i++) {
				if (i < middle) {
					subArr1[i] = numbers[i];
				} else {
					subArr2[i - middle] = numbers[i];
				}
			}
			subArr1 = mergeSort(subArr1);
			subArr2 = mergeSort(subArr2);

			return merge(subArr1, subArr2);
		} else {
			if(numbers.length > 1) { //if 2 elements
				if(numbers[0] > numbers[1]) {
					int tmp = numbers[0];
					numbers[0] = numbers[1];
					numbers[1] = tmp;
				}
			}
			return numbers;
		}
	}

	public static int[] merge(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];
		int le1 = arr1.length;
		int le2 = arr2.length;
		int i = 0;
		int j = 0;
		int counter = 0;
		while (le1 != 0 || le2 != 0) {
			if (le2 != 0 && le1 == 0) {
				result[counter] = arr2[j];
				le2--;
				j++;
			} else if (le1 != 0 && le2 == 0) {
				result[counter] = arr1[i];
				le1--;
				i++;
			} else {
				if (arr1[i] <= arr2[j]) {
					result[counter] = arr1[i];
					i++;
					le1--;
				} else {
					result[counter] = arr2[j];
					j++;
					le2--;
				}
			}
			counter++;
		}

		return result;
	}

}
