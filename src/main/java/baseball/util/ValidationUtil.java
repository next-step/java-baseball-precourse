package baseball.util;

import java.util.HashSet;
import java.util.List;

public class ValidationUtil {

  final static int MIN_VALUE = 0;
  final static int MAX_VALUE = 10;

  final static int MAX_LENGTH = 3;
  public static boolean isNumber(int value) {

    return MIN_VALUE < value && value < MAX_VALUE;
  }

  public static boolean isLength(List<Integer> valueList) {

    return valueList.size() == MAX_LENGTH;
  }

  public static boolean isLength(String value) {

    return value.length() == MAX_LENGTH;
  }


  public static boolean isDuplication(List<Integer> valueList) {

    return new HashSet<>(valueList).size() == valueList.size();
  }

}
