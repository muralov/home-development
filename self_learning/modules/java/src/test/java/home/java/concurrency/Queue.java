package home.java.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Queue {
	
	Lock lock = new ReentrantLock();
	List<Integer> numbers;
	
	public Queue() {
		numbers = new ArrayList<>();
	}
	
	public void put(int number) {
//		lock.lock();
		try {
		numbers.add(number);
		} finally {
//			lock.unlock();
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
	
}
