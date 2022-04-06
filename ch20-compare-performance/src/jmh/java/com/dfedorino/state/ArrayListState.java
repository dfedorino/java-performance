package com.dfedorino.state;

import com.dfedorino.lists.Book;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

import java.util.ArrayList;
import java.util.List;

import static com.dfedorino.TestConstants.ELEMENTS;

@State(Scope.Thread)
public class ArrayListState {
    public List<Book> prefilledArrayList;

    @Setup(Level.Iteration)
    public void setup() {
        prefilledArrayList = new ArrayList<>();
        for (int i = 0; i < ELEMENTS; i++) {
            prefilledArrayList.add(new Book("Title", "Author", i + 0.99));
        }
    }

    @TearDown(Level.Iteration)
    public void tearDown() {
        prefilledArrayList.clear();
    }
}
