package textjustification;

import java.util.List;

public class TextJustificationRecursion extends TextJustificationBase {

    public TextJustificationRecursion(List<Integer> words) {
        super(words);
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
            badness = currentBadness < badness ? currentBadness : badness;
            n+=1;
        }

        return badness;
    }
}