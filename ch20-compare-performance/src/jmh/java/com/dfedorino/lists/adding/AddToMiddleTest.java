package com.dfedorino.lists.adding;

import com.dfedorino.BasePerformanceTest;
import com.dfedorino.lists.Book;
import com.dfedorino.state.ArrayListState;
import com.dfedorino.state.LinkedListState;
import com.dfedorino.state.VectorState;
import org.openjdk.jmh.annotations.Benchmark;

import static com.dfedorino.TestConstants.ELEMENTS_TO_PROCESS;

public class AddToMiddleTest extends BasePerformanceTest {

    @Benchmark
    public void add_to_middle_arraylist(ArrayListState state) {
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            int middle = state.prefilledArrayList.size() / 2;
            state.prefilledArrayList.add(middle, new Book("Title", "Author", i + 0.99));
        }
    }

    @Benchmark
    public void add_to_middle_vector(VectorState state) {
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            int middle = state.prefilledVector.size() / 2;
            state.prefilledVector.add(middle, new Book("Title", "Author", i + 0.99));
        }
    }

    @Benchmark
    public void add_to_middle_linkedlist(LinkedListState state) {
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            int middle = state.prefilledLinkedList.size() / 2;
            state.prefilledLinkedList.add(middle, new Book("Title", "Author", i + 0.99));
        }
    }

//    Benchmark                                            Mode  Cnt  Score   Error  Units
//    AddToMiddlePerformanceTest.add_to_middle_arraylist   avgt   25  1,367 ▒ 0,094   s/op
//    AddToMiddlePerformanceTest.add_to_middle_linkedlist  avgt   25  8,806 ▒ 0,802   s/op
//    AddToMiddlePerformanceTest.add_to_middle_vector      avgt   25  1,325 ▒ 0,004   s/op
}
