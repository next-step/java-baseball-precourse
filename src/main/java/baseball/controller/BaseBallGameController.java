package baseball.controller;

import baseball.model.Computer;
import baseball.model.Judge;
import baseball.model.User;
import baseball.view.BaseBallGameView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBallGameController {

    private boolean executable = true;
    private static final Pattern REGULAR_EXPRESSION = Pattern.compile("^[1-9]*$");
    private static final String CONTINUE_GAME = "1";
    private static final String END_GAME = "2";

    public void start() throws IllegalArgumentException {
        Judge judge = new Judge();
        User user = new User();
        Computer computer = new Computer();
        do {
            checkContinue(computer);
            execute(user, judge);

            BaseBallGameView.printJudgeResult(judge);
        } while (isExecutable(readLine()));
    }

    private static void execute(User user, Judge judge) throws IllegalArgumentException {
        while (!judge.isStrikeOut()) {
            BaseBallGameView.printRequestInput();
            String input = readLine();
            checkInputArray(input);
            user.throwBalls(input);
            judge.countBalls(new ArrayList<>(Computer.getBallCount()), User.getBallCount());
            BaseBallGameView.notStrikeOut(judge);
        }
    }

    private void checkContinue(Computer computer) {
        if (!executable) {
            return;
        }
        if (executable) {
            computer.throwBalls();
        }
    }

    private boolean isExecutable(String input) {
        if (END_GAME.equals(input)) {
            executable = false;
        }
        return executable;
    }

    private static void checkRegularExpression(String element) throws IllegalArgumentException {
        if (!REGULAR_EXPRESSION.matcher(element).find()) {
            throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요.");
        }
    }

    private static void checkInputDigitWithoutZero(String[] input) {
        for (String element: input) {
            checkRegularExpression(element);
        }
    }

    private static void checkInputDuplication(String[] input) {
        Set<String> ballCountSet = new HashSet<>(Arrays.asList(input));
        if (ballCountSet.size() != input.length) {
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해주세요.");
        }
    }

    private static void checkInputLength(String[] input) {
        if (input.length != 3) {
            throw new IllegalArgumentException("제한된 길이 이하의 숫자를 입력해주세요.");
        }
    }

    private static void checkInputArray(String input) {
        String[] inputArray = input.split("");
        checkInputDigitWithoutZero(inputArray);
        checkInputDuplication(inputArray);
        checkInputLength(inputArray);
    }
}
