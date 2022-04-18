package baseball;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballMachine {

  private static BaseballMachine INSTANCE = new BaseballMachine();

  private Integer[] positions = new Integer[10];

  private BaseballMachine() {
  }

  public static BaseballMachine getInstance() {
    return INSTANCE;
  }

  public void initialize() {
    Arrays.fill(positions, 0);

    for (int i = 1; i < 4; ++i) {
      int randNum = Randoms.pickNumberInRange(1, 9);
      this.positions[randNum] = i;
    }
  }

  public void play() {
    this.initialize();

    while (true) {
      ScreenManager.requireNumbers();
      Judgement judgement = judge(ConsoleManager.readThree());
      ScreenManager.display(judgement);

      if (judgement.getStrikeCount() == 3) {
        ScreenManager.completion();
        break;
      }
    }
  }

  public boolean isContinued() {
    ScreenManager.askContinued();

    int choice = ConsoleManager.readOne();
    if (choice == 1) {
      return true;
    }

    if (choice == 2) {
      return false;
    }

    throw new IllegalArgumentException("1 또는 2만 입력가능합니다.");
  }

  private Judgement judge(Integer[] input) {
    for (int i = 0; i < 3; ++i) {
      if (input[i] < 1) {
        throw new IllegalArgumentException("1보다 작은 숫자는 입력할 수 없습니다.");
      }
    }

    return _judge(input);
  }

  private Judgement _judge(Integer[] input) {
    int strikeCount = 0, ballCount = 0, nothingCount = 0;

    for (int i = 0; i < 3; ++i) {
      if (this.positions[input[i]] == 0) {
        ++nothingCount;
        continue;
      }

      if (this.positions[input[i]] == i + 1) {
        ++strikeCount;
        continue;
      }
      ++ballCount;
    }

    return new Judgement(strikeCount, ballCount, nothingCount);
  }
}
