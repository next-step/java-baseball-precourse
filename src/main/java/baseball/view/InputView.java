package baseball.view;

import baseball.constant.message.InputMessage;
import nextstep.utils.Console;

import static baseball.constant.message.ErrorMessage.ERROR_INPUT_MESSAGE;
import static baseball.validation.BaseBallValidation.checkInputNumber;
import static baseball.validation.BaseBallValidation.checkRestartInputNumber;
import static baseball.constant.message.InputMessage.*;

public class InputView {


  public static String numberInput() {
    System.out.print(NUMBER_INPUT_MESSAGE);
    String inputSource = Console.readLine();

    if (checkInputNumber(inputSource)) {
      return inputSource;
    }
    System.out.print(ERROR_INPUT_MESSAGE);
    return numberInput();
  }

  public static String restartInput() {
    System.out.println(InputMessage.RESTART_INPUT_MESSAGE);
    String inputSource = Console.readLine();

    if (checkRestartInputNumber(inputSource)) {
      return inputSource;
    }

    System.out.println(ERROR_INPUT_MESSAGE);
    return restartInput();
  }
}
