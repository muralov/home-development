package home.graph.search;


public class DepthFirstSearch extends AbstractGraphSearch {
	
	public DepthFirstSearch(Graph G, int s) {
		super(G, s);
	}
	
	protected void search(Graph G, int v) {
		marked[v] = true;
		count++;
		for(int w: G.adj(v)) {
			if(!marked[w]) {
				edgeTo[w] = v;
				search(G, w);
			}
		}
	}

}
