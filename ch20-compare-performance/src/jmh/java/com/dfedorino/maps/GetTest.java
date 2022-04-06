package com.dfedorino.maps;

import com.dfedorino.BasePerformanceTest;
import com.dfedorino.state.HashMapState;
import com.dfedorino.state.TreeMapState;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;

import static com.dfedorino.TestConstants.ELEMENTS;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class GetTest extends BasePerformanceTest {

    @Benchmark
    public void get_hashmap(HashMapState state) {
        for (int i = ELEMENTS - 1; i >= 0; i--) {
            state.prefilledHashMap.get(i);
        }
    }

    @Benchmark
    public void get_treemap(TreeMapState state) {
        for (int i = ELEMENTS - 1; i >= 0; i--) {
            state.prefilledTreeMap.get(i);
        }
    }

//    Benchmark            Mode  Cnt    Score     Error  Units
//    GetTest.get_hashmap  avgt   25   83,198 ▒  19,878  ms/op
//    GetTest.get_treemap  avgt   25  363,535 ▒ 100,888  ms/op

}
