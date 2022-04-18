package baseball;

public class ScreenManager {
	private static String REQUIRE_NUMBERS_MESSAGE = "숫자를 입력해주세요: ";

	private static String COMPLETION_MESSAGE = "3개의 숫자를 모두 맞히셨습니다!";

	private static String CONTINUED_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	private static String GAME_OVER = "게임 종료";

	public static void display(final Judgement judgement) {
		if (judgement.getNothingCount() > 2) { display("낫싱"); }

		StringBuilder builder = new StringBuilder();
		if (judgement.getBallCount() > 0) {
			builder.append(judgement.getBallCount() + "볼 ");
		}
		if (judgement.getStrikeCount() > 0) {
			builder.append(judgement.getStrikeCount() + "스트라이크");
		}
		display(builder.toString().trim());
	}

	public static void display(final String message) {
		System.out.println(message);
	}

	public static void requireNumbers() {
		System.out.print(REQUIRE_NUMBERS_MESSAGE);
	}

	public static void askContinued() {
		System.out.println(CONTINUED_MESSAGE);
	}

	public static void completion() {
		System.out.println(COMPLETION_MESSAGE);
		System.out.println(GAME_OVER);
	}
}
