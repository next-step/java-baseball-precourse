package baseball.domains;

import baseball.constants.GameOption;
import java.util.function.Function;

public enum Score {
    BALL(1, (totalPoint) -> {
        final int countBall = totalPoint % 10;
        if (countBall == 0) {
            return "";
        }
        return countBall + "볼";
    }),
    STRIKE(10, (totalPoint) -> {
        final int countStrike = totalPoint / 10;
        if (countStrike == 0) {
            return "";
        }
        return countStrike + "스트라이크";
    }),
    NOTHING(0, (totalPoint) -> {
        if (totalPoint > 0) {
            return "";
        }
        return "낫싱";
    });

    private final int point;
    private final Function<Integer, String> messageBuilder;

    Score(int point, Function<Integer, String> messageBuilder) {
        this.point = point;
        this.messageBuilder = messageBuilder;
    }

    public static String calculate(Player player, Computer computer) {
        final String playerAimPositions = player.getAimPositions();
        final String computerAimPositions = computer.getAimPositions();
        int totalPoint = 0;

        for (int round = 0; round < GameOption.INPUT_LENGTH; round++) {
            totalPoint += getThisRoundPoint(playerAimPositions, computerAimPositions, round);
        }

        return buildResultMessage(totalPoint);
    }

    private static int getThisRoundPoint(String playerAimPositions, String computerAimPositions, int round) {
        final char playerAimPosition = playerAimPositions.charAt(round);
        if (computerAimPositions.charAt(round) == playerAimPosition) {
            return STRIKE.point;
        }
        if (computerAimPositions.contains(String.valueOf(playerAimPosition))) {
            return BALL.point;
        }
        return NOTHING.point;
    }

    private static String buildResultMessage(int point) {
        final StringBuilder resultMessage = new StringBuilder();

        for (Score scoreType : Score.values()) {
            resultMessage.append(" ");
            resultMessage.append(scoreType.messageBuilder.apply(point));
        }
        return resultMessage.toString().trim();
    }
}