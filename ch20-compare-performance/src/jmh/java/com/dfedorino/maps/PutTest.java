package com.dfedorino.maps;

import com.dfedorino.BasePerformanceTest;
import com.dfedorino.lists.Book;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import static com.dfedorino.TestConstants.ELEMENTS;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class PutTest extends BasePerformanceTest {

    @Benchmark
    public void put_default_size_and_factor_hashmap() {
        Map<Integer, Book> defaultSizeAndFactorHashMap = new HashMap<>();
        for (int i = 0; i < ELEMENTS; i++) {
            defaultSizeAndFactorHashMap.put(i, new Book("Title", "Author", i + 0.99));
        }
    }

    @Benchmark
    public void put_defined_size_and_factor_hashmap() {
        Map<Integer, Book> definedSizeAndFactorHashMap = new HashMap<>(ELEMENTS, 0.9f);
        for (int i = 0; i < ELEMENTS; i++) {
            definedSizeAndFactorHashMap.put(i, new Book("Title", "Author", i + 0.99));
        }
    }

    @Benchmark
    public void put_treemap() {
        Map<Integer, Book> defaultSizeAndFactorHashMap = new TreeMap<>();
        for (int i = 0; i < ELEMENTS; i++) {
            defaultSizeAndFactorHashMap.put(i, new Book("Title", "Author", i + 0.99));
        }
    }

//    Benchmark                                    Mode  Cnt     Score     Error  Units
//    PutTest.put_default_size_and_factor_hashmap  avgt   25  1889,370 ▒ 874,313  ms/op
//    PutTest.put_defined_size_and_factor_hashmap  avgt   25  1093,741 ▒ 167,888  ms/op
//    PutTest.put_treemap                          avgt   25   949,045 ▒  48,986  ms/op

}
