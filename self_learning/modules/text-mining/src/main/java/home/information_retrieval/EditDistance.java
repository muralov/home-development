package home.information_retrieval;

public abstract class EditDistance {
	
	String arg1;
	String arg2;
	
	public EditDistance(String arg1, String arg2) {
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
	
	public abstract int calculate();
	
}
