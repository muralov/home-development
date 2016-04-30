package home.java.concurrency;

public class MyExecutor {

	public static void main(String[] args) throws InterruptedException {
		
		Queue q = new Queue();
		
		Runnable r1 = () -> {
			q.put(1);
		};
		
		Runnable r2 = () -> {
			q.put(2);
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		for(int n: q.getNumbers()) {
			System.out.print(n + " ");
		}
	}

}
