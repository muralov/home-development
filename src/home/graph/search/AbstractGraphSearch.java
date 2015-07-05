package home.graph.search;

import java.util.Stack;

public abstract class AbstractGraphSearch implements GraphSearch {
	
	protected int source;
	protected int edgeTo[];
	protected boolean[] marked;
	protected int count;
	
	protected AbstractGraphSearch(Graph G, int source) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.source = source;
		search(G, source);
	}
	
	protected abstract void search(Graph G, int s);
	
	@Override
	public boolean marked(int w) {
		return marked[w];
	}
	
	@Override
	public int count() {
		return count;
	}
	
	@Override
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	@Override
	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v)) return null;
		
		Stack<Integer> path = new Stack<>();
		for(int i = v; i != source; i = edgeTo[i]) {
			path.push(i);
		}
		path.push(source);
		return path;
	}

}
