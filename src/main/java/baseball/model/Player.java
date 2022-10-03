package baseball.model;

import baseball.controller.Game;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Player {
    public static final String INPUT_BALL_REGEX = "[1-9]{3}";

    private List<Integer> balls;

    public List<Integer> balls() {
        return balls;
    }

    public void inputBalls(String input) {
        validDigitAndLength(input);

        this.balls = new ArrayList<>();
        for (String ball : input.split("")) {
            this.balls.add(Integer.parseInt(ball));
        }

        validDuplicateBalls();
    }

    private static void validDigitAndLength(String input) {
        if (!Pattern.matches(INPUT_BALL_REGEX, input)) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 게임을 종료합니다.");
        }
    }

    private void validDuplicateBalls() {
        Set<Integer> set = new HashSet<>(balls);
        if (set.size() != Game.BALL_INPUT_SIZE) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 게임을 종료합니다.");
        }
    }
}
