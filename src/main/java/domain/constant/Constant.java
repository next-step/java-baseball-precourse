package domain.constant;

public class Constant {
    public static final int MINUMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 9;
    public static final int MAXIMUM_LENGTH = 3;

    public static final String NUMBERS_VALUE_VALIDATION_EXCEPTION = "숫자는 1에서 9 사이 값이어야 합니다.";
    public static final String NUMBERS_SIZE_VALIDATION_EXCEPTION = "숫자는 3자리 값이어야 합니다.";
    public static final String NUMBERS_DUPLICATE_VALIDATION_EXCEPTION = "숫자는 서로 다른 값이어야 합니다.";
    public static final String NUMBERS_FORMAT_VALIDATION_EXCEPTION = "숫자 이외의 값은 사용될 수 없습니다.";
    public static final String RESTART_VALUE_VALIDATION_EXCEPTION = "1, 2 이외의 값을 입력할 수 없습니다.";

    public static final String NOTHING_MESSAGE = "낫싱";
    public static final String BALL_MESSAGE = "볼 ";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String RESTART_REQUEST_INSTRUCTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String INPUT_REQUEST_INSTRUCTION = "숫자를 입력해주세요 : ";

    public static final String RESTART = "1";
    public static final String QUIT = "2";
}
