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

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Threads(Threads.MAX)
public class DoubleVsBigDecimal {

    @State(Scope.Thread)
    public static class Data {
        List<Double> doubles;
        List<BigDecimal> bigDecimalsFromDouble;
        List<BigDecimal> bigDecimalsFromString;
        @Param({"1000", "10000", "100000", "1000000"})
        private int numberOfElements;

        @Setup(Level.Trial)
        public void setup() {
            doubles = DoubleStream.iterate(1d, i -> i++)
                    .limit(numberOfElements)
                    .boxed()
                    .collect(Collectors.toList());

            bigDecimalsFromDouble = DoubleStream.iterate(1d, i -> i++)
                    .limit(numberOfElements)
                    .mapToObj(BigDecimal::new)
                    .collect(Collectors.toList());

            bigDecimalsFromString = DoubleStream.iterate(1d, i -> i++)
                    .limit(numberOfElements)
                    // string constructor of BigDecimal creates a double that exactly matches the provided string
                    .mapToObj(String::valueOf)
                    .map(BigDecimal::new)
                    .collect(Collectors.toList());
        }
    }

    @Benchmark
    public Double adding_double(Data d) {
        Double sum = 0.0;
        for (Double next : d.doubles) {
            sum += next;
        }
        return sum;
    }

    @Benchmark
    public BigDecimal adding_bigdecimal_from_double(Data d) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal next : d.bigDecimalsFromDouble) {
            sum = sum.add(next);
        }
        return sum;
    }

    @Benchmark
    public BigDecimal adding_bigdecimal_from_string(Data d) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal next : d.bigDecimalsFromString) {
            sum = sum.add(next);
        }
        return sum;
    }

//    Benchmark                                         (numberOfElements)  Mode  Cnt    Score     Error  Units
//    DoubleVsBigDecimal.adding_bigdecimal_from_double                1000    ss    5    3,043 ▒   4,766  ms/op
//    DoubleVsBigDecimal.adding_bigdecimal_from_double               10000    ss    5    8,399 ▒   9,024  ms/op
//    DoubleVsBigDecimal.adding_bigdecimal_from_double              100000    ss    5   22,519 ▒   8,473  ms/op
//    DoubleVsBigDecimal.adding_bigdecimal_from_double             1000000    ss    5  272,602 ▒  46,613  ms/op
//    DoubleVsBigDecimal.adding_bigdecimal_from_string                1000    ss    5    3,044 ▒   2,909  ms/op
//    DoubleVsBigDecimal.adding_bigdecimal_from_string               10000    ss    5   11,397 ▒  16,075  ms/op
//    DoubleVsBigDecimal.adding_bigdecimal_from_string              100000    ss    5   23,895 ▒   5,527  ms/op
//    DoubleVsBigDecimal.adding_bigdecimal_from_string             1000000    ss    5  267,167 ▒ 134,442  ms/op
//    DoubleVsBigDecimal.adding_double                                1000    ss    5    1,202 ▒   0,954  ms/op
//    DoubleVsBigDecimal.adding_double                               10000    ss    5    4,081 ▒   1,598  ms/op
//    DoubleVsBigDecimal.adding_double                              100000    ss    5   26,975 ▒  12,887  ms/op
//    DoubleVsBigDecimal.adding_double                             1000000    ss    5   48,266 ▒   8,314  ms/op
}
