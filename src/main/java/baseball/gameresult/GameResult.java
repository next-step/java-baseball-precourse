package baseball.gameresult;

import baseball.balls.Balls;
import baseball.referee.Referee;

public class GameResult {

    private Balls computerBalls, userBalls;

    private int strikeCount = 0;
    private int ballCount = 0;

    public GameResult(Balls computerBalls, Balls userBalls) {
        this.computerBalls = computerBalls;
        this.userBalls = userBalls;
    }

    public String playGame() {
        Referee referee = new Referee(computerBalls);

        for (int i = 0; i < userBalls.getBallList().size(); i++) {
            increaseCount(referee.judge(userBalls.getBallList().get(i)));
        }

        return resultWithCount();
    }

    private void increaseCount(String judgementResult) {
        if (judgementResult == "STRIKE") {
            ++strikeCount;
        }

        if (judgementResult == "BALL") {
            ++ballCount;
        }
    }

    private String resultWithCount() {
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }

        if (strikeCount == 0) {
            return ballCount + "볼";
        }

        if (ballCount == 0) {
            return strikeCount + "스트라이크";
        }

        if (strikeCount != 0 && ballCount != 0) {
            return strikeCount + "스트라이크 " + ballCount + "볼";
        }

        return "낫싱";
    }

    public boolean gameEnd(String inputNumber) {
        if (strikeCount == 3) {
            return isRestart(inputNumber);
        }
        return false;
    }

    private boolean isRestart(String inputNumber) {
        if (inputNumber.equals("1")) {
            return true;
        }

        if (inputNumber.equals("2")) {
            return false;
        }

        return false;
    }
}
