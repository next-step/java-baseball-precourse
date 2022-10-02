package baseball.domain;

import java.util.function.Function;

public enum SwingResults {

    NOTTHING(swing -> SwingConstants.NOTTHING, swing -> (swing.getStrike() + swing.getBall()) == SwingConstants.ZERO),
    STRIKE(swing -> swing.getStrike() + SwingConstants.STRIKE, swing -> swing.getBall() == SwingConstants.ZERO),
    BALL(swing -> swing.getBall() + SwingConstants.BALL, swing -> swing.getStrike() == SwingConstants.ZERO),
    NONE(swing -> swing.getBall() + SwingConstants.BALL + SwingConstants.BLANK_SEPARATOR + swing.getStrike() + SwingConstants.STRIKE, swing -> true);

    private static class SwingConstants {
        private static final int ZERO = 0;
        private static final String BLANK_SEPARATOR = " ";
        private static final String STRIKE = "스트라이크";
        private static final String BALL = "볼";
        private static final String NOTTHING = "낫싱";
    }

    private final Function<Swing, String> message;
    private final Function<Swing, Boolean> judgment;

    SwingResults(Function<Swing, String> message, Function<Swing, Boolean> judgment) {
        this.message = message;
        this.judgment = judgment;
    }

    public static String printMessage(final Swing swing) {
        if (SwingResults.NOTTHING.judgment.apply(swing)) {
            return SwingResults.NOTTHING.message.apply(swing);
        }
        if (SwingResults.STRIKE.judgment.apply(swing)) {
            return SwingResults.STRIKE.message.apply(swing);
        }
        if (SwingResults.BALL.judgment.apply(swing)) {
            return SwingResults.BALL.message.apply(swing);
        }
        return SwingResults.NONE.message.apply(swing);
    }

}
