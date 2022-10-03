package baseball.domain;

import baseball.view.OutputProvider;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final List<Ball> computerBalls;

    public BaseballGame(List<Integer> numbers) {
        this.computerBalls = convertToBalls(numbers);
    }

    private List<Ball> convertToBalls(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            balls.add(new Ball(i + 1, numbers.get(i)));
        }
        return balls;
    }

    public static List<Integer> convertToInteger(String inputNumbers) {
        List<Integer> integerNumbers = new ArrayList<>();
        String[] split = inputNumbers.split("");
        for (String s : split) {
            integerNumbers.add(Integer.parseInt(s));
        }
        return integerNumbers;
    }

    public BallCount play(String inputNumbers) {
        List<Integer> playerBalls = convertToInteger(inputNumbers);
        BallCount ballCount = new BallCount();
        for (Ball computerBall : computerBalls) {
            ballCount.judgeNumbers(playerBalls, computerBall);
        }
        OutputProvider.printBallCount(ballCount);
        return ballCount;
    }
}
