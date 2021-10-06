package baseball.domain;

public enum GameMessage {

	ASK_INPUT("숫자를 입력해주세요 : "), END_SINGLE_GAME_WITH_THREE_STRIKES("3개의 숫자를 모두 맞히셨습니다! 게임 끝"), ASK_RESTART_OR_DONE(
		"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."), END_PROGRAM("모든 게임이 종료되었습니다. 프로그램이 종료됩니다."), ERR_PUT_ONLY_1_OR_2(
		makeErrorMessage("1 또는 2를 입력해주세요.")), ERR_PUT_ONLY_THREE_NUMBERS(
		makeErrorMessage("0을 제외한 3개의 중복되지 않는 숫자를 입력해주세요."));

	private final String message;

	GameMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	private static String makeErrorMessage(String message) {
		return String.format("[ERROR] %s", message);
	}
}
