import java.util.Scanner;

public class BaseballGame {

    Player computer;
    boolean isEnd;

    public BaseballGame() {

    }

    public void init() {
        computer = new Player();
        isEnd = false;
    }

    public void game() {
        init();
        System.out.println(GameMessageConstant.START_GAME);
        do {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            String hint = getHint(input);
            System.out.println(hint);
        } while (!isEnd);
        System.out.println(GameMessageConstant.GAME_CLEAR);
    }

    public void run() {
        while (true) {
            game();
            System.out.println(GameMessageConstant.GAME_RESTART_QUESTION);
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input == GameConstant.END_GAME_NUMBER) {
                break;
            }
        }
        System.out.println(GameMessageConstant.GAME_END);
    }

    public String getHint(String input) {
        BaseBallGameResult result = computer.checkMatching(input2IntArray(input));
        checkEnd(result);
        return result2Hint(result);
    }

    private void checkEnd(BaseBallGameResult result) {
        if (result.strike() == GameConstant.NUMBER_COUNT) {
            isEnd = true;
        }
    }

    private int[] input2IntArray(String input) {
        int[] guess = new int[GameConstant.NUMBER_COUNT];
        for (int i = 0; i < GameConstant.NUMBER_COUNT; i++) {
            guess[i] = Character.getNumericValue(input.charAt(i));
        }
        return guess;
    }

    private String result2Hint(BaseBallGameResult result) {
        if (result.ball() == 0 && result.strike() == 0) {
            return GameMessageConstant.NOTHING;
        }
        if (result.ball() == 0) {
            return strike2String(result.strike());
        }
        if (result.strike() == 0) {
            return ball2String(result.ball());
        }
        return ball2String(result.ball()) + " " + strike2String(result.strike());
    }

    private String ball2String(int ball) {
        if (ball > 0) {
            return String.format("%d%s", ball, GameMessageConstant.BALL);
        }
        return "";
    }

    private String strike2String(int strike) {
        if (strike > 0) {
            return String.format("%d%s", strike, GameMessageConstant.STRIKE);
        }
        return "";
    }
}
