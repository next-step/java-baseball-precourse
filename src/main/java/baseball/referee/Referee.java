package baseball.referee;

import baseball.ball.Ball;
import baseball.constant.HintConstant;
import org.assertj.core.util.Strings;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Referee {

    public RefereeResult compareTwoBalls(Ball opponentBall, Ball userBall) {
        if (checkAnswer(opponentBall, userBall)) {
            return RefereeResult.create(CompareResult.ANSWER, createStrikeHint(opponentBall, userBall));
        }
        if (checkIsNothing(opponentBall, userBall)) {
            return RefereeResult.create(CompareResult.WRONG, HintConstant.NOTHING);
        }
        String ballHint = createBallHint(opponentBall, userBall);
        String strikeHint = createStrikeHint(opponentBall, userBall);
        return RefereeResult.create(CompareResult.WRONG, Strings.concat(ballHint, strikeHint));

    }

    private boolean checkIsNothing(Ball opponentBall, Ball userBall) {
        List<Integer> opponentBallNumbers = opponentBall.getBallNumbers();
        List<Integer> userBallNumbers = userBall.getBallNumbers();
        boolean isNothing = true;
        for (Integer number : userBallNumbers) {
            if (opponentBallNumbers.contains(number)) {
                isNothing = false;
                break;
            }
        }
        return isNothing;
    }

    private String createStrikeHint(Ball opponentBall, Ball userBall) {
        List<Integer> opponentBallNumbers = opponentBall.getBallNumbers();
        List<Integer> userBallNumbers = userBall.getBallNumbers();
        int strikeCount = countStrike(opponentBallNumbers, userBallNumbers);
        return strikeCount == 0 ? "" : String.format(HintConstant.STRIKE, strikeCount);
    }

    private int countStrike(List<Integer> opponentBallNumbers, List<Integer> userBallNumbers) {
        int strikeCount = 0;
        for (int index = 0; index < opponentBallNumbers.size(); index++) {
            int opponentBallNumber = opponentBallNumbers.get(index);
            int userBallNumber = userBallNumbers.get(index);
            if (opponentBallNumber == userBallNumber) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private String createBallHint(Ball opponentBall, Ball userBall) {
        List<Integer> opponentBallNumbers = opponentBall.getBallNumbers();
        List<Integer> userBallNumbers = userBall.getBallNumbers();
        int ballCount = countBall(opponentBallNumbers, userBallNumbers);
        return ballCount == 0 ? "" : String.format(HintConstant.BALL, ballCount);
    }

    private int countBall(List<Integer> opponentBallNumbers, List<Integer> userBallNumbers) {
        int ballCount = 0;
        Set<Integer> opponentBallNumberSet = new HashSet<>(opponentBallNumbers);
        for (int number : userBallNumbers) {
            int opponentIndex = opponentBallNumbers.indexOf(number);
            int userIndex = userBallNumbers.indexOf(number);
            if (opponentBallNumberSet.contains(number) && opponentIndex != userIndex) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private boolean checkAnswer(Ball opponentBall, Ball userBall) {
        return opponentBall.equals(userBall);
    }

}
