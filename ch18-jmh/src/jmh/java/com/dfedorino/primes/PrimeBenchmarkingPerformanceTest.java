package com.dfedorino.primes;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class PrimeBenchmarkingPerformanceTest {
    private final PrimeBenchmarking app = new PrimeBenchmarking();

    @Benchmark
    public void testIsPrime() {
        for (int i = 0; i < 50_000; i++) {
            app.isPrime(i);
        }
    }

    @Benchmark
    public void testOptimizedIsPrime() {
        for (int i = 0; i < 50_000; i++) {
            app.optimizedIsPrime(i);
        }
    }

    /*
    * # Run complete. Total time: 00:17:05
    *
    * Benchmark                                               Mode  Cnt  Score   Error  Units
    * PrimeBenchmarkingPerformanceTest.testIsPrime           thrpt   25  2.046 ▒ 0.086  ops/s
    * PrimeBenchmarkingPerformanceTest.testOptimizedIsPrime  thrpt   25  3.627 ▒ 0.063  ops/s
    *
    * Benchmark                                              Mode  Cnt  Score   Error  Units
    * PrimeBenchmarkingPerformanceTest.testIsPrime           avgt   25  0,545 ▒ 0,033   s/op
    * PrimeBenchmarkingPerformanceTest.testOptimizedIsPrime  avgt   25  0,259 ▒ 0,006   s/op
    *
    */
}
