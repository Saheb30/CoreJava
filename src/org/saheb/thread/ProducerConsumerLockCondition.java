package org.saheb.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerLockCondition {
	public static void main(String[] args) {
		// Object on which producer and consumer thread will operate
		ProducerConsumerImpl sharedObject = new ProducerConsumerImpl();

		// creating producer and consumer threads
		ProducerTask p = new ProducerTask(sharedObject);
		ConsumerTask c = new ConsumerTask(sharedObject);

		// starting producer and consumer threads
		p.start();
		c.start();
	}
}

class ProducerConsumerImpl {
	// producer consumer problem data
	private static final int CAPACITY = 3;
	private final Queue<Integer> queue = new LinkedList<>();
	private final Random theRandom = new Random();

	// lock and condition variables
	private final Lock aLock = new ReentrantLock();
	private final Condition bufferNotFull = aLock.newCondition();
	private final Condition bufferNotEmpty = aLock.newCondition();

	public void put() throws InterruptedException {
		aLock.lock();
		try {
			if (queue.size() == CAPACITY) {
				System.out.println(Thread.currentThread().getName() + " : Buffer is full, waiting");
				bufferNotEmpty.await();//await release lock automatically
			}

			int number = theRandom.nextInt();
			boolean isAdded = queue.offer(number);
			if (isAdded) {
				System.out.printf("%s added %d into queue %n", Thread.currentThread().getName(), number);
				// signal consumer thread that, buffer has element now
				bufferNotFull.signalAll();
			}
		} finally {
			aLock.unlock();
		}
	}

	public void get() throws InterruptedException {
		aLock.lock();
		try {
			if (queue.size() == 0) {
				System.out.println(Thread.currentThread().getName() + " : Buffer is empty, waiting");
				bufferNotFull.await();
			}
			Integer value = queue.poll();
			Thread.sleep(2000);
			if (value != null) {
				System.out.printf("%s consumed %d from queue %n", Thread.currentThread().getName(), value);

				// signal producer thread that, buffer may be empty now
				bufferNotEmpty.signalAll();
			}

		} finally {
			aLock.unlock();
		}
	}
}

class ProducerTask extends Thread {
	ProducerConsumerImpl pc;

	public ProducerTask(ProducerConsumerImpl sharedObject) {
		super("PRODUCER");
		this.pc = sharedObject;
	}

	@Override
	public void run() {
		try {
			while(true) {
				pc.put();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ConsumerTask extends Thread {
	ProducerConsumerImpl pc;

	public ConsumerTask(ProducerConsumerImpl sharedObject) {
		super("CONSUMER");
		this.pc = sharedObject;
	}

	@Override
	public void run() {
		try {
			while(true) {
				pc.get();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
