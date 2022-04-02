package com.dfedorino.profiling_exercise;

import java.util.ArrayList;
import java.util.List;

public class FibonnaciNumbersTask implements Runnable {

	private final List<Integer> fibonnacis = new ArrayList<Integer>();
	private boolean finished;

	public void taskComplete() {
		finished = true;
	}

	public Integer getNextNumber() {
		synchronized (this) {
			if (fibonnacis.size() >0) {
				return fibonnacis.remove(0);
			}
			else return null;
		}
	}

	@Override
	public void run() {
		int a = 0;
		int b = 1;

		synchronized (this) {
			fibonnacis.add(a);
			fibonnacis.add(b);
		}

		int iterations = 0;
		while (!finished) {
			if (iterations % 1_000_000_000 == 0) {
				//System.out.println(">> inside Fibonacci loop, task is finished -> " + finished);
			}

			//we need to stop the fibonnaci numbers growing too quickly so we'll pause if there are > 100 waiting to be collected
			if (fibonnacis.size() < 100) {
				int c = a+b;

				//only the add really needs to be synchronized.
				synchronized (this) {
					fibonnacis.add(c);
				}

				a = b;
				b = c;
			}
			iterations++;
		}
		//System.out.println(">> Fibonacci Numbers Task is finished!");

	}

}
