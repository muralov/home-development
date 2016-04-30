package hello;

public class Main {

	public static void main(String[] args) {
		palindrome();
	}

	static void palindrome() {
		String word = "nitin";

		int count = 0;
		String max = word.substring(0, 1);
		for (int i = 0; i < word.length(); i++) {
			for (int j = i; j < word.length(); j++) {
				String w = word.substring(i, j + 1);
				if (isPalindrome(w)) {
					System.out.println(w);
					if (w.length() > max.length()) {
						max = w;
					}
					count++;
				}
			}
		}

		System.out.println("number of palindromes: " + count);
		System.out.println("the longest palindrome: " + max);
	}

	static boolean isPalindrome(String word) {
		if (word.length() == 1)
			return true;

		for (int i = 0; i < word.length()/2; i++) {
			if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

}
