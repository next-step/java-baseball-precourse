package baseball.view;

import baseball.code.DisplayBoardCode;
import baseball.code.StatusCode;
import baseball.model.Count;
import camp.nextstep.edu.missionutils.Console;

public class DisplayBoard {

    public static void input() {
        System.out.print(DisplayBoardCode.INPUT.getMessage());
    }

    public static void count(Count count) {
        if (!count.isNothing()) {
            resultCount(count);
            return;
        }
        System.out.println(DisplayBoardCode.NOTHING.getMessage());
    }

    public static void gameOver() {
        System.out.println(DisplayBoardCode.GAMEOVER.getMessage());
    }

    public static boolean playAgain() {
        System.out.println(DisplayBoardCode.PLAYAGAIN.getMessage());
        return restartCheck(Console.readLine());
    }

    private static void resultCount(Count count) {
        StringBuilder st = new StringBuilder();
        st.append(zeroCheck(count.getBall(), DisplayBoardCode.BALL.getMessage()));
        st.append(st.length() > 0 ? " " : "");
        st.append(zeroCheck(count.getStrike(), DisplayBoardCode.STRIKE.getMessage()));
        System.out.println(st);
    }

    private static String zeroCheck(int count, String message) {
        if(count > 0) {
            return count + message;
        }
        return "";
    }

    private static boolean restartCheck(String status) {
        if ("1".equals(status)) {
            return false;
        }
        if ("2".equals(status)) {
            return true;
        }
        throw new IllegalArgumentException(StatusCode.INPUT.getMessage());
    }
}
