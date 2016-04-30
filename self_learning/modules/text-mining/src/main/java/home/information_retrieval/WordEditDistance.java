package home.information_retrieval;

public class WordEditDistance extends EditDistance {

	public WordEditDistance(String word1, String word2) {
		super(word1, word2);
	}

	@Override
	public int calculate() {
		char[] chars1 = splitString(arg1);
		char[] chars2 = splitString(arg2);

		int xlength = chars1.length + 1;
		int ylength = chars2.length + 1;

		int d[][] = new int[xlength][ylength];

		for (int i = 0; i < xlength; i++) {
			d[i][0] = i;
		}

		for (int j = 0; j < ylength; j++) {
			d[0][j] = j;
		}
		
		for (int i = 1; i < xlength; i++) {
			for (int j = 1; j < ylength; j++) {
				d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1,
						chars1[i-1] != chars2[j-1] ? d[i-1][j-1] + 2 : d[i-1][j-1]);
			}
		}

		return d[xlength-1][ylength-1];
	}

	protected char[] splitString(String string) {
		return string.toCharArray();
	}

	static int min(int a, int b, int c) {
		int min = a;
		if(b < min) min = b;
		if(c < min) min = c;
		return min;
	}

}
