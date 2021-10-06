package baseball.domain;

import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    public static boolean playBall(List<Integer> answer) {
        boolean gameStatus = true;
        Judgment judgment = new Judgment();
        while (gameStatus) {
            BaseBall result = judgment.compareNumber(answer, BaseBallGame.inputNumber());
            System.out.println(Referee.callSign(result));
            gameStatus = !result.isGameEnd();
        }
        return BaseBallGame.continueGame();
    }

    private static List<Integer> inputNumber() {
        String player;
        do {
            System.out.print("숫자를 입력해 주세요 : ");
            player = Console.readLine();
        } while (RuleBook.validateRule(player));
        RuleBook.validateRule(player);
        return BaseBallGame.stringToList(player);
    }
    private static boolean continueGame() {
        int input;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = Integer.parseInt(Console.readLine());
        if (input == 1) {
            return true;
        }
        return false;
    }

    private static List<Integer> stringToList(String inputNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (String num : inputNumber.split("")) {
            numbers.add(Integer.valueOf(num));
        }
        return numbers;
    }
}
