package baseball.model;

import java.util.List;
import java.util.Objects;

import static baseball.util.BaseBallUtil.stringToIntList;

public class BaseBallCounter {
  private final List<Integer> userNumber;
  private int strike;
  private int ball;

  public BaseBallCounter(String userNumber) {
    this(stringToIntList(userNumber));
  }

  public BaseBallCounter(List<Integer> userNumber) {
    this.userNumber = userNumber;
  }

  public void count(List<Integer> computerNumber) {
    countBall(computerNumber);
    countStrike(computerNumber);
  }

  private void countBall(List<Integer> computerNumber) {
    for (int i = 0; i < userNumber.size(); i++) {
      calculateBall(computerNumber, i);
    }
  }

  private void calculateBall(List<Integer> computerNumber, int userNumberIndex) {
    for (int i = 0; i < computerNumber.size(); i++) {
      countValidBall(computerNumber, userNumberIndex, i);
    }
  }

  private void countValidBall(List<Integer> computerNumber, int userNumberIndex, int computerNumberIndex) {
    if (userNumberIndex == computerNumberIndex) {
      return;
    }

    if (Objects.equals(userNumber.get(userNumberIndex), computerNumber.get(computerNumberIndex))) {
      ball += 1;
    }
  }

  private void countStrike(List<Integer> computerNumber) {
    for (int i = 0; i < userNumber.size(); i++) {
      strike += calculateStrike(userNumber, computerNumber, i);
    }
  }

  private int calculateStrike(List<Integer> userNumber, List<Integer> computerNumber, int index) {
    if (Objects.equals(userNumber.get(index), computerNumber.get(index))) {
      return 1;
    }
    return 0;
  }

  public List<Integer> getUserNumber() {
    return userNumber;
  }

  public int getBall() {
    return ball;
  }

  public int getStrike() {
    return strike;
  }

  public boolean hasBall() {
    return ball > 0;
  }

  public boolean hasStrike() {
    return strike >0;
  }

  public boolean hasNothing() {
    return ball == 0 && strike == 0;
  }
}
