package baseball.game;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import baseball.game.util.BaseBallGameUtil;

public class BaseBallGame {

  //숫자 범위
  private static final int START_RANGE = 1;
  private static final int END_RANGE = 9;
  //숫자 length
  static final int NUMBER_COUNT = 3;
  //게임 진행 관련
  private static final int NEW_GAME = 1;
  private static final int QUIT_GAME = 2;

  private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
  private static final String SUCCESS_MESSAGE = NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
  private static final String NEW_GAME_CHECK_MESSAGE =
      "게임을 새로 시작하려면 " + NEW_GAME + ", 종료하려면 " + QUIT_GAME + "를 입력하세요.";
  int[] number = new int[NUMBER_COUNT];


  public BaseBallGame() {
    int nowRandomNum;
    int nowNumberIndex = 0;
    while (nowNumberIndex < NUMBER_COUNT) {
      nowRandomNum = pickNumberInRange(START_RANGE, END_RANGE);//this.getRandomNumber();
      if (!BaseBallGameUtil.isDuplications(number, nowRandomNum)) {
        number[nowNumberIndex++] = nowRandomNum;
      }
    }
  }

  BaseBallGame(String str) {
    for (int i = 0; i < BaseBallGame.NUMBER_COUNT; i++) {
      number[i] = Integer.parseInt(str.charAt(i) + "");
    }
  }

  public static void init(BaseBallGame baseBallGame) {
    BaseBallGame ballGame = BaseBallGame.getInput();

    BaseBallHint hint = new BaseBallHint();
    hint.compareAnswer(ballGame, baseBallGame);
    hint.showResult();

    if (hint.strike != BaseBallGame.NUMBER_COUNT) {
      BaseBallGame.init(baseBallGame);
      return;
    }

    int newGameAnswer = BaseBallGame.checkNewGameStart();
    if (newGameAnswer == BaseBallGame.NEW_GAME) {
      baseBallGame = new BaseBallGame();
      BaseBallGame.init(baseBallGame);
    }
  }

  private static BaseBallGame getInput() {
    System.out.print(GET_NUMBER_MESSAGE);
    String userInput = readLine();
    BaseBallGame.checkInputValue(userInput);

    return new BaseBallGame(userInput);
  }

  private static int checkNewGameStart() {
    System.out.println(SUCCESS_MESSAGE);
    System.out.println(NEW_GAME_CHECK_MESSAGE);

    String newGameAnswer = readLine();
    return BaseBallGame.getNewGameAnswerNumber(newGameAnswer);
  }

  private static int getNewGameAnswerNumber(String str) {
    int intValue;
    try {
      intValue = Integer.parseInt(str);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException();
    }

    if (intValue != 1 && intValue != 2) {
      throw new IllegalArgumentException();
    }

    return intValue;
  }

  public String toString() {
    return "number: " + this.number[0] + this.number[1] + this.number[2];
  }

  static void checkInputValue(final String str) {
    if (!BaseBallGame.checkInputLength(str)) {
      throw new IllegalArgumentException();
    }
    if (!BaseBallGame.checkInputNumber(str)) {
      throw new IllegalArgumentException();
    }
    if (!BaseBallGame.checkEqualNumber(str)) {
      throw new IllegalArgumentException();
    }
  }


  static boolean checkInputLength(final String str) {
    return str.length() == BaseBallGame.NUMBER_COUNT;
  }

  static boolean checkInputNumber(String str) {
    try {
      int numberValue = Integer.parseInt(str);
    } catch (NumberFormatException e) {
      return false;
    }
    char[] numberArray = BaseBallGameUtil.stringToCharArr(str);
    return !BaseBallGameUtil.isDuplications(numberArray, '0');
  }


  static boolean checkEqualNumber(String str) {
    char[] checkEqual = new char[str.length()];
    char[] word = BaseBallGameUtil.stringToCharArr(str);

    for (int i = 0; i < str.length(); i++) {
      if (BaseBallGameUtil.isDuplications(checkEqual, word[i])) {
        return false;
      }
      checkEqual[i] = word[i];
    }

    return true;
  }
}
