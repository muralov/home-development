package home.java.concurrency;

public class Task implements Runnable {
	@Override
	public void run() {
		System.out.println("Calling Task.run() ");
	}
}
