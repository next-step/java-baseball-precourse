package baseball;

import java.util.List;

import static java.util.Arrays.asList;

public class Number {
    private final List<Integer> values;

    public Number(List<Integer> values) {
        this.values = values;
    }

    public Number(Integer... values) {
        this(asList(values));
    }

    public String getValue() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer value : this.values) {
            stringBuilder.append(value);
        }
        return stringBuilder.toString();
    }
}
