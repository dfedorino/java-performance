package com.dfedorino.profiling_exercise;

import java.util.ArrayList;
import java.util.List;

public class OptimizedPrimeNumbersTask implements PrimeNumbersTaskI {

	private final List<Integer> primes = new ArrayList<>();
	private int lastNumberChecked;
	private final NumberChecker checker = new NumberChecker();
	private boolean finished;

	private void generateNextPrime() {

		int testNumber = lastNumberChecked + 1;
		while (!checker.optimizedIsPrime(testNumber)) {
			testNumber++;
		}
		lastNumberChecked = testNumber;

		//only the add really needs to be synchronized
		synchronized (this) {
			primes.add(testNumber);
		}
	}

	public void taskComplete() {
		finished = true;
	}

	public Integer getNextNumber() {
		synchronized (this) {
			if (primes.size() >0) {
				return primes.remove(0);
			}
			else return null;
		}
	}

	@Override
	public void run() {
		synchronized (this) {
			primes.add(2);
		}

		lastNumberChecked = 2;

		while (!finished) {
			generateNextPrime();
		}

		//System.out.println(">> Prime Numbers Task is finished!");
	}
}
