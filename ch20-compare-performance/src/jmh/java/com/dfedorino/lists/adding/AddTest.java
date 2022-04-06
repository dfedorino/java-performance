package com.dfedorino.lists.adding;

import com.dfedorino.BasePerformanceTest;
import com.dfedorino.lists.Book;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import static com.dfedorino.TestConstants.ELEMENTS;

public class AddTest extends BasePerformanceTest {

    @Benchmark
    public void add_default_size_arraylist() {
        List<Book> defaultSizeArrayList = new ArrayList<>();
        for (int i = 0; i < ELEMENTS; i++) {
            defaultSizeArrayList.add(new Book("Title", "Author", i + 0.99));
        }
    }

    @Benchmark
    public void add_defined_size_arraylist() {
        List<Book> definedSizeArrayList = new ArrayList<>(ELEMENTS);
        for (int i = 0; i < ELEMENTS; i++) {
            definedSizeArrayList.add(new Book("Title", "Author", i + 0.99));
        }
    }

    @Benchmark
    public void add_default_size_vector() {
        List<Book> defaultSizeArrayList = new Vector<>();
        for (int i = 0; i < ELEMENTS; i++) {
            defaultSizeArrayList.add(new Book("Title", "Author", i + 0.99));
        }
    }

    @Benchmark
    public void add_defined_size_vector() {
        List<Book> definedSizeArrayList = new Vector<>(ELEMENTS);
        for (int i = 0; i < ELEMENTS; i++) {
            definedSizeArrayList.add(new Book("Title", "Author", i + 0.99));
        }
    }

    @Benchmark
    public void add_linkedlist() {
        List<Book> linkedList = new LinkedList<>();
        for (int i = 0; i < ELEMENTS; i++) {
            linkedList.add(new Book("Title", "Author", i + 0.99));
        }
    }

//    Benchmark                           Mode  Cnt  Score   Error  Units
//    AddTest.add_default_size_arraylist  avgt   25  0,073 ▒ 0,002   s/op
//    AddTest.add_default_size_vector     avgt   25  0,070 ▒ 0,003   s/op
//    AddTest.add_defined_size_arraylist  avgt   25  0,054 ▒ 0,003   s/op
//    AddTest.add_defined_size_vector     avgt   25  0,053 ▒ 0,002   s/op
//    AddTest.add_linkedlist              avgt   25  0,162 ▒ 0,012   s/op

}
