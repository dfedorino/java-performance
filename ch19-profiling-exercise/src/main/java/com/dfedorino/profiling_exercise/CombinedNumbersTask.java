package com.dfedorino.profiling_exercise;

import java.util.ArrayList;
import java.util.List;

public class CombinedNumbersTask implements Runnable {

	private FibonnaciNumbersTask fibonnaciNumbersTask;
	private PrimeNumbersTaskI primeNumbersTask;
	
	private final List<Integer> primes = new ArrayList<>();
	private final List<Integer> fibonnacis = new ArrayList<>();
	private List<Integer> combined = new ArrayList<>();
	
	private boolean finished;
	
	public void taskComplete() {
		finished = true;
	}
	
	public void printCombinedNumbers() {
		synchronized (this) {
			//System.out.println(combined.toString());			
		}
	}

	public void setFibonnaciNumbersTask(FibonnaciNumbersTask fibonnaciNumbersTask) {
		this.fibonnaciNumbersTask = fibonnaciNumbersTask;
	}

	public void setPrimeNumbersTask(PrimeNumbersTaskI primeNumbersTask) {
		this.primeNumbersTask = primeNumbersTask;
	}
	
	public int getSize() {
		synchronized (this) {
			if (combined == null) return 0;
			return (combined.size());
		}
	}

	@Override
	public void run() {
		while (!finished) {
			Integer prime = primeNumbersTask.getNextNumber();
			if (prime != null) primes.add(prime);
			Integer fib = fibonnaciNumbersTask.getNextNumber();
			if (fib != null) fibonnacis.add(fib);

			synchronized (this) {
				combined = new ArrayList<>(primes);
				combined.retainAll(fibonnacis);
			}

		}
		//System.out.println(">> Combined Numbers Task is finished!");
		
	}

}
