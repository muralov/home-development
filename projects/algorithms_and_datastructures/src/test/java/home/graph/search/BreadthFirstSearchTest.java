package home.graph.search;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

public class BreadthFirstSearchTest extends BaseGraphSearchTest {

	@Test
	public void testDFS() {
		BreadthFirstSearch bfs = new BreadthFirstSearch(G, 0);
		assertTrue(bfs.marked(3));
		assertTrue(bfs.marked(6));
		assertFalse(bfs.marked(11));
	}
	
	@Test
	public void testPathTo() {
		int source = 0;
		int target = 5;
		DepthFirstSearch dfs = new DepthFirstSearch(G, source);
		Iterable<Integer> path = dfs.pathTo(target);
		Iterator<Integer> pathIter = path.iterator();
		System.out.println("The path from "+source+" to "+target+" is: ");
		while(pathIter.hasNext()) {
			System.out.print(pathIter.next() + ", ");
		}
	}


	
}
