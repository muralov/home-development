package home.java.collections;

import java.util.List;
import static java.util.stream.Collectors.*;

public class CollectionExercises {
	
	public static <T> List<T> tail(List<T> list) {
		
		
		return list;
	}
	
	public static List<String> sort(List<String> list) {
		return list.stream()
				.sorted((x, y) -> Integer.compare(x.length(), y.length()))
				.collect(toList());
	}

}
