package baseball.view;

import static baseball.type.Score.*;
import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.List;
import static baseball.common.Validator.*;
import static baseball.common.Util.*;

public class ConsoleIO {
    private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";
    private static final String CORRECT_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static List<Integer> inputAnswer() {
        System.out.print(INPUT_SENTENCE);
        String input = readLine();

        if (!isValidBaseballNumber(input)) {
            throw new IllegalArgumentException();
        }

        return convertToList(input);
    }

    public  static  void printResult(int strike, int ball) {
        String resultMessage = "";
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING.getName());
            return;
        }
        if (ball != 0) resultMessage += ball + BALL.getName() + " ";
        if (strike != 0) resultMessage += strike + STRIKE.getName();

        System.out.println(resultMessage);
    }

    public  static  void printComplete() {
        System.out.println(CORRECT_SENTENCE);
    }

    public static String inputRestart() {
        System.out.println(RESTART_SENTENCE);
        String input = readLine();

        if (!isValidRestartFlag(input)) {
            throw new IllegalArgumentException();
        }

        return input;
    }
}
