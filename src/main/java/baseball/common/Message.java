package baseball.common;

public enum Message {
	INPUT("숫자를 입력해주세요: "),
	STRIKE("스트라이크 "),
	BALL("볼"),
	NOTHING("낫싱"),
	END("3개의 숫자를 모두 맞히셨습니다! 게임 끝"),
	END_OPTION("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	SIZE_ERROR("[ERROR]3자리가 아닙니다. 다시 입력하세요."),
	ZERO_ERROR("[ERROR]입력값에 0이 있습니다. 다시 입력하세요.");

	private String msg;

	Message(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
