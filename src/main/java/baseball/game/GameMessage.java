package baseball.game;

import static baseball.game.GameConfig.NUM_NUMBERS;

public class GameMessage {
    public static String prompt() {
        return "숫자를 입력해주세요 : ";
    }

    private static String concatIfGreaterThanZero(int n, String s) {
        if (n < 1) {
            return "";
        }
        return String.join("", String.valueOf(n), s);
    }

    private static String strikeOrBallMessage(int strikes, int balls) {
        if (strikes < 1 && balls < 1) {
            return "낫싱";
        }
        return String.join(" ",
                concatIfGreaterThanZero(balls, "볼"),
                concatIfGreaterThanZero(strikes, "스트라이크")
        );
    }

    private static String endMessage(int strikes) {
        if (strikes != NUM_NUMBERS) {
            return "";
        }
        return "\n" + NUM_NUMBERS + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    public static String resultMessage(int strikes, int balls) {
        String sb = strikeOrBallMessage(strikes, balls) + endMessage(strikes);
        return sb.trim();
    }
}
