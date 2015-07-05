package home.hasttables.dictionary;

public interface Dictionary {

	void insert(Item item);
	
	void delete(Item item);
	
	Item search(Item item);
	
}
