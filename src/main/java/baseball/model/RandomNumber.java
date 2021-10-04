package baseball.model;

import nextstep.utils.Randoms;

import java.util.HashSet;

public class RandomNumber {
  public static final int SIZE = 3;
  private int[] numbers;

  private RandomNumber() {
    do {
      numbers = generateNumber();
    } while (!checkDuplicateNumber(numbers));
  }

  private boolean checkDuplicateNumber(int[] numbers) {
    HashSet<Integer> hashSet = new HashSet<>();
    for (int number : numbers) {
      hashSet.add(number);
    }

    if (hashSet.size() != SIZE) {
      return false;
    }

    return true;
  }

  private int[] generateNumber() {
    int[] randomNumbers = new int[SIZE];
    for (int i = 0; i < SIZE; i++) {
      randomNumbers[i] = Randoms.pickNumberInRange(1, 9);
    }
    return randomNumbers;
  }

  public static RandomNumber makeRandomNumber() {
    return new RandomNumber();
  }

  public int[] getNumbers() {
    return numbers;
  }
}
