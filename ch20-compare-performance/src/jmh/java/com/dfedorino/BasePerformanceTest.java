package com.dfedorino;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Threads;

@BenchmarkMode(Mode.SingleShotTime)
@Threads(Threads.MAX)
@Fork(jvmArgs = {"-Xms4G", "-Xmx4G"})
public class BasePerformanceTest {}
