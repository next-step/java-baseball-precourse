package baseball.model;

import baseball.view.ComputerView;

public class Computer {
    Ball ball;
    BallJudgment ballJudgment;
    ComputerView computerView;
    int ballNumber;

    public Computer(Ball ball, BallJudgment ballJudgment, ComputerView computerView) {
        this.ball = ball;
        this.ballJudgment = ballJudgment;
        this.computerView = computerView;
    }

    public void generateBallNumber() {
        this.ballNumber = ball.generateBallNumber();
    }

    public boolean judgmentPlayerBall(int playerBallNumber) {
        String[] computerBallNumberStringArray = ballJudgment.convertIntToStringArray(ballNumber);
        String[] playerBallNumberStringArray = ballJudgment.convertIntToStringArray(playerBallNumber);

        int ballCount = ballJudgment.countBall(computerBallNumberStringArray, playerBallNumberStringArray);
        int strikeCount = ballJudgment.countStrike(computerBallNumberStringArray, playerBallNumberStringArray);

        printGameResult(ballCount, strikeCount);

        return playerGameWin(strikeCount);
    }

    public boolean playerGameWin(int strikeCount) {
        return strikeCount == 3;
    }

    public void printGameResult(int ballCount, int strikeCount) {
        String gameResultString = gameResultString(ballCount, strikeCount);

        printIfPlayerBallResult(gameResultString);
        printIfThreeStrike(strikeCount);
        printIfNothing(ballCount, strikeCount);
    }

    public String gameResultString(int ballCount, int strikeCount) {
        String result = ballResultString(ballCount) + " " + strikeResultString(strikeCount);
        result = result.trim();

        return result;
    }

    public String ballResultString(int ballCount) {
        if (ballCount > 0) {
            return ballCount + "볼";
        }
        return "";
    }

    public String strikeResultString(int strikeCount) {
        if (strikeCount > 0) {
            return strikeCount + "스트라이크";
        }
        return "";
    }

    public void printIfPlayerBallResult(String result) {
        if (result.length() > 0) {
            computerView.printPlayerBallResult(result);
        }
    }

    public void printIfThreeStrike(int strikeCount) {
        if (strikeCount == 3) {
            computerView.printPlayerWin();
        }
    }

    public void printIfNothing(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            computerView.printNothing();
        }
    }
}
