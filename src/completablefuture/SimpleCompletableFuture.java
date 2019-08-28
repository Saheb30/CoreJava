package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SimpleCompletableFuture {
	public static void main(String[] args) {
		CompletableFuture<String> completableFuture = new CompletableFuture<String>();
		String result;
		completableFuture.complete("hello");
		CompletableFuture<String> completableFuture2 = CompletableFuture.completedFuture(" world");
		try {
			result = completableFuture.get() + completableFuture2.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		/*CompletableFuture.completedFuture("FUTURE")
				        .thenApply(r -> {System.out.println("Apply: "+r.toLowerCase()); return r.toLowerCase();})
				        .thenAccept(f -> System.out.println("Accept: "+f))
				        .thenAccept(f -> System.out.println("Accept2: "+f))
				        .thenApply(f -> new String("FUTURE"))
				        .thenAccept(f -> System.out.println("Accept3: "+f));*/
		
		CompletableFuture<Integer> future =   CompletableFuture.supplyAsync(() -> 1)
			                     								.thenApply(x -> {System.out.println("thenApply1: ");return (x+1);})
			                     								.thenApply(y -> {System.out.println("thenApply2: ");return (y+1);});
		
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		CompletableFuture<Integer> future2 =   CompletableFuture.supplyAsync(() -> 1)
				.thenCompose(x -> CompletableFuture.supplyAsync(() -> x+1))
				.thenCompose(y -> CompletableFuture.supplyAsync(() -> y+1));

		try {
		System.out.println(future2.get());
		} catch (InterruptedException | ExecutionException e) {
		e.printStackTrace();
		}
		
	}
}
