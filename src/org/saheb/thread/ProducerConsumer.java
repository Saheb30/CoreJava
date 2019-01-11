package org.saheb.thread;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {
	public static void main(String[] args) throws InterruptedException {
		List<Integer> counter = new LinkedList<>();
		Producer p1= new Producer(counter);
		Consumer c1 = new Consumer(counter);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(c1);
		t1.start();
		t2.start();
	}

}

class Producer implements Runnable {
	List<Integer> counter;
	Producer(List<Integer> counter){
		this.counter = counter;
	}
	@Override
	public void run() {
		int val =0;
		while (true) {
			synchronized (counter) {
				if (counter.size() == 4) {
					try {
						counter.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				counter.add(val++);
				System.out.println("Produced-->" + counter);
				counter.notify();
			}
		}
	}
	
	/*private void produce() throws InterruptedException {
	}*/

}

class Consumer implements Runnable {
	List<Integer> counter;
	Consumer(List<Integer> counter){
		this.counter = counter;
	}
	@Override
	public void run() {
		while (true) {
			synchronized (counter) {
				if (counter.size() ==  0) {
					try {
						counter.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				counter.remove(0);
				System.out.println("Consumed-->" + counter);
				counter.notify();
			}
		}
	}
	/*private void consume() throws InterruptedException {
		
	}*/
}