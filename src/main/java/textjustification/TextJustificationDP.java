package textjustification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextJustificationDP extends TextJustificationRecursion {

    private Map<Integer, Integer> memo = new HashMap<>();

    public TextJustificationDP(List<Integer> words) {
        super(words);
    }

    @Override
    int optimize(int nextLine) {
        if (!memo.containsKey(nextLine))
            memo.put(nextLine, super.optimize(nextLine));
        return memo.get(nextLine);
    }

}