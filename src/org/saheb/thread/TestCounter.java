package org.saheb.thread;

public class TestCounter {
	static Integer counter = new Integer(0);
	public static void main(String[] args) throws InterruptedException {
		Producer1 p1= new Producer1();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					p1.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					p1.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
	}
}
class Producer1{
	void producer() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if (TestCounter.counter == 4) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				TestCounter.counter++;
				System.out.println("Produced-->" + TestCounter.counter);
				notify();
			}
		}
	}
	void consume() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if (TestCounter.counter ==  0) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				TestCounter.counter--;
				System.out.println("Consumed-->" + TestCounter.counter);
				notify();
			}
		}
	}
}

