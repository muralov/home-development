package home.java.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Factorial implements Callable<Long> {

	long n;

	public Factorial(long n) {
		this.n = n;
	}

	@Override
	public Long call() throws Exception {
		if (n <= 0) {
			throw new Exception("for finding factorial, N should be > 0");
		}
		long fact = 1;
		for (long longVal = 1; longVal <= n; longVal++) {
			fact *= longVal;
		}
		return fact;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long n = 20;
		
		Callable<Long> task = new Factorial(n);
		
		ExecutorService eservice = Executors.newFixedThreadPool(3);
		Future<Long> future = eservice.submit(task);
		
		System.out.printf("factorial of %d is %d", n, future.get());
		
		System.out.println();
		System.out.println("After future.get()");
		
		eservice.shutdown();
	}

}
