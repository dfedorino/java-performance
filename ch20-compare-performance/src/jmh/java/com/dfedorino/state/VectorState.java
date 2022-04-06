package com.dfedorino.state;

import com.dfedorino.lists.Book;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

import java.util.List;
import java.util.Vector;

import static com.dfedorino.TestConstants.ELEMENTS;

@State(Scope.Thread)
public class VectorState {
    public List<Book> prefilledVector;

    @Setup(Level.Iteration)
    public void setup() {
        prefilledVector = new Vector<>();
        for (int i = 0; i < ELEMENTS; i++) {
            prefilledVector.add(new Book("Title", "Author", i + 0.99));
        }
    }

    @TearDown(Level.Iteration)
    public void tearDown() {
        prefilledVector.clear();
    }
}
