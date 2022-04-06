package com.dfedorino.coding_choices;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Threads(Threads.MAX)
public class LoopVsStream {

    @State(Scope.Thread)
    public static class Data {
        List<String> toBeConcatenated;

        @Setup(Level.Trial)
        public void setup() {
            toBeConcatenated = IntStream.iterate(1, i -> i += 1)
                    .limit(100_000)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.toList());
        }
    }

    @Benchmark
    public List<Integer> loop(Data d) {
        List<Integer> result = new ArrayList<>();
        for (String next : d.toBeConcatenated) {
            int nextInt = Integer.parseInt(next);
            if (nextInt % 2 == 0) {
                result.add(nextInt);
            }
        }
        return result;
    }

    @Benchmark
    public List<Integer> stream(Data d) {
        return d.toBeConcatenated.stream()
                .mapToInt(Integer::valueOf)
                .filter(i -> i % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }

    @Benchmark
    public List<Integer> parallel_stream(Data d) {
        return d.toBeConcatenated.parallelStream()
                .mapToInt(Integer::valueOf)
                .filter(i -> i % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }

//    Benchmark                     Mode  Cnt   Score   Error  Units
//    LoopVsStream.loop             avgt   25   9,645 ▒ 1,036  ms/op
//    LoopVsStream.parallel_stream  avgt   25  11,566 ▒ 0,427  ms/op
//    LoopVsStream.stream           avgt   25   9,116 ▒ 0,270  ms/op
}
