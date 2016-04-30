package home.algorithms;

public class Transition<I> {
	
	private I value;
	
	boolean finishing;

	public Transition(I value) {
		this.value = value;
	}
	
	public Transition(I value, boolean finishing) {
		this.value = value;
		this.finishing = finishing;
	}

	public I getValue() {
		return value;
	}

	public void setValue(I value) {
		this.value = value;
	}
	
}
