package home.algorithms;

import java.util.Arrays;

public class StringExercises {

	public static boolean hasUniqueCharacters(String str) {

		if (str.length() > 256)
			return false;

		boolean found[] = new boolean[256];
		for (int j = 0; j < str.length(); j++) {
			int ch = str.charAt(j);
			if (found[ch])
				return false;
			found[ch] = true;
		}

		return true;
	}

	public static char[] reverse(char[] str) {
		int middle = (int) Math.ceil(str.length / 2.0);
		for (int i = 0; i < middle; i++) {
			char tmp = str[i];
			str[i] = str[str.length - i - 1];
			str[str.length - i - 1] = tmp;
		}
		return str;
	}

	public static boolean isPermutation(String str1, String str2) {
		// str1 = abcd, cdba - true
		if (str1.length() != str2.length())
			return false;
		char[] ch1 = str1.toCharArray();
		Arrays.sort(ch1);
		char[] ch2 = str2.toCharArray();
		Arrays.sort(ch2);
		return new String(ch1).equals(new String(ch2));
	}

	public static String reverseAndCapitalizeFirstLetter(String str) {
		// String[] words = str.split("\\s+");
		char[] chs = str.toCharArray();
		int lo = 0; // lower bound
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == ' ') {
				reverseAndCapitalizeWord(chs, lo, i - 1);
				lo = i + 1;
				System.out.println(new String(chs));
			}
			if (i == chs.length - 1) {
				reverseAndCapitalizeWord(chs, lo, i);
				lo = i + 1;
				System.out.println(new String(chs));
			}
		}

		return new String(chs);
	}

	private static char[] reverseAndCapitalizeWord(char[] chs, int lo, int hi) {
		chs[lo] = Character.toUpperCase(chs[lo]);
		while (lo < hi) {
			char tmp = chs[lo];
			chs[lo] = chs[hi];
			chs[hi] = tmp;
			lo++;
			hi--;
		}
		return chs;
	}

	public static boolean isRotation(String str1, String str2) {
		// e.g., "waterbottLe" is a rotation of "erbottLewat"
		
		if(str1.length() != str2.length()) return false;
		
		String s2 = str2 + str2;
		
		return s2.indexOf(str1) != -1?true:false;
	}

	public static boolean stringExistInText(String string, String text) {
		// Search for a particular string in a given text
		char[] chs1 = string.toCharArray();
		char[] chs2 = text.toCharArray();
		int i = 0;
		for (int j = 0; j < chs2.length; j++) {
			if (chs1[i] == chs2[j]) {
				i++;
				if(i == chs1.length) return true;  
			} else {
				i = 0;
				if(i == chs1.length) return false;
			}
		}
		
		return false;
	}

	public static boolean equal(String str1, String str2) {
		// Find out whether two strings are the same or not without using the
		// equality operator nor the equals method.
		return false;
	}
	
	public static String longestPalindromes(String str) {
		System.out.println("palindromes:");
		int max = 1;
		int startsAt = 0;
		boolean[][] pal = new boolean[str.length()][str.length()];
		//l = 1
		for(int i=0; i<str.length();i++) {
			pal[i][i] = true;
		}
		
		//l = 2
		for(int i=0; i<str.length()-1;i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				pal[i][i+1] = true;
				max = 2;
				startsAt = i;
			}
		}
		
		for(int l=3; l<=str.length(); l++) {
			for(int i=0; i<=str.length()-l; i++) {
				if(str.charAt(i) == str.charAt(i+(l-1)) && pal[i+1][i+(l-1)-1]) {
					pal[i][i+(l-1)] = true;
					max = l;
					startsAt = i; 
					System.out.println("[" + i + ", " + (i+l-1) + "]: " + str.substring(i, i+l));
				}
			}
		}
		
		return str.substring(startsAt, startsAt + max);
	}
	
	public static String reverseWithRecursion(String str) {
		return reverseWithRecursion(str, 0);
	}
	
	private static String reverseWithRecursion(String str, int index) {
		char ch = str.charAt(index);
		if(index == str.length()-1) return "" + ch;  
		return reverseWithRecursion(str, ++index) + ch;
	}

}
