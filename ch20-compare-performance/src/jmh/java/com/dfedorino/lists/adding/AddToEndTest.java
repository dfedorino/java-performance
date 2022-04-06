package com.dfedorino.lists.adding;

import com.dfedorino.BasePerformanceTest;
import com.dfedorino.lists.Book;
import com.dfedorino.state.ArrayListState;
import com.dfedorino.state.LinkedListState;
import com.dfedorino.state.VectorState;
import org.openjdk.jmh.annotations.Benchmark;

import static com.dfedorino.TestConstants.ELEMENTS_TO_PROCESS;

public class AddToEndTest extends BasePerformanceTest {

    @Benchmark
    public void add_to_end_arraylist(ArrayListState state) {
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            state.prefilledArrayList.add(new Book("Title", "Author", i + 0.99));
        }
    }

    @Benchmark
    public void add_to_end_vector(VectorState state) {
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            state.prefilledVector.add(new Book("Title", "Author", i + 0.99));
        }
    }

    @Benchmark
    public void add_to_end_linkedlist(LinkedListState state) {
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            state.prefilledLinkedList.add(new Book("Title", "Author", i + 0.99));
        }
    }

//    Benchmark                           Mode  Cnt  Score    Error  Units
//    AddToEndTest.add_to_end_arraylist   avgt   25  0,002 ▒  0,001   s/op
//    AddToEndTest.add_to_end_linkedlist  avgt   25  0,005 ▒  0,001   s/op
//    AddToEndTest.add_to_end_vector      avgt   25  0,002 ▒  0,001   s/op
}
