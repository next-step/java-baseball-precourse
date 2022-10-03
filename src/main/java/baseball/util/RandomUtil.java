package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomUtil {
  final static Integer START_NUMBER = 1;
  final static Integer END_NUMBER = 9;
  final static Integer NUMBER_LENGTH = 3;
  public static List<Integer> getRandomNumbers() {
    List<Integer> computerBalls = new ArrayList<>();
    for (int i = 0; i < NUMBER_LENGTH; i++) {
      computerBalls.add(getUniqueRandomNumber(computerBalls, START_NUMBER, END_NUMBER, i));
//      numbers[i] = getUniqueRandomNumber(numbers, start, end, i);
    }
    return computerBalls;
//    return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_LENGTH);
  }

  private static int getUniqueRandomNumber(List<Integer> computerBalls, int start, int end, int i) {
    int randomNumber = Randoms.pickNumberInRange(start, end);
    while (!isUnique(computerBalls, i, randomNumber)) {
      randomNumber = Randoms.pickNumberInRange(start, end);
    }
    return randomNumber;
  }

  private static Boolean isUnique(List<Integer> computerBalls, int i, int randomNumber) {
    for (int j = 0; j < i; j++) {
      if (computerBalls.get(j) == randomNumber) {
        return false;
      }
    }
    return true;
  }

}
