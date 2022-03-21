package com.dfedorino.ch2;

public class Main {

	public static void main(String[] args) throws InterruptedException {
//		Thread.sleep(20000);
//		System.out.println("starting the work...");
		long averageElapsedTime = 0L;

		for (int i = 0; i < 100; i++) {
			long start = System.currentTimeMillis();

			PrimeNumbers primeNumbers = new PrimeNumbers();
			Integer max = Integer.parseInt(args[0]);
			primeNumbers.generateNumbers(max);

			long end = System.currentTimeMillis();

			averageElapsedTime += end - start;
		}

		System.out.println("Average elapsed time: " + (averageElapsedTime) / 100.0);

		/*
			CICompilerCount stats:
			100 times generate 10001 prime numbers:

			-XX:CICompilerCount=2
			 Average elapsed time: 1094.63

			-XX:CICompilerCount=4
			 Average elapsed time: 1022.64

			-XX:CICompilerCount=6
			 Average elapsed time: 1020.3

			-XX:CICompilerCount=8
			 Average elapsed time: 1067.74



			 CompileCountStats:
			 100 times generate 10001 prime numbers:

			 -XX:CompileThreshold=10000
			 Average elapsed time: 1091.14

			 -XX:CompileThreshold=5000
			 Average elapsed time: 1032.59

			 -XX:CompileThreshold=1000
			 Average elapsed time: 1025.06

			 -XX:CompileThreshold=500
			 Average elapsed time: 1027.66
		 */
	}

}
