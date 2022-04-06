package com.dfedorino.state;

import com.dfedorino.lists.Book;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

import java.util.HashMap;
import java.util.Map;

import static com.dfedorino.TestConstants.ELEMENTS;

@State(Scope.Thread)
public class HashMapState {
    public Map<Integer, Book> prefilledHashMap;

    @Setup(Level.Iteration)
    public void setup() {
        prefilledHashMap = new HashMap<>();
        for (int i = 0; i < ELEMENTS; i++) {
            prefilledHashMap.put(i, new Book("Title", "Author", i + 0.99));
        }
    }

    @TearDown(Level.Iteration)
    public void tearDown() {
        prefilledHashMap.clear();
    }
}
