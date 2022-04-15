package baseball.game;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static baseball.game.GameConfig.*;

public class NumberToIndex {
    private Map<Integer, Integer> m = new HashMap<>();
    private int index = 0;

    public NumberToIndex() { }

    public NumberToIndex(String s) {
        NumberToIndex parsed = parseAnswerFrom(s);
        this.m = parsed.m;
        this.index = parsed.index;
    }

    private int parseInt(String s) {
        int num;
        try {
            num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("can't parse " + s);
        }
        if (num < DIGIT_START || num > DIGIT_END) {
            throw new IllegalArgumentException("input must be between " + DIGIT_START + " and " + DIGIT_END);
        }
        return num;
    }

    private NumberToIndex parseAnswerFrom(String s) {
        NumberToIndex result = new NumberToIndex();

        for (String stringNumber: s.split("")) {
            int parsed = parseInt(stringNumber);
            result.put(parsed);
        }
        if (result.size() != NUM_DIGITS) {
            throw new IllegalArgumentException(NUM_DIGITS + " different digits are required");
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
