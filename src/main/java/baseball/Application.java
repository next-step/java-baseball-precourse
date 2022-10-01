package baseball;

import baseball.domain.BallGenerator;
import baseball.domain.BaseballResult;
import baseball.domain.Player;
import baseball.domain.Score;
import baseball.view.BaseballView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        do {
            BallGenerator generatedBall = new BallGenerator();
            playGame(generatedBall);
        } while (playAgain());
    }

    public static void playGame(BallGenerator generatedBall) {
        boolean result;
        do {
            Player player = BaseballView.inputNumber();
            Score match = BaseballResult.match(player.getNumberList(), generatedBall.getNumberList());
            result = BaseballView.gameResult(match);
        } while (!result);
    }

    public static boolean playAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputAgain = Console.readLine();
        if (inputAgain.equals("1")) {
            return true;
        }
        if (inputAgain.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
