package home.algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StateMachineImpl<T, I> implements StateMachine<T, I> {
	
	Map<State<T>, Transition<I>> states = new HashMap<>();
	
	@Override
	public void addState(T startState, I transition, T endState) {
		State<T> st = getState(startState);
		if(states.containsKey(startState)) {
			states.put(st, new Transition<>(transition));
		} else {
			st = new State<>(startState);
			states.put(st, new Transition<>(transition));
		}
	}

	@Override
	public void assignAccessible(T state) {
		State<T> st = getState(state);
		if(states.containsKey(st)) {
			st.setAccepted(true);
		} else {
			st = new State<>(state, true);
		}
	}

	@Override
	public boolean isAccessible(T startState, List<I> transition, T endState) {
		State<T> sst = getState(startState);
		State<T> est = getState(endState);
		
		return false;
	}
	
	private State<T> getState(T startState) {
		for(State<T> s: states.keySet()) {
			if(s.getId().equals(startState)) {
				return s; 
			}
		}
		return null;
	}

}
