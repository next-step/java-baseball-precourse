package baseball;

import static enums.Errors.getDesc;

import enums.Errors;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class BaseballService {

  public void execute() {
    for(String input = "1"; input.equals("1");) {
      playBaseball(getRandomNumber());

      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
      input = getInput();
    }
  }

  private List<Character> getRandomNumber() {
    List<Character> chars = new ArrayList<>();
    Consumer<Character> numConsumer = num -> {
      if(!chars.contains(num)) chars.add(num);
    };

    while (chars.size() < 3) {
      char randomNum = Character.forDigit(Randoms.pickNumberInRange(1, 9), 10);
      numConsumer.accept(randomNum);
    }

    return chars;
  }

  private void playBaseball(List<Character> chars) {
    BaseBall baseBall = new BaseBall(chars);
    for(boolean isContinue = true; isContinue;) {
      System.out.print("숫자를 입력해주세요 : ");

      String input = Console.readLine();
      System.out.println(baseBall.getState(input));

      isContinue = !baseBall.isAnswer();
    }

    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
  }

  private String getInput() {
    String input = Console.readLine();
    if (!"1".equals(input) && !"2".equals(input)) {
      System.out.println(getDesc(Errors.INPUT_ERROR_AND_EXIT));
      return "2";
    }

    return input;
  }
}
