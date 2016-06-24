package home.java.lambdas;

import java.util.function.UnaryOperator;

public class RecurionsExercises {

	static UnaryOperator<Integer> function;
	
	public static int sumsq(int n) {
		//returns 1*1 + 2*2 + ... + n*n
		function = x -> x==0 ? 0 : x * x + function.apply(x-1);
		return function.apply(n);
	}
	
	public static int factorial(int n) {
		function = x -> x==0 ? 1 : x * function.apply(x - 1);
		return function.apply(n);
	}
	
	public static int fibonacci(int n) {
		function = x -> x < 2 ? 1: function.apply(x-2) + function.apply(x-1);
		return function.apply(n);
	}
	
	public static void main(String[] args) {
		
	}

}
