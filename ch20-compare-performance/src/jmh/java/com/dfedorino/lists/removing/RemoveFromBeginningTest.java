package com.dfedorino.lists.removing;

import com.dfedorino.BasePerformanceTest;
import com.dfedorino.lists.Book;
import com.dfedorino.state.ArrayListState;
import com.dfedorino.state.LinkedListState;
import com.dfedorino.state.VectorState;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import static com.dfedorino.TestConstants.ELEMENTS_TO_PROCESS;

public class RemoveFromBeginningTest extends BasePerformanceTest {

    @Benchmark
    public void remove_from_beginning_arraylist(ArrayListState state) {
        List<Book> toBeCleared = new ArrayList<>(state.prefilledArrayList);
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            toBeCleared.remove(0);
        }
    }

    @Benchmark
    public void remove_from_beginning_vector(VectorState state) {
        List<Book> toBeCleared = new Vector<>(state.prefilledVector);
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            toBeCleared.remove(0);
        }
    }

    @Benchmark
    public void remove_from_beginning_linkedlist(LinkedListState state) {
        List<Book> toBeCleared = new LinkedList<>(state.prefilledLinkedList);
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            toBeCleared.remove(0);
        }
    }

//    Benchmark                                                 Mode  Cnt  Score   Error  Units
//    RemoveFromBeginningTest.remove_from_beginning_arraylist   avgt   25  3,273 ▒ 0,117   s/op
//    RemoveFromBeginningTest.remove_from_beginning_linkedlist  avgt   25  0,111 ▒ 0,101   s/op
//    RemoveFromBeginningTest.remove_from_beginning_vector      avgt   25  3,108 ▒ 0,055   s/op

}
