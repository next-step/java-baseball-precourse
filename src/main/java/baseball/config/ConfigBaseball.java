package baseball.config;

public class ConfigBaseball {

	public static final int PICK_NUMBER_MIN = 1;
	public static final int PICK_NUMBER_MAX = 9;
	public static final int INPUT_SIZE = 3;
	public static final String ERROR_MESSAGE = "[ERROR] " + INPUT_SIZE + "개의 숫자를 입력해주세요.";
	public static final String READLINE_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String HINT_STRIKE_MESSAGE = "스트라이크";
	public static final String HINT_BALL_MESSAGE = "볼";

	private ConfigBaseball() {
	}
}
