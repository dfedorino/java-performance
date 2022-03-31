public class Main {
	public static void main(String[] args) throws InterruptedException {
		NumberChecker nc = new NumberChecker();

		// Approaches to handle compilation to native code:
		// 1. Disable native compilation with a -XX:-TieredCompilation flag (not recommended)
		// 2. Add a warm-up period (10_000 is a default value for the code to be natively compiled)

		// Check compilation threshold with the -XX:+PrintFlagsFinal | grep CompileThreshold

		System.out.println(">> Starting warm-up period...");

		long warmUpStart = System.currentTimeMillis();
		for (int i = 0; i < 15_000; i++) {
			nc.isPrime(i);
		}
		// The line:
		// 172  201 %     4       NumberChecker::isPrime @ 5 (58 bytes)
		// in compilation log means that this method was added to code cache
		long warmUpEnd = System.currentTimeMillis();

		System.out.println(">> Time taken by warm-up period -> " + (warmUpEnd - warmUpStart) + "ms");

		Thread.sleep(2000);
		System.out.println(">> Start measuring execution time...");


		/*
		isPrime compilation log:

		2785  332 %     3       Main::main @ 89 (134 bytes)
   		2801  333       3       Main::main (134 bytes)
   		Time taken -> 602ms


		optimizedIsPrime compilation log:

		2445  339 %     3       Main::main @ 86 (128 bytes)
		2454  340       3       Main::main (128 bytes)
		Time taken -> 286ms
		*/

		long start = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			nc.isPrime(i);
		}
		long end = System.currentTimeMillis();

		System.out.println("Time taken -> " + (end - start) + "ms");
	}
}
