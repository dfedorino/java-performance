package com.dfedorino.profiling_exercise;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersTask implements PrimeNumbersTaskI {

	private List<Integer> primes = new ArrayList<Integer>();
	private Integer lastNumberChecked;
	private NumberChecker checker;
	private Boolean finished = false;

	private void generateNextPrime() {

		//only the add really needs to be synchronized
		Integer testNumber = lastNumberChecked + 1;
		while (!checker.isPrime(testNumber)) {
			testNumber++;
		}
		lastNumberChecked = testNumber;
		synchronized (this) {
			primes.add(testNumber);
		}
	}

	public void taskComplete() {
		finished = true;
	}

	public int getSize() {
		synchronized (this) {
			return (primes.size());
		}
	}

	@Override
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

		checker= new NumberChecker();
		synchronized (this) {
			primes.add(2);
		}
		lastNumberChecked = 2;

		while (!finished) {
			generateNextPrime();
		}
	}
}