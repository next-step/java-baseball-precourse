package baseball.constant.status;

import java.util.ArrayList;
import java.util.List;

public enum GameStatus {
  START(1), END(2);

  private int value;

  GameStatus(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static List<Integer> getValueList() {
    List<Integer> valueList = new ArrayList<>();
    for (GameStatus gameStatus : GameStatus.values()) {
      valueList.add(gameStatus.getValue());
    }

    return valueList;
  }
}
