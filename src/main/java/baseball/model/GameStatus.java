package baseball.model;

public enum GameStatus {
	STRIKE("스트라이크"),
	BALL("볼"),
	NOTHING("낫싱");

	private final String description;

	GameStatus(String description) {
		this.description = description;
	}

	/**
	 * 하나의 볼과 여러 개의 볼을 비교하는 과정에서, 하나라도 Nothing 이 아니라면, 그 결과가 답이 된다.
	 * before 이 Nothing 의 상태인 경우에
	 * after 가 Ball / Strike 상태라면 after 의 상태를 반환한다.
	 *
	 * @param before 이번 공을 비교하기 전 까지의 GameStatus
	 * @param after 이번 공을 비교한 후의 GameStatus
	 * @return 갱신된 GameStatus
	 */
	public static GameStatus changeStatus(GameStatus before, GameStatus after) {
		if (isNothing(before)) {
			return after;
		}
		return before;
	}

	private static boolean isNothing(GameStatus gameStatus) {
		return gameStatus == NOTHING;
	}

	public static boolean isStrike(GameStatus gameStatus) {
		return gameStatus == STRIKE;
	}

	public static boolean isBall(GameStatus gameStatus) {
		return gameStatus == BALL;
	}

	public String getDescription() {
		return description;
	}
}
