package baseball.view;

import baseball.constant.GameEnvironment;
import baseball.constant.GameMessage;
import baseball.model.GameCounter;

public class OutputConsole {

    private static StringBuilder builder;

    public static void printNumberMatchesView(GameCounter gameCounter) {
        builder = new StringBuilder();
        builder.append(nothing(gameCounter));
        builder.append(ball(gameCounter));
        builder.append(strike(gameCounter));

        System.out.println(builder.toString());
        builder.setLength(0);
    }

    private static String nothing(GameCounter gameCounter) {
        if (gameCounter.isNothing()) {
            return GameMessage.GAME_NOTHING_OUTPUT;
        }
        return "";
    }

    private static String ball(GameCounter gameCounter) {
        if (gameCounter.hasBall()) {
            return String.format(GameMessage.GAME_BALL_OUTPUT, gameCounter.getBall());
        }
        return "";
    }

    private static String strike(GameCounter gameCounter) {
        StringBuilder builder = new StringBuilder();
        if (gameCounter.hasBall()) {
            builder.append(" ");
        }

        if (gameCounter.hasStrike()) {
            return builder.append(String.format(GameMessage.GAME_STRIKE_OUTPUT, gameCounter.getStrike())).toString();
        }
        return "";
    }

    private static String win(GameCounter gameCounter) {
        if (gameCounter.getStrike() == GameEnvironment.NUMBER_SIZE) {
            return String.format(GameMessage.GAME_WIN_OUTPUT, gameCounter.getStrike());
        }
        return "";
    }

    public static void printErrorView() {
        System.out.println(GameMessage.GAME_ERROR_OUTPUT);
    }

    public static void printWinView(GameCounter gameCounter) {
        builder = new StringBuilder();
        builder.append(win(gameCounter));

        System.out.println(builder.toString());
        builder.setLength(0);
    }
}