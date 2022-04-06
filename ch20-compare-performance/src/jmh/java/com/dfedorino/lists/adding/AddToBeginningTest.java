package com.dfedorino.lists.adding;

import com.dfedorino.BasePerformanceTest;
import com.dfedorino.lists.Book;
import com.dfedorino.state.ArrayListState;
import com.dfedorino.state.LinkedListState;
import com.dfedorino.state.VectorState;
import org.openjdk.jmh.annotations.Benchmark;

import static com.dfedorino.TestConstants.ELEMENTS_TO_PROCESS;

public class AddToBeginningTest extends BasePerformanceTest {

    @Benchmark
    public void add_to_beginning_arraylist(ArrayListState state) {
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            state.prefilledArrayList.add(0, new Book("Title", "Author", i + 0.99));
        }
    }

    @Benchmark
    public void add_to_beginning_vector(VectorState state) {
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            state.prefilledVector.add(0, new Book("Title", "Author", i + 0.99));
        }
    }

    @Benchmark
    public void add_to_beginning_linkedlist(LinkedListState state) {
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            state.prefilledLinkedList.add(0, new Book("Title", "Author", i + 0.99));
        }
    }

//    Benchmark                                       Mode  Cnt  Score   Error  Units
//    AddToBeginningTest.add_to_beginning_arraylist   avgt   25  3,096 ▒ 0,044   s/op
//    AddToBeginningTest.add_to_beginning_linkedlist  avgt   25  0,006 ▒ 0,001   s/op
//    AddToBeginningTest.add_to_beginning_vector      avgt   25  3,265 ▒ 0,127   s/op
}
