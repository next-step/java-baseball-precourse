package baseball.view;

public class BaseballGameView {

    private static final String INPUT_NUMBER_PHRASES = "숫자를 입력해주세요 : ";
    private static final String NEW_OR_EXIT_PHRASES = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    private static final String ALL_CORRECT_PHRASES = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_PHRASES = "낫싱";
    private static final String BALL_PHRASES = "볼";
    private static final String STRIKE_PHRASES = "스트라이크";
    private static final String GAP_PHRASES = " ";
    private static final String ENTER_PHRASES = "\n";

    public String inputNumber() {
        return INPUT_NUMBER_PHRASES;
    }

    public String newOrExitGame() {
        return NEW_OR_EXIT_PHRASES;
    }

    public String allCorrectAnswer() {
        return ENTER_PHRASES + ALL_CORRECT_PHRASES;
    }

    public String ballCount(int ballCount) {
        String message = "";
        if (ballCount > 0) {
            message = ballCount + BALL_PHRASES + GAP_PHRASES;
        }
        return message;
    }

    public String strikeCount(int strikeCount) {
        String message = "";
        if (strikeCount > 0) {
            message = strikeCount + STRIKE_PHRASES;
        }
        return message;
    }

    public String nothingCount() {
        return NOTHING_PHRASES;
    }

}
