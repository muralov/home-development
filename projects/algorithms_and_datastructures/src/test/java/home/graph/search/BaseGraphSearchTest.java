package home.graph.search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;

public abstract class BaseGraphSearchTest {
	
	protected static Graph G;
	
	@BeforeClass
	public static void setUp() {
		List<String> lines = readLines("resources/graph.txt");
		G = new Graph(lines);
	}
	
	protected static List<String> readLines(String file) {
		List<String> lines = new ArrayList<>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));

			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			return lines;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;
	}

}
