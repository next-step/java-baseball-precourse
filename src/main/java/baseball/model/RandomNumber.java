package baseball.model;

import nextstep.utils.Randoms;

import java.util.*;

public class RandomNumber {
  public static final int SIZE = 3;
  private final List<Integer> number;

  private RandomNumber() {
    number = generateNumber();
  }

  private List<Integer> generateNumber() {
    Set<Integer> numberSet = new LinkedHashSet<>();
    while (numberSet.size() != SIZE) {
      numberSet.add(Randoms.pickNumberInRange(1, 9));
    }

    return new ArrayList<>(numberSet);
  }

  public static RandomNumber makeRandomNumber() {
    return new RandomNumber();
  }

  public List<Integer> getNumber() {
    return number;
  }
}
