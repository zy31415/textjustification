package textjustification;

import com.sun.tools.jdi.IntegerValueImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextJustificationRecursion extends TextJustificationBase {

    protected List<Integer> words;
    protected Map<Integer, Integer> breaks = new HashMap<>();

    public TextJustificationRecursion(List<Integer> words) {
        this.words = words;
    }

    public int optimize() {
        return optimize(0);
    }

    int optimize(int nextLine) {
        // Assuming no word length is greater than LINE_WIDTH.

        // base case
        if (nextLine >= words.size())
            return 0;

        int currentLineLen = 0;
        int badness = Integer.MAX_VALUE;
        int n = nextLine;

        while (n < words.size()) {
            // append a space if current line is not empty
            if (currentLineLen != 0)
                currentLineLen += 1;
            currentLineLen += words.get(n);

            if (currentLineLen > LINE_WIDTH)
                break;

            int currentBadness = calculateBadness(currentLineLen) + optimize(n+1);

            if (currentBadness < badness) {
                badness = currentBadness;
                breaks.put(nextLine, n+1);
            }

            n+=1;
        }

        return badness;
    }

    public List<Integer> getBreaks() {
        List<Integer> breakList = new ArrayList<>();

        Integer pos = 0;

        while (breaks.containsKey(pos) && pos < words.size()) {
            breakList.add(pos);
            pos = breaks.get(pos);
        }

        return breakList;
    }

    public void printBreaks() {
        for (Integer b : getBreaks()){
            System.out.println(String.format("%s", b));
        }
    }

    public void print() {

        int n = 0;
        int br = breaks.get(n);
        int promptPos = 0;
        for(; n < words.size(); n++) {
            // Time to break
            if (n == br) {
                while (promptPos<LINE_WIDTH) {
                    System.out.print(' ');
                    promptPos++;
                }
                System.out.print("||");

                System.out.print('\n');
                br = breaks.get(n);
                promptPos = 0;
            }

            // Print a word
            for (int i=0; i<words.get(n); i++){
                System.out.print('#');
                promptPos++;
            }

            if (n != br) {
                System.out.print(' ');
                promptPos++;
            }

        }
    }
}