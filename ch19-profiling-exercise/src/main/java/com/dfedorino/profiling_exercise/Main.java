package com.dfedorino.profiling_exercise;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		int target = 8;
		
		PrimeNumbersTask primeNumbersTask = new PrimeNumbersTask();
		Thread primesGeneratorThread = new Thread(primeNumbersTask);
		primesGeneratorThread.start();
		primesGeneratorThread.setName("primesGeneratorThread");
		
		FibonnaciNumbersTask fibonnaciNumbersTask = new FibonnaciNumbersTask();
		Thread fibonnaciNumbersThread = new Thread(fibonnaciNumbersTask);
		fibonnaciNumbersThread.setName("fibonnaciNumbersThread");
		fibonnaciNumbersThread.start();
		
		CombinedNumbersTask combinedNumbersTask = new CombinedNumbersTask();
		combinedNumbersTask.setPrimeNumbersTask(primeNumbersTask);
		combinedNumbersTask.setFibonnaciNumbersTask(fibonnaciNumbersTask);
		Thread combinedNumbersThread = new Thread(combinedNumbersTask);
		combinedNumbersThread.start();
		combinedNumbersThread.setName("combinedNumbersThread");
		
		int combined = 0;
		int iterations = 0;
		while (combined < target) {
			iterations++;
			combined = combinedNumbersTask.getSize();
			
			if (iterations > 200) {
				iterations = 0;
				//System.out.println( "Currently got " + combined + " matching numbers.");
				if (combined > 0) combinedNumbersTask.printCombinedNumbers();
				Thread.sleep(1000);
			}
		}
		//System.out.println("Job done  - found " + combined + ".");
		// [2, 3, 5, 13, 89, 233, 1597, 28657]
		if (combined > 0) combinedNumbersTask.printCombinedNumbers();

		primeNumbersTask.taskComplete();
		fibonnaciNumbersTask.taskComplete();
		combinedNumbersTask.taskComplete();
	}

	public void version1() throws InterruptedException {
		int target = 8;

		PrimeNumbersTask primeNumbersTask = new PrimeNumbersTask();
		Thread primesGeneratorThread = new Thread(primeNumbersTask);
		primesGeneratorThread.start();
		primesGeneratorThread.setName("primesGeneratorThread");

		FibonnaciNumbersTask fibonnaciNumbersTask = new FibonnaciNumbersTask();
		Thread fibonnaciNumbersThread = new Thread(fibonnaciNumbersTask);
		fibonnaciNumbersThread.setName("fibonnaciNumbersThread");
		fibonnaciNumbersThread.start();

		CombinedNumbersTask combinedNumbersTask = new CombinedNumbersTask();
		combinedNumbersTask.setPrimeNumbersTask(primeNumbersTask);
		combinedNumbersTask.setFibonnaciNumbersTask(fibonnaciNumbersTask);
		Thread combinedNumbersThread = new Thread(combinedNumbersTask);
		combinedNumbersThread.start();
		combinedNumbersThread.setName("combinedNumbersThread");

		int combined = 0;
		int iterations = 0;
		while (combined < target) {
			iterations++;
			combined = combinedNumbersTask.getSize();

			if (iterations > 200) {
				iterations = 0;
				//System.out.println( "Currently got " + combined + " matching numbers.");
				if (combined > 0) combinedNumbersTask.printCombinedNumbers();
				Thread.sleep(1000);
			}
		}
		//System.out.println("Job done  - found " + combined + ".");
		if (combined > 0) combinedNumbersTask.printCombinedNumbers();

		primeNumbersTask.taskComplete();
		fibonnaciNumbersTask.taskComplete();
		combinedNumbersTask.taskComplete();
	}

	public void version2() throws InterruptedException {
		int target = 8;

		OptimizedPrimeNumbersTask primeNumbersTask = new OptimizedPrimeNumbersTask();
		Thread primesGeneratorThread = new Thread(primeNumbersTask);
		primesGeneratorThread.start();
		primesGeneratorThread.setName("primesGeneratorThread");

		FibonnaciNumbersTask fibonnaciNumbersTask = new FibonnaciNumbersTask();
		Thread fibonnaciNumbersThread = new Thread(fibonnaciNumbersTask);
		fibonnaciNumbersThread.setName("fibonnaciNumbersThread");
		fibonnaciNumbersThread.start();

		CombinedNumbersTask combinedNumbersTask = new CombinedNumbersTask();
		combinedNumbersTask.setPrimeNumbersTask(primeNumbersTask);
		combinedNumbersTask.setFibonnaciNumbersTask(fibonnaciNumbersTask);
		Thread combinedNumbersThread = new Thread(combinedNumbersTask);
		combinedNumbersThread.start();
		combinedNumbersThread.setName("combinedNumbersThread");

		int combined = 0;
		int iterations = 0;
		while (combined < target) {
			iterations++;
			combined = combinedNumbersTask.getSize();

			if (iterations > 200) {
				iterations = 0;
				//System.out.println( "Currently got " + combined + " matching numbers.");
				if (combined > 0) combinedNumbersTask.printCombinedNumbers();
				Thread.sleep(1000);
			}
		}
		//System.out.println("Job done  - found " + combined + ".");
		if (combined > 0) combinedNumbersTask.printCombinedNumbers();

		primeNumbersTask.taskComplete();
		fibonnaciNumbersTask.taskComplete();
		combinedNumbersTask.taskComplete();
	}

}
