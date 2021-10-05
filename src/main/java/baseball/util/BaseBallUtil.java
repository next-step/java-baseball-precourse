package baseball.util;

import java.util.*;

public class BaseBallUtil {
  public static Set<Integer> stringToIntSet(String number) {
    Set<Integer> numberSet = new LinkedHashSet<>();
    for (char num : number.toCharArray()) {
      numberSet.add(Character.getNumericValue(num));
    }

    return numberSet;
  }

  public static List<Integer> stringToIntList(String number) {
    List<Integer> numberList = new ArrayList<>();
    for (char num : number.toCharArray()) {
      numberList.add(Character.getNumericValue(num));
    }

    return numberList;
  }
}
