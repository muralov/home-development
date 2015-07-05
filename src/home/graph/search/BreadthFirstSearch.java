package home.graph.search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends AbstractGraphSearch {
	
	public BreadthFirstSearch(Graph G, int s) {
		super(G, s);
	}
	
	protected void search(Graph G, int s) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		marked[s] = true;

		while (!q.isEmpty()) {
			int v = q.poll();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					count++;
					q.add(w);
				}
			}
		}
	}

}
