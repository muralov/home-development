package home.algorithms.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MazeProblem {

	private static class Node {
		public char value;
		public int x;
		public int y;
		public boolean visited;

		public Node(int x, int y, char value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	
	static Map<Integer, Node> nodes = new HashMap<>();

	private static char[][] maze = { 
			{ 'S', '#', '#', '#', '#', '#' }, 
			{ '.', '.', '.', '.', '.', '#' },
			{ '#', '.', '#', '#', '#', '#' }, 
			{ '#', '.', '#', '#', '#', '#' }, 
			{ '.', '.', '.', '#', '.', 'G' },
			{ '#', '#', '.', '.', '.', '#' } 
			};

	public static void mazeRunner(int x, int y) {

		Queue<Node> q = new LinkedList<>();
		Node source = new Node(x, y, maze[x][y]);
		q.add(source);
		source.visited = true;
		
		while (!q.isEmpty()) {
			Node current = q.peek();
			x= current.x;
			y = current.y;
			q.remove();
			System.out.println("(" + x + ", " + y + ")=" + maze[x][y]);
			

//			if (!current.visited) {
				// E - x+1
				if (x < maze[0].length-1 && maze[x + 1][y] != '#') {
					Node eastNode = getNode(x + 1, y);
					if(!eastNode.visited) {
						q.add(eastNode);
						eastNode.visited = true;

					}
					// System.out.println("(" + (x +1) + ", " + y +")");
				}
				// N - y-1
				if (y > 0 && maze[x][y - 1] != '#') {
					Node northNode = getNode(x, y - 1);
					if(!northNode.visited) {
						q.add(northNode);
						northNode.visited = true;

					}
					// System.out.println("(" + x + ", " + (y-1) +")");
				}
				// W - x-1
				if (x > 0 && maze[x - 1][y] != '#') {
					Node westNode = getNode(x - 1, y);
					if(!westNode.visited) {
						q.add(westNode);
						westNode.visited = true;

					}
					// System.out.println("(" + (x-1) + ", " + y +")");
				}
				// S - y+1
				if (y < maze.length-1 && maze[x][y + 1] != '#') {
					Node southNode = getNode(x, y + 1);
					if(!southNode.visited) {
						q.add(southNode);
						southNode.visited = true;

					}
					// System.out.println("(" + x + ", " + (y+1) +")");
				}
			}
//		}

	}
	
	private static Node getNode(int x, int y) {
		int key = x + 10 * y;
		if (nodes.containsKey(key))
			return nodes.get(key);

		Node n = new Node(x, y, maze[x][y]);
		nodes.put(key, n);
		return n;
	}

	public static void main(String[] args) {
		mazeRunner(0, 0);

	}

}
