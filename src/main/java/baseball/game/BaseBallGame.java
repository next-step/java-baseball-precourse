package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.util.Strings;
import org.junit.platform.commons.util.StringUtils;

import static camp.nextstep.edu.missionutils.Console.readLine;

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


  public void startGatme() {
    //숫자야구 값 세팅
    number = new int[NUMBER_COUNT];
    int nowRandomNum;
    int nowNumberIndex = 0;

    while (nowNumberIndex < NUMBER_COUNT) {
      nowRandomNum = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
      if (!checkArrayValue(number, nowRandomNum)) {//값이 중복 되지 않도록
        number[nowNumberIndex++] = nowRandomNum;
      }
    }
    getInputValue();
  }

  private void getInputValue() {
    System.out.print(GET_NUMBER_MESSAGE);
    String input = readLine();
    checkValue(input);
  }

  //숫자야구 랜덤 수 중복 체크
  private boolean checkArrayValue(int[] arr, int checkVal) {
    boolean isDuplicate = false;
    for (int val : arr) {
        if (val == checkVal) {
            isDuplicate = true;
        }
    }
    return isDuplicate;
  }

  private void checkValue(String input) {
    int intValue = 0;
    if (input == null) {
      throw new NullPointerException();
    }
    try {
      intValue = Integer.parseInt(input);
    } catch (NumberFormatException e) {//숫자 아닌지 체크
      throw new IllegalArgumentException("숫자를 입력하세요");
    }
    if (!(intValue > 0 && intValue < 10)) {
      throw new IllegalArgumentException("1~9사이의 수를 입력하세요");
    }
  }

}
