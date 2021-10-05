package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static baseball.commonConstants.COMMON_THREE;
import static baseball.commonConstants.COMMON_ZERO;

public class Balls {


    private List<Ball> computerBalls = new ArrayList<>();
    private BallNumberGenerator ballNumberGenerator;


    public Balls(BallNumberGenerator ballNumberGenerator) {
        this.ballNumberGenerator = ballNumberGenerator;
        initComputerBalls();
    }

    private void initComputerBalls() {
        for (int BallNumber : ballNumberGenerator.generate()) {
            computerBalls.add(Ball.of(BallNumber, ballNumberGenerator.generate().indexOf(BallNumber)));
        }
    }

    public static List<Ball> playerBallInit(String playerBallNumber) {

        validBallNumber(playerBallNumber);

        return IntStream.range(COMMON_ZERO, COMMON_THREE)
                .mapToObj(index -> Ball.of(playerBallNumber.charAt(index) - '0', index))
                .collect(Collectors.toList());
    }


    public static Balls of(BallNumberGenerator ballNumberGenerator) {
        return new Balls(ballNumberGenerator);
    }

    public Status playBall(Ball playerBall) {
        return computerBalls.stream()
                .map(ball -> ball.compareBall(playerBall))
                .filter(status -> status != Status.NOTHING)
                .findFirst()
                .orElse(Status.NOTHING);
    }

    public PlayResult playBalls(List<Ball> playerBalls) {

        PlayResult playResult = PlayResult.of();

        for (Ball playerBall : playerBalls) {
            playResult.reulstCount(playBall(playerBall));
        }

        return playResult;
    }

    private static void validBallNumber(String playerBallNumber) {
        if (playerBallNumber.length() != COMMON_THREE) {
            throw new IllegalArgumentException("입력하신숫자는 3자리여야 됩니다.");
        }
    }
}
