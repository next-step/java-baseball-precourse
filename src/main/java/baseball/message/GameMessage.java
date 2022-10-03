package baseball.message;

public enum GameMessage {
	INPUT_NUMBER("숫자를 입력해주세요 : "),
	STRIKE("%d스트라이크"),
	BALL("%d볼"),
	BALL_STRIKE("%d볼 %d스트라이크"),
	NOTHING("낫싱"),
	GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
	NEW_GAME_OR_EXIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

	private final String message;

	GameMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
