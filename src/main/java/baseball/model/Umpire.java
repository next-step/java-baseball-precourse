package baseball.model;

import baseball.controller.Game;
import java.util.List;
import java.util.Objects;

public class Umpire {
    public static final String STRIKE_FORMAT = "%d스트라이크";
    public static final String BALL_FORMAT = "%d볼";
    public static final String NOTHING_FORMAT = "낫싱";

    private int strikeCount;
    private int ballCount;
    private List<Integer> computerBalls;
    private List<Integer> playerBalls;

    public void initGame(List<Integer> computerBalls, List<Integer> playerBalls) {
        this.strikeCount = 0;
        this.ballCount = 0;
        this.computerBalls = computerBalls;
        this.playerBalls = playerBalls;
    }

    public GameState judge() {
        for (int i = 0; i < Game.BALL_INPUT_SIZE; i++) {
            judgeStrike(computerBalls.get(i), playerBalls.get(i));
        }

        for (Integer playerBall : playerBalls) {
            judgeBall(playerBall);
        }

        return getGameState();
    }

    private void judgeStrike(Integer computerBall, Integer playerBall) {
        if (Objects.equals(computerBall, playerBall)) {
            strikeCount++;
        }
    }

    private void judgeBall(Integer playerBall) {
        if (computerBalls.contains(playerBall)) {
            ballCount++;
        }
    }

    private boolean isVictory() {
        return strikeCount == 3;
    }

    private GameState getGameState() {
        if (isVictory()) {
            return GameState.VICTORY;
        }

        return GameState.DEFEAT;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount - strikeCount;
    }

    public String result() {
        if (isNothing()) {
            return NOTHING_FORMAT;
        }

        if (isNotBall()) {
            return getResultMessage(STRIKE_FORMAT, getStrikeCount());
        }

        if (isNotStrike()) {
            return getResultMessage(BALL_FORMAT, getBallCount());
        }

        return getResultMessage(BALL_FORMAT, getBallCount()) + " " + getResultMessage(STRIKE_FORMAT, getStrikeCount());
    }

    private boolean isNothing() {
        return isNotStrike() && isNotBall();
    }

    private boolean isNotBall() {
        return getBallCount() == 0;
    }

    private boolean isNotStrike() {
        return getStrikeCount() == 0;
    }

    private String getResultMessage(String messageFormat, int ballCount) {
        return String.format(messageFormat, ballCount);
    }
}
