package baseball.code;


public enum GameStatus {
	START_GAME("1"),
	END_GAME("2"),
	END_RESULT("3스트라이크");

	private String gameStatus;

	GameStatus(String gameStatus) {
		this.gameStatus = gameStatus;
	}

	public static String validInputGameStatus(String input) {
		if (!(input.equals(START_GAME.gameStatus) || input.equals(END_GAME.gameStatus))) {
			throw new IllegalArgumentException("잘못된 입력입니다.");
		}
		return input;
	}

	public static boolean isRestart(String gameStatus) {
		return gameStatus.equals(START_GAME.gameStatus);
	}

	public String getGameStatus() {
		return this.gameStatus;
	}
}
