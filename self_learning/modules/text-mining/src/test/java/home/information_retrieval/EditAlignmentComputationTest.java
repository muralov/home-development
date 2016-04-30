package home.information_retrieval;

import org.junit.Test;

public class EditAlignmentComputationTest {
	
	@Test
	public void testCompute() {
		String word1 = "intention";
		String word2 = "execution";
		EditAlignmentComputation eac = new EditAlignmentComputation(word1, word2);
		int al[][] = eac.compute();
		int colLength = al.length;
		int rowLength = al[0].length; 
		for(int i = 0; i<colLength;i++) {
			for(int j = 0; j<rowLength; j++) {
				System.out.print(al[i][j] + ", ");
			}
			System.out.println();
		}
	}

}
