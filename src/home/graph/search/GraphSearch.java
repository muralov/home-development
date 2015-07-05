package home.graph.search;

public interface GraphSearch {

	Iterable<Integer> pathTo(int v);
	
	boolean marked(int w);
	
	int count();
	
	boolean hasPathTo(int v);
	
}
