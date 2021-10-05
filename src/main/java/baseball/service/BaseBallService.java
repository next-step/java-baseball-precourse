package baseball.service;

import baseball.model.BaseBallCounter;
import baseball.model.RandomNumber;
import baseball.view.OutputView;

import static baseball.view.InputView.*;

public class BaseBallService {
  private static final int STRIKE = 3;
  private final RandomNumber randomNumber;
  private boolean isRunning;

  public BaseBallService(RandomNumber randomNumber) {
    this.randomNumber = randomNumber;
  }

  public void start() {
    isRunning = true;
    while (isRunning) {
      BaseBallCounter counter = new BaseBallCounter(numberInput());
      counter.count(randomNumber.getNumber());
      OutputView.printResult(counter);
      updateRunStatus(counter.getStrike());
    }
    OutputView.printEnd();
  }

  public void updateRunStatus(int strikeCount) {
    if (strikeCount == STRIKE) {
      isRunning = false;
    }
  }
}
