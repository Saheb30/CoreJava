package concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);
		Thread t1 = new Thread(new Task("First Service", 1000, latch));
		Thread t2 = new Thread(new Task("Second Service", 1000, latch));
		Thread t3 = new Thread(new Task("Third Service", 1000, latch));
		t1.start();
		t2.start();
		t3.start();
		latch.await();
		System.out.println("All service is up");
	}
}

class Task implements Runnable {
	private String name;
	private int duration;
	CountDownLatch latch;

	public Task(String name, int duration, CountDownLatch latch) {
		super();
		this.name = name;
		this.duration = duration;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " is Up");
		latch.countDown();

	}

}