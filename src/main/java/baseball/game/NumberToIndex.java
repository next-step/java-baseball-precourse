package baseball.game;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NumberToIndex {
    private Map<Integer, Integer> m = new HashMap<>();
    private int index = 0;

    public NumberToIndex() { }

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
