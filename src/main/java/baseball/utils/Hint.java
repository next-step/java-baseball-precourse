package baseball.utils;

public enum Hint {
	INPUT("숫자를 입력해주세요 : "),
	STRIKE("스트라이크 "),
	BALL("볼"),
	NOTHING("낫싱"),
	GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 끝\n"),
	RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	ERROR("[ERROR] 입력값 오류\n");

	private final String hint;

	Hint(String hint) {
		this.hint = hint;
	}

	public String getHint() {
		return this.hint;
	}

	public String getHint(int number) {
		return number + this.hint;
	}
}