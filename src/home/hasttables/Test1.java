package home.hasttables;

public class Test1 {
	
	public static int hashCode(String value) {
		char s[] = value.toCharArray();
 		int hash = 0;
		int skip = Math.max(1, value.length()/8);
		for(int i = 0; i < value.length(); i += skip) {
			hash = s[i] + (31 * hash);
		}
		return hash;
	}

}
