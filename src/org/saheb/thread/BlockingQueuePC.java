package org.saheb.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueuePC {
	private static final int MAX_SIZE = 10;
	private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(MAX_SIZE);

	public static void main(String[] args) {
		MyProducer producer = new MyProducer(queue);
		MyConsumer consumer = new MyConsumer(queue);
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		t1.start();
		t2.start();
	}

}

class MyProducer implements Runnable {
	BlockingQueue<Integer> queue;

	MyProducer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				queue.put(1);
				System.out.println("Produced");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyConsumer implements Runnable {
	BlockingQueue<Integer> queue;

	MyConsumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				queue.take();
				System.out.println("Consumed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
