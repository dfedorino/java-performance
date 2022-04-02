package com.dfedorino.profiling_exercise;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
public class PerformanceTest {
    private final Main main = new Main();

    @Benchmark
    public void originalCodePerformanceTest() throws InterruptedException {
        main.version1();
    }

    @Benchmark
    public void optimizedCodePerformanceTest() throws InterruptedException {
        main.version2();
    }

//    Benchmark                                     Mode  Cnt   Score   Error  Units
//    PerformanceTest.optimizedCodePerformanceTest  avgt   25  11,055 ▒ 0,147   s/op
//    PerformanceTest.originalCodePerformanceTest   avgt   25  12,467 ▒ 0,322   s/op
}