package textjustification;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TextJustificationRecursionTest {
    @Test
    public void testOptimize() {
        List<Integer> words = new ArrayList<>();
        words.add(50);
        words.add(29);
        words.add(1);

        TextJustificationRecursion just = new TextJustificationRecursion(words);
        int badness = just.optimize();

        assertEquals(144649, badness);

        just.printBreaks();

    }
}