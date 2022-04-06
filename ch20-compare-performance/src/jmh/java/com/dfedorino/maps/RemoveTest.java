package com.dfedorino.maps;

import com.dfedorino.BasePerformanceTest;
import com.dfedorino.lists.Book;
import com.dfedorino.state.HashMapState;
import com.dfedorino.state.TreeMapState;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.dfedorino.TestConstants.ELEMENTS_TO_PROCESS;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class RemoveTest extends BasePerformanceTest {

    @Benchmark
    public void remove_hashmap(HashMapState state) {
        Map<Integer, Book> toBeCleared = new HashMap<>(state.prefilledHashMap);
        for (int i = ELEMENTS_TO_PROCESS; i >= 0; i--) {
            toBeCleared.remove(i);
        }
    }

    @Benchmark
    public void remove_treemap(TreeMapState state) {
        Map<Integer, Book> toBeCleared = new HashMap<>(state.prefilledTreeMap);
        for (int i = ELEMENTS_TO_PROCESS; i >= 0; i--) {
            toBeCleared.remove(i);
        }
    }

//    Benchmark                  Mode  Cnt    Score     Error  Units
//    RemoveTest.remove_hashmap  avgt   25  424,540 ▒ 517,392  ms/op
//    RemoveTest.remove_treemap  avgt   25  159,372 ▒  94,763  ms/op
}
