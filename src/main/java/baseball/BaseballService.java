package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class BaseballService {

  private final BaseBall baseBall;

  public BaseballService() {
    Set<Character> chars = new HashSet<>();
    while (chars.size() < 3) {
      int randomNum = Randoms.pickNumberInRange(1, 9);
      chars.add(Character.forDigit(randomNum, 10));
    }

    this.baseBall = new BaseBall(new ArrayList<>(chars));
  }

  public void execute() {
    for(String input = "1"; input.equals("1");) {
      baseball();

      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
      input = input();
    }
  }

  private void baseball() {
    for(boolean isContinue = true; isContinue;) {
      System.out.print("숫자를 입력해주세요 : ");

      String input = Console.readLine();
      isContinue = !baseBall.isAnswer();
    }

    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
  }

  private String input() {
    String input = Console.readLine();
    if (!"1".equals(input) && !"2".equals(input)) {
      System.out.println("[ERROR] 잘못된 입력입니다. 게임을 종료합니다.");
      return "2";
    }

    return input;
  }
}
