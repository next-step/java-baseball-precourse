package baseball.views;

import baseball.balls.Balls;
import baseball.balls.PlayResult;

public class DisplayView {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String GAME_START_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_OVER_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.%n";

    public static void play() {
        boolean isContinue = true;
        while (isContinue) {
            isContinue = running();
        }
    }

    public static void display(final PlayResult playResult) {
        String result = calculate(playResult);
        if (result.isEmpty()) {
            result = NOTHING;
        }
        System.out.println(result);
        if (playResult.isGameOver()) {
            System.out.printf(GAME_OVER_MESSAGE, PlayResult.GAME_OVER_STRIKE_COUNT);
        }
    }

    private static boolean running() {
        Balls computer = new Balls(InputView.inputComputerNumber());
        return isGameOver(computer);
    }

    private static boolean isGameOver(final Balls computer) {
        PlayResult playResult = null;
        while (isContinue(playResult)) {
            System.out.print(GAME_START_MESSAGE);
            playResult = computer.play(InputView.inputUserNumber());
            DisplayView.display(playResult);
        }
        System.out.printf((GAME_RESTART_MESSAGE), InputView.GAME_CONTINUE_FLAG, InputView.GAME_OVER_FLAG);
        return InputView.isContinue();
    }

    private static String calculate(final PlayResult playResult) {
        StringBuilder sb = new StringBuilder();
        if (0 < playResult.getBall()) {
            sb.append(String.format("%d%s ", playResult.getBall(), BALL));
        }
        if (0 < playResult.getStrike()) {
            sb.append(String.format("%d%s", playResult.getStrike(), STRIKE));
        }
        return sb.toString();
    }

    private static boolean isContinue(final PlayResult playResult) {
        return playResult == null || !playResult.isGameOver();
    }
}
