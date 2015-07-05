package home.hasttables.dictionary;

public class DictMain {

	public static void main(String[] args) {
		
		Dictionary dict = new DictionaryImpl(31);
		Item it1 = new Item<String>("www.princeton.edu","128.112.128.15");
		Item it2 = new Item<String>("www.cs.princeton.edu","128.112.136.35");
		Item it3 = new Item<String>("www.math.princeton.edu","128.112.18.11");
		Item it4 = new Item<String>("www.cs.harvard.edu","140.247.50.127");
		Item it5 = new Item<String>("www.harvard.edu","128.103.60.24");
		Item it6 = new Item<String>("www.yale.edu","128.36.236.74");
		Item it7 = new Item<String>("www.econ.yale.edu","128.36.236.74");
		Item it8 = new Item<String>("www.cs.yale.edu","128.36.229.30");
		Item it9 = new Item<String>("www.espn.com","128.112.44.10");
		Item it10 = new Item<String>("www.cnn.com","128.112.13.32");
		Item it11 = new Item<String>("www.bbc.co.uk","192.160.32.3");
		Item it12 = new Item<String>("www.ebay.de","192.168.23.26");
		Item it13 = new Item<String>("www.amazon.de","192.168.10.24");
		
		dict.insert(it1);
		dict.insert(it2);
		dict.insert(it3);
		dict.insert(it4);
		dict.insert(it5);
		dict.insert(it6);
		dict.insert(it7);
		dict.insert(it8);
		dict.insert(it9);
		dict.insert(it10);
		dict.insert(it11);
		dict.insert(it12);
		dict.insert(it13);
		
		long t1 = System.currentTimeMillis();
		Item resIt = dict.search(it12);
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time to search with hash: " + (t2 - t1));
		
		System.out.println("Key: " + resIt.getKey() + ", Value: " + resIt.getValue());

	}

}
