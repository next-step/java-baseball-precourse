package baseball.constants;

public class NumMessage {
	public static final int RANDOM_MIN_NUM = 1;
	public static final int RANDOM_MAX_NUM = 9;
	public static final int NUM_LENGTH = 3;
	
	public static final String GAME_START = "숫자를 입력해주세요 : ";
	public static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	public static final String GAME_RESTART = "게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.";
	
	public static final String STRIKE = "스트라이크";
	public static final String BALL = "볼";
	public static final String NOTHING = "낫싱";
	
	public static final String INPUT_GAME_RESTART = "1";
	public static final String INPUT_GAME_END = "2";
	
	public static final String MESSAGE_VALIDATION_INPUT_LENGTH = "입력값은 3자리 입니다.";
	public static final String MESSAGE_VALIDATION_INPUT_RANGE = "입력값은 1~9 숫자 입니다.";
	public static final String MESSAGE_VALIDATION_INPUT_DUPLICATE = "입력값은 중복 숫자를 허용하지 않습니다.";
	public static final String MESSAGE_VALIDATION_INPUT_END = "입력값은 1 또는 2 입니다.";
}
