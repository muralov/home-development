package home.hasttables;

public class Main {

	public static void main(String[] args) {
		
		System.out.println(Test1.hashCode("http://www.cs.princeton.edu/introcs/13loop/Hello.java"));
		System.out.println(Test1.hashCode("http://www.cs.princeton.edu/introcs/13loop/Hello.class"));
		System.out.println(Test1.hashCode("http://www.cs.princeton.edu/introcs/13loop/Hello.html"));
		System.out.println(Test1.hashCode("http://www.cs.princeton.edu/introcs/13loop/index.html"));
		
//		System.out.println(Test1.hashCode("hello"));
//		System.out.println(Test1.hashCode("olleh"));
//		System.out.println(Test1.hashCode("lleho"));
//		System.out.println(Test1.hashCode("elolh"));
		
		System.out.println(new String("Aa").hashCode());
		System.out.println(new String("BB").hashCode());
		
//		System.out.println(Test1.hashCode("Aa"));
//		System.out.println(Test1.hashCode("BB"));
		int i = (-1 & 0x7fffffff);
		System.out.println(""+i);

	}

}
