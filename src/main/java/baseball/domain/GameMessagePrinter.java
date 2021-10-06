package baseball.domain;

public class GameMessagePrinter {

    public static void println(GameMessage gameMessage) {
        System.out.println(gameMessage.getMessage());
    }

    public static void print(GameMessage gameMessage) {
        System.out.print(gameMessage.getMessage());
    }

    public static void println(BaseballGameScoreBoard board) {

        if (board.isNothing()) {
            System.out.println("낫싱");
            return;
        }

        String message = "";

        if (board.getStrikeCount() > 0) {
            message += String.format("%d스트라이크 ", board.getStrikeCount());
        }

        if (board.getBallCount() > 0) {
            message += String.format("%d볼", board.getBallCount());
        }

        System.out.println(message.trim());
    }
}
