package baseball.config;

public class ConfigBaseball {

	public static final int PICK_NUMBER_MIN = 1;
	public static final int PICK_NUMBER_MAX = 9;
	public static final int INPUT_SIZE = 3;
	public static final char NEW_GAME_SELECTOR = '1';
	public static final char END_GAME_SELECTOR = '2';
	public static final String ERROR_MESSAGE = "[ERROR] 서로 다른 " + INPUT_SIZE + "개의 숫자를 입력해주세요.";
	public static final String READLINE_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String HINT_STRIKE_MESSAGE = "스트라이크";
	public static final String HINT_BALL_MESSAGE = "볼";
	public static final String HINT_NOTHING_MESSAGE = "낫싱";
	public static final String GAME_CLEAR_FIRST_MESSAGE = INPUT_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 끝";
	public static final String GAME_CLEAR_SECOND_MESSAGE =
		"게임을 새로 시작하려면 " + NEW_GAME_SELECTOR + ", 종료하려면 " + END_GAME_SELECTOR + "를 입력하세요.";

	private ConfigBaseball() {
	}
}
