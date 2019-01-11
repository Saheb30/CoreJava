package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
			
			@Override
			public void run() {
				System.out.println("All parties reached the barrier");
			}
		});
		Thread t1 = new Thread(new BarrierTask("First Service", 1000, barrier));
		Thread t2 = new Thread(new BarrierTask("Second Service", 1000, barrier));
		Thread t3 = new Thread(new BarrierTask("Third Service", 1000, barrier));
		t1.start();
		t2.start();
		t3.start();
	}
}
class BarrierTask implements Runnable{
	private String name;
	private int duration;
	CyclicBarrier barrier;

	public BarrierTask(String name, int duration, CyclicBarrier barrier) {
		super();
		this.name = name;
		this.duration = duration;
		this.barrier = barrier;
	}
	@Override
	public void run() {
		try {
			System.out.println(name+" has started");
			barrier.await();
			Thread.sleep(duration);
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(name+" has started again");
	}
}
