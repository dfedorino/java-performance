package com.dfedorino.lists.removing;

import com.dfedorino.BasePerformanceTest;
import com.dfedorino.lists.Book;
import com.dfedorino.state.ArrayListState;
import com.dfedorino.state.LinkedListState;
import com.dfedorino.state.VectorState;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.ArrayList;
import java.util.List;

import static com.dfedorino.TestConstants.ELEMENTS_TO_PROCESS;

public class RemoveFromMiddleTest extends BasePerformanceTest {

    @Benchmark
    public void remove_from_middle_arraylist(ArrayListState state) {
        List<Book> toBeCleared = new ArrayList<>(state.prefilledArrayList);
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            int middle = state.prefilledArrayList.size() / 2;
            toBeCleared.remove(middle);
        }
    }

    @Benchmark
    public void remove_from_middle_vector(VectorState state) {
        List<Book> toBeCleared = new ArrayList<>(state.prefilledVector);
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            int middle = state.prefilledVector.size() / 2;
            toBeCleared.remove(middle);
        }
    }

    @Benchmark
    public void remove_from_middle_linkedlist(LinkedListState state) {
        List<Book> toBeCleared = new ArrayList<>(state.prefilledLinkedList);
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            int middle = state.prefilledLinkedList.size() / 2;
            toBeCleared.remove(middle);
        }
    }

//    Benchmark                                           Mode  Cnt  Score   Error  Units
//    RemoveFromMiddleTest.remove_from_middle_arraylist   avgt   25  1,330 ▒ 0,021   s/op
//    RemoveFromMiddleTest.remove_from_middle_linkedlist  avgt   25  1,286 ▒ 0,020   s/op
//    RemoveFromMiddleTest.remove_from_middle_vector      avgt   25  1,322 ▒ 0,009   s/op
}
