package com.dfedorino.state;

import com.dfedorino.lists.Book;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

import java.util.Map;
import java.util.TreeMap;

import static com.dfedorino.TestConstants.ELEMENTS;

@State(Scope.Thread)
public class TreeMapState {
    public Map<Integer, Book> prefilledTreeMap;

    @Setup(Level.Iteration)
    public void setup() {
        prefilledTreeMap = new TreeMap<>();
        for (int i = 0; i < ELEMENTS; i++) {
            prefilledTreeMap.put(i, new Book("Title", "Author", i + 0.99));
        }
    }

    @TearDown(Level.Iteration)
    public void tearDown() {
        prefilledTreeMap.clear();
    }
}
