package baseball.game;

public class GameMessage {
    private static String joinWithSpace(String... words) {
        return String.join(" ", words);
    }

    private static String joinIfGreaterThanZero(int n, String s) {
        if (n < 1) {
            return "";
        }
        return joinWithSpace(String.valueOf(n), s);
    }

    private static String strikeOrBallMessage(int strikes, int balls) {
        if (strikes < 1 && balls < 1) {
            return "낫싱";
        }
        return joinWithSpace(
                joinIfGreaterThanZero(balls, "볼"),
                joinIfGreaterThanZero(strikes, "스트라이크")
        );
    }

    private static String endMessage(int strikes) {
        if (strikes != GameConfig.NUM_NUMBERS) {
            return "";
        }
        return "\n" + GameConfig.NUM_NUMBERS + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    public static String resultMessage(ScoringResults score) {
        int strikes = score.getNumStrikes();
        int balls = score.getNumBalls();
        String sb = strikeOrBallMessage(strikes, balls) + endMessage(strikes);
        return sb.trim();
    }
}
