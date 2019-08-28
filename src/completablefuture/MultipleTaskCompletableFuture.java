package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class MultipleTaskCompletableFuture {

	public static void main(String[] args) {
		CompletableFuture<Integer> one = CompletableFuture.supplyAsync(new AddTask(10, 20));
		CompletableFuture<Integer> two = CompletableFuture.supplyAsync(new SubTask(50, 15));
		CompletableFuture<Integer> three = CompletableFuture.supplyAsync(new MultiplyTask(10, 20));
		CompletableFuture<Integer> four = CompletableFuture.supplyAsync(new DivTask(100, 5));
		CompletableFuture<Integer> five = CompletableFuture.supplyAsync(() -> 5);

		// Wait for all the tasks to complete
		System.out.println("All tasks started");
		CompletableFuture.allOf(one, two, three, four, five).join();
		System.out.println("All task completed");
		try {
			System.out.println("Add-> "+one.get());
			System.out.println("Sub-> "+two.get());
			System.out.println("Multiply-> "+three.get());
			System.out.println("Div-> "+four.get());
			System.out.println(five.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}

class AddTask implements Supplier<Integer> {
	private int i;
	private int j;

	AddTask(int i, int j) {
		this.i = i;
		this.j = j;
	}

	Integer add(int i, int j) {
		System.out.println("inside add");
		return i + j;
	}

	@Override
	public Integer get() {
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return add(i, j);
	}
}

class SubTask implements Supplier<Integer> {
	private int i;
	private int j;

	SubTask(int i, int j) {
		this.i = i;
		this.j = j;
	}

	int sub(int i, int j) {
		System.out.println("inside sub");
		return i - j;
	}

	@Override
	public Integer get() {
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return sub(i, j);
	}
}

class MultiplyTask implements Supplier<Integer> {
	private int i;
	private int j;

	MultiplyTask(int i, int j) {
		this.i = i;
		this.j = j;
	}

	int multiply(int i, int j) {
		System.out.println("inside multiply");
		return i * j;
	}

	@Override
	public Integer get() {
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return multiply(i, j);
	}
}

class DivTask implements Supplier<Integer> {
	private int i;
	private int j;

	DivTask(int i, int j) {
		this.i = i;
		this.j = j;
	}

	int div(int i, int j) {
		System.out.println("inside div");
		return i / j;
	}

	@Override
	public Integer get() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return div(i, j);
	}
}