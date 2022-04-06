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

public class RemoveFromEndTest extends BasePerformanceTest {

    @Benchmark
    public void remove_from_end_arraylist(ArrayListState state) {
        List<Book> toBeCleared = new ArrayList<>(state.prefilledArrayList);
        int end = state.prefilledArrayList.size() - 1;
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            toBeCleared.remove(end);
            end--;
        }
    }

    @Benchmark
    public void remove_from_end_vector(VectorState state) {
        List<Book> toBeCleared = new ArrayList<>(state.prefilledVector);
        int end = state.prefilledVector.size() - 1;
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            toBeCleared.remove(end);
            end--;
        }
    }

    @Benchmark
    public void remove_from_end_linkedlist(LinkedListState state) {
        List<Book> toBeCleared = new ArrayList<>(state.prefilledLinkedList);
        int end = state.prefilledLinkedList.size() - 1;
        for (int i = 0; i < ELEMENTS_TO_PROCESS; i++) {
            toBeCleared.remove(end);
            end--;
        }
    }

//    Benchmark                                     Mode  Cnt  Score   Error  Units
//    RemoveFromEndTest.removeFromEnd_arraylist     avgt   25  0,008 ▒ 0,001   s/op
//    RemoveFromEndTest.removeFromEnd_vector        avgt   25  0,007 ▒ 0,001   s/op
//    RemoveFromEndTest.remove_from_end_linkedlist  avgt   25  0,030 ▒ 0,002   s/op
}
