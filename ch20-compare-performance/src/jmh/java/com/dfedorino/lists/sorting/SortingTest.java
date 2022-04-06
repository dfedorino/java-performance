package com.dfedorino.lists.sorting;

import com.dfedorino.BasePerformanceTest;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static com.dfedorino.TestConstants.ELEMENTS;

public class SortingTest extends BasePerformanceTest {

    @State(Scope.Thread)
    public static class ArrayListState {
        List<Integer> randomNumbers;

        @Setup
        public void setup() {
            Random random = new Random();
            randomNumbers = IntStream.generate(() -> random.nextInt(ELEMENTS))
                    .limit(ELEMENTS)
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        }
    }

    @State(Scope.Thread)
    public static class LinkedListState {
        List<Integer> randomNumbers;

        @Setup
        public void setup() {
            Random random = new Random();
            randomNumbers = IntStream.generate(() -> random.nextInt(ELEMENTS))
                    .limit(ELEMENTS)
                    .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        }
    }

    @Benchmark
    public List<Integer> sort_arraylist(ArrayListState state) {
        List<Integer> randomNumbersCopy = new ArrayList<>(state.randomNumbers);
        randomNumbersCopy.sort(Comparator.comparingInt(a -> a));
        return randomNumbersCopy;
    }

    @Benchmark
    public List<Integer> sort_linkedlist(LinkedListState state) {
        List<Integer> randomNumbersCopy = new LinkedList<>(state.randomNumbers);
        randomNumbersCopy.sort(Comparator.comparingInt(a -> a));
        return randomNumbersCopy;
    }

    @Benchmark
    public List<Integer> collections_sort_arraylist(ArrayListState state) {
        List<Integer> randomNumbersCopy = new ArrayList<>(state.randomNumbers);
        Collections.sort(randomNumbersCopy);
        return randomNumbersCopy;
    }

    @Benchmark
    public List<Integer> collections_sort_linkedlist(LinkedListState state) {
        List<Integer> randomNumbersCopy = new LinkedList<>(state.randomNumbers);
        Collections.sort(randomNumbersCopy);
        return randomNumbersCopy;
    }

//    Benchmark                                    Mode  Cnt  Score   Error  Units
//    SortingListTest.collections_sort_arraylist   avgt   25  0,645 ▒ 0,008   s/op
//    SortingListTest.collections_sort_linkedlist  avgt   25  0,876 ▒ 0,011   s/op
//    SortingListTest.sort_arraylist               avgt   25  0,620 ▒ 0,004   s/op
//    SortingListTest.sort_linkedlist              avgt   25  0,878 ▒ 0,013   s/op
}
