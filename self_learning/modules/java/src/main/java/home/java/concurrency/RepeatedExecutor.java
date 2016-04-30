package home.java.concurrency;

import java.util.concurrent.Executor;

public class RepeatedExecutor implements Executor {

	@Override
	public void execute(Runnable command) {
		new Thread(command).start();
	}

	public void execute(Runnable runnable, int times) {
		System.out.printf("Calling Task.run() thro' Executor.execute() for %d times %n", times);
		for (int i = 0; i < times; i++) {
			execute(runnable);
		}
	}
	
	public static void main(String[] args) {
		Runnable task = new Task();
		System.out.println("Calling Task.run() by directly creating a Thread object");
		Thread thread = new Thread(task);
		thread.start();
		
		RepeatedExecutor rexecutor = new RepeatedExecutor();
		rexecutor.execute(task, 3);
		
	}

}
