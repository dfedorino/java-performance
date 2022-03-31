package com.dfedorino.primes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeBenchmarkingTest {
    private final PrimeBenchmarking app = new PrimeBenchmarking();

    @Test
    void testIsPrime() {
        assertTrue(app.isPrime(23));
        assertFalse(app.isPrime(22));
    }

    @Test
    void testOptimizedIsPrime() {
        assertTrue(app.optimizedIsPrime(23));
        assertFalse(app.optimizedIsPrime(22));
    }
}