package com.dfedorino.primes;

public class PrimeBenchmarking {

    public Boolean isPrime(Integer testNumber) {
        for (Integer i = 2; i < testNumber; i++) {
            if (testNumber % i == 0) return false;
        }
        return true;
    }

    public Boolean optimizedIsPrime(int testNumber) {
        int maxToCheck = (int) Math.sqrt(testNumber);
        for (int i = 2; i < testNumber; i++) {
            if (testNumber % i == 0) return false;
        }
        return true;
    }
}
