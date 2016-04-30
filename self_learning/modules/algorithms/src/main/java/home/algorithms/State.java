package home.algorithms;

public class State<T> {
	
	private T id;
	private boolean isAccepted;
	
	public State(T id) {
		this.id = id;
	}
	
	public State(T id, boolean isAcceptable) {
		this.id = id;
		this.isAccepted = isAcceptable;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public T getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj.equals(id)) return true;
		return false;
	}

}
