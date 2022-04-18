package baseball;

public class BaseBallMessage {

  public static final String STRIKE = "스트라이크";
  public static final String NUMBER_THREE = "3";
  public static final String GAME_OVER = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
  public static final String BALL = "볼";
  public static final String END_OR_NEW = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

  public static void print3Strike() {
    printMessage(NUMBER_THREE + STRIKE);
    printMessage(NUMBER_THREE + GAME_OVER);
  }

  public static void printNothing() {
    printMessage("낫싱");
  }

  public static void printBallStrike(int ballNumber, int strikeNumber) {
    if (ballNumber != 0 && strikeNumber == 0) {
      printMessage(ballNumber + BALL);
    }

    if (ballNumber == 0 && strikeNumber != 0) {
      printMessage(strikeNumber + STRIKE);
    }

    printMessage(ballNumber + BALL + " " + strikeNumber + STRIKE);
  }

  private static void printMessage(String ballNumber) {
    System.out.println(ballNumber);
  }

  public static void printEndOrNewMessage() {
    printMessage(END_OR_NEW);
  }

}
