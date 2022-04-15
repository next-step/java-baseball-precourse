package baseball.game;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static baseball.game.GameConfig.NUM_NUMBERS;

public class NumberToIndex {
    private Map<Integer, Integer> m = new HashMap<>();
    private int index = 0;

    public NumberToIndex() { }

    public NumberToIndex(String digits) {
        NumberToIndex parsed = parseAnswerFrom(digits);
        this.m = parsed.m;
        this.index = parsed.index;
    }

    private int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("can't parse " + s);
        }
    }

    private NumberToIndex parseAnswerFrom(String s) {
        NumberToIndex result = new NumberToIndex();

        for (String digit: s.split("")) {
            int parsedNum = parseInt(digit);
            result.put(parsedNum);
        }
        if (result.size() != NUM_NUMBERS) {
            throw new IllegalArgumentException("");
        }
        return result;
    }

    public Integer put(int num) {
        return m.put(num, index++);
    }

    public void putAll(List<Integer> numbers) {
        for (int num: numbers) {
            put(num);
        }
    }

    public int getIndexOf(int num) {
        return m.get(num);
    }

    public int size() {
        return m.size();
    }

    public boolean contains(int num) {
        return m.containsKey(num);
    }

    public Iterator<Integer> numberIterator() {
        return m.keySet().iterator();
    }

    public String toString() {
        return m.toString();
    }
}
