package home.java.concurrency;

import java.util.concurrent.TimeUnit;

public class Java8Concurrency {
	
	public static void main(String[] args) {
//		Runnable runnable = () -> {
//			String threadName = Thread.currentThread().getName();
//			System.out.println("Current thread name: " + threadName);
//		};
		
		Thread t = new Thread(() -> {
			String name = Thread.currentThread().getName();
			System.out.println("Foo " + name);
	        try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("Bar " + name);
			});
		t.start();
		
		System.out.println("Done.");
	}

}
