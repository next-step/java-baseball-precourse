package baseball.view;

public enum Message {
	NOTHING("낫싱"),
	BALL("볼"),
	STRIKE("스트라이크");

	private final String text;

	Message(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
