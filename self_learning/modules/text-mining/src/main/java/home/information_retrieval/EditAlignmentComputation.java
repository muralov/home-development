package home.information_retrieval;

public class EditAlignmentComputation {
	
	enum direction {INSERTION, DELETION, SUBSTITUTION}
	
	static final int INSERT = 1;
	static final int DELETE = -1;
	static final int SUBSTITUTE = 2;
	
	
	private String arg1;
	private String arg2;
	
	public EditAlignmentComputation(String arg1, String arg2) {
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
	
	public int[][] compute() {
		
		char[] chars1 = splitString(arg1);
		char[] chars2 = splitString(arg2);

		int xlength = chars1.length + 1;
		int ylength = chars2.length + 1;

		int d[][] = new int[xlength][ylength];
		int alignment[][] = new int[xlength][ylength];

		for (int i = 0; i < xlength; i++) {
			d[i][0] = i;
		}

		for (int j = 0; j < ylength; j++) {
			d[0][j] = j;
		}
		
		for (int i = 1; i < xlength; i++) {
			for (int j = 1; j < ylength; j++) {
				
				int min = chars1[i-1] != chars2[j-1] ? d[i-1][j-1] + 2 : d[i-1][j-1];
				alignment[i][j] = SUBSTITUTE;
				
				if(d[i - 1][j] + 1 < min) {
					min = d[i - 1][j] + 1;
					alignment[i][j] = DELETE;
				}
				
				if(d[i][j - 1] + 1 < min) {
					min = d[i][j - 1] + 1;
					alignment[i][j] = INSERT;
				}
			}
		}
		
		return alignment;
	}
	
	protected char[] splitString(String string) {
		return string.toCharArray();
	}

}
