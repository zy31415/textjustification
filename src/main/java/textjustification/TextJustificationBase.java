package textjustification;

import java.util.List;

public abstract class TextJustificationBase {
    public static final int LINE_WIDTH = 80;

    public int calculateBadness(int lineLength) {

        if (lineLength <= LINE_WIDTH) {
            int d = LINE_WIDTH - lineLength;
            return cubic(d);
        }

        return Integer.MAX_VALUE;
    }

    private static int cubic(int a) {
        return a*a*a;
    }

    public abstract int optimize();

}