package baseball.controller;

import baseball.constant.status.GameStatus;
import baseball.model.RandomNumber;
import baseball.service.BaseBallService;
import baseball.view.InputView;

public class BaseBallController {
  public static void run() {
    do {
      RandomNumber randomNumber = RandomNumber.makeRandomNumber();
      BaseBallService baseBallService = new BaseBallService(randomNumber);

      baseBallService.start();
    } while (restartOrExit());
  }

  public static boolean restartOrExit() {
    if (Integer.parseInt(InputView.restartInput()) == GameStatus.START.getValue()) {
      return true;
    }

    return false;
  }
}
