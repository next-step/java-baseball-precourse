package baseball.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DataConverter {
    public static List<Integer> stringToIntegerList(String source) {
        List<Integer> target = new ArrayList<>();
        addSourceToTarget(source, target);

        return target;
    }

    public static Set<Integer> stringToIntegerSet(String source) {
        Set<Integer> target = new LinkedHashSet<>();
        addSourceToTarget(source, target);

        return target;
    }

    private static <T extends Collection<Integer>> void addSourceToTarget(String source, T target) {
        for (char number : source.toCharArray()) {
            target.add(Character.getNumericValue(number));
        }
    }

    public static int stringToDigit(String source) {
        return Character.getNumericValue(source.charAt(0));
    }

    public static <T> List<T> setToList(Set<T> set) {
        List<T> list = new LinkedList<>();

        for (T element : set) {
            list.add(element);
        }

        return list;
    }
}