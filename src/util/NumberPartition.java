package util;

public class NumberPartition {
	public static void main(String[] args) {
		partition(4, 100);
	}

	static void partition(int numberOfParts, int number) {
		final int chunksPerPartition = number / numberOfParts;
		for (int i = 0; i < numberOfParts; i++) {
			final int lower = (i * chunksPerPartition) + 1;
			final int upper = (i == numberOfParts - 1) ? number : lower + chunksPerPartition - 1;
			//int upper = lower + chunksPerPartition - 1;
			System.out.println(lower+" -> "+upper);
		}
	}

}
