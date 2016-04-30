package home.algorithms;

import java.util.List;

public interface StateMachine<T, I> {
	void addState(T startState, I transition, T endState);
	void assignAccessible(T state);
	boolean isAccessible(T startState, List<I> transition, T endState);
}
