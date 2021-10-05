package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static baseball.commonConstants.*;

public class Balls {



    private List<Ball> computerBalls = new ArrayList<>();


    public Balls() {
        initComputerBalls();
    }

    private void initComputerBalls() {
        int i = COMMON_ZERO;

        Iterator<Integer> ballNumbers = checkDuplicateNumber().iterator();

        while (ballNumbers.hasNext()) {
            computerBalls.add(Ball.of(ballNumbers.next(), i++));
        }
    }

    public static List<Ball> playerBallInit(String playerBallNumber) {

        validBallNumber(playerBallNumber);

        return IntStream.range(COMMON_ZERO, COMMON_THREE)
                .mapToObj(index -> Ball.of(playerBallNumber.charAt(index) - '0', index))
                .collect(Collectors.toList());
    }


    public static Balls of() {
        return new Balls();
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

    private static LinkedHashSet<Integer> checkDuplicateNumber() {
        LinkedHashSet<Integer> ballNumbers = new LinkedHashSet<>();
        while (ballNumbers.size() < COMMON_THREE) {
            ballNumbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
        return ballNumbers;
    }
}
