package com.dfedorino.coding_choices;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Threads(Threads.MAX)
public class StringVsStringBuilder {

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
    public String concatenate_string(Data d) {
        String finalString = "";
        for (String next : d.toBeConcatenated) {
            finalString += next;
        }
        return finalString;
    }

    @Benchmark
    public StringBuilder concatenate_stringbuilder(Data d) {
        StringBuilder finalString = new StringBuilder();
        for (String next : d.toBeConcatenated) {
            finalString.append(next);
        }
        return finalString;
    }

//    java -Xms4G -Xmx4G -jar build/libs/ch22-coding-choices-1.0-jmh.jar "StringVsStringBuilder" -prof gc

//    Benchmark                                                                  Mode  Cnt            Score           Error   Units
//    StringVsStringBuilder.concatenate_string                                     ss    5        10952,998 ▒      1149,860   ms/op
//    StringVsStringBuilder.concatenate_string:▒gc.alloc.rate                      ss    5         7392,454 ▒       432,320  MB/sec
//    StringVsStringBuilder.concatenate_string:▒gc.alloc.rate.norm                 ss    5  11564404363,600 ▒ 780539487,440    B/op
//    StringVsStringBuilder.concatenate_string:▒gc.churn.PS_Eden_Space             ss    5         7408,527 ▒       525,688  MB/sec
//    StringVsStringBuilder.concatenate_string:▒gc.churn.PS_Eden_Space.norm        ss    5  11589028107,000 ▒ 782842274,930    B/op
//    StringVsStringBuilder.concatenate_string:▒gc.churn.PS_Survivor_Space         ss    5            3,919 ▒         0,441  MB/sec
//    StringVsStringBuilder.concatenate_string:▒gc.churn.PS_Survivor_Space.norm    ss    5      6128956,800 ▒    255731,800    B/op
//    StringVsStringBuilder.concatenate_string:▒gc.count                           ss    5          343,000                  counts
//    StringVsStringBuilder.concatenate_string:▒gc.time                            ss    5         1510,000                      ms

//    StringVsStringBuilder.concatenate_stringbuilder                              ss    5           47,133 ▒        74,173   ms/op
//    StringVsStringBuilder.concatenate_stringbuilder:▒gc.alloc.rate               ss    5           74,716 ▒        29,054  MB/sec
//    StringVsStringBuilder.concatenate_stringbuilder:▒gc.alloc.rate.norm          ss    5      6807175,400 ▒      7976,934    B/op
//    StringVsStringBuilder.concatenate_stringbuilder:▒gc.count                    ss    5              ? 0                  counts
}
