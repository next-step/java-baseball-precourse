package baseball.view;

import baseball.constant.message.OutputMessage;
import baseball.model.BaseBallCounter;

public class OutputView {
  public static void printResult(BaseBallCounter baseBallCounter) {
    printBaseBallScore(baseBallCounter.hasStrike(), OutputMessage.STRIKE_OUTPUT_MESSAGE, baseBallCounter.getStrike());

    printMessageByCondition(baseBallCounter.hasStrike() && baseBallCounter.hasBall(), " ");

    printBaseBallScore(baseBallCounter.hasBall(), OutputMessage.BALL_OUTPUT_MESSAGE, baseBallCounter.getBall());

    printMessageByCondition(baseBallCounter.hasNothing(), OutputMessage.NOTHING_OUTPUT_MESSAGE);

    System.out.println("");
  }

  private static void printMessageByCondition(boolean b, String s) {
    if (b) {
      System.out.print(s);
    }
  }

  private static void printBaseBallScore(boolean b, String outputMessage, int baseBallScore) {
    if (b) {
      System.out.printf(outputMessage, baseBallScore);
    }
  }

  public static void printEnd() {
    System.out.println(OutputMessage.END_OUTPUT_MESSAGE);
  }
}
