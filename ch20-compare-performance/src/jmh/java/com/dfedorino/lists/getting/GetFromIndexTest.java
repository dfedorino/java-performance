package com.dfedorino.lists.getting;

import com.dfedorino.BasePerformanceTest;
import com.dfedorino.state.ArrayListState;
import com.dfedorino.state.LinkedListState;
import com.dfedorino.state.VectorState;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.Random;
import java.util.stream.IntStream;

public class GetFromIndexTest extends BasePerformanceTest {

    @State(Scope.Thread)
    public static class IndexesState {
        int[] indexes;

        @Setup(Level.Trial)
        public void setup() {
            Random random = new Random();
            indexes = IntStream.generate(() -> random.nextInt(1000))
                    .limit(1000)
                    .toArray();
        }
    }

    @Benchmark
    public void read_from_arbitrary_index_arraylist(ArrayListState listState, IndexesState indexesState) {
        for (int index : indexesState.indexes) {
            listState.prefilledArrayList.get(index);
        }
    }

    @Benchmark
    public void read_from_arbitrary_index_vector(VectorState listState, IndexesState indexesState) {
        for (int index : indexesState.indexes) {
            listState.prefilledVector.get(index);
        }
    }

    @Benchmark
    public void read_from_arbitrary_index_linkedlist(LinkedListState listState, IndexesState indexesState) {
        for (int index : indexesState.indexes) {
            listState.prefilledLinkedList.get(index);
        }
    }

//    Benchmark                                               Mode  Cnt   Score    Error  Units
//    ReadFromIndexTest.read_from_arbitrary_index_arraylist   avgt   25  < 0,001            s/op
//    ReadFromIndexTest.read_from_arbitrary_index_linkedlist  avgt   25    0,001 ▒  0,001   s/op
//    ReadFromIndexTest.read_from_arbitrary_index_vector      avgt   25  < 0,001            s/op
}
