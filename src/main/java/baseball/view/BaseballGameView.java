package baseball.view;

public class BaseballGameView {

    private static final String INPUT_NUMBER_PHRASES = "숫자를 입력해주세요 : ";
    private static final String NEW_OR_EXIT_PHRASES = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    private static final String ALL_CORRECT_PHRASES = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private static final String NOTHING_PHRASES = "낫싱";
    private static final String BALL_PHRASES = "볼";
    private static final String STRIKE_PHRASES = "스트라이크";

    public String inputNumber() {
        return INPUT_NUMBER_PHRASES;
    }

    public String newOrExitGame() {
        return NEW_OR_EXIT_PHRASES;
    }

    public String allCorrectAnswer() {
        return ALL_CORRECT_PHRASES;
    }

    public String ballCount(int ballCount) {
        return ballCount + BALL_PHRASES;
    }

    public String strikeCount(int strikeCount) {
        return strikeCount + STRIKE_PHRASES;
    }

    public String nothingCount() {
        return NOTHING_PHRASES;
    }

}
