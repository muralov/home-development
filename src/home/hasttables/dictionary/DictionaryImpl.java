package home.hasttables.dictionary;

public class DictionaryImpl implements Dictionary {

	private Item[] items;
	/**
	 * Dictionary size
	 */
	private int M;
	/**
	 * Number of elements
	 */
	private int N;
	
	/**
	 * Give possible maximal value of N, that is number of elements
	 * @param maxN maximal value of N
	 */
	public DictionaryImpl(int maxN) {
		M = 2 * maxN;
		N = 0;
		items = new Item[M];
	}
	
	@Override
	public void insert(Item item) {
		int hash;
		if(item.getKey() instanceof String) {
			hash = hashCode((String)item.getKey());
			
			while(items[hash] != null) hash = (hash + 1) % M; //loop until empty element is found
			items[hash] = item;
			N++;
		}
	}

	@Override
	public Item search(Item item) {
		
		if(item.getKey() instanceof String) {
			int hash = hashCode((String)item.getKey());
			while(items[hash] != null) {
				Item it = items[hash];
				String itKey = (String)it.getKey();
				if(itKey.equals((item.getKey()))) return it;
				hash = (hash + 1) % M;
			}
			
		}
		return null;
	}
	
	@Override
	public void delete(Item key) {
		
	}
	
	private int hashCode(String key) {
		/*if(key.length() > 0) {
			char s[] = key.toCharArray();
	 		int hash = 0;
			int skip = Math.max(1, key.length()/8);
			for(int i = 0; i < key.length(); i += skip) {
				hash = s[i] + (31 * hash);
			}
			return hash;
		}*/
		
		return (key.hashCode() & 0x7fffffff) % M;
	}

}
