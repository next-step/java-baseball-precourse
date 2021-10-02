package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import baseball.config.ConfigBaseball;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

/**
 * 게임을 위한 랜덤 값 생성
 * 생성된 랜덤 값 과 사용자 입력 값 검증을 위한 도메인
 */
public class Computer {

	private List randomValue = new ArrayList();
	private final int INPUT_SIZE = ConfigBaseball.INPUT_SIZE;
	private final int PICK_NUMBER_MIN = ConfigBaseball.PICK_NUMBER_MIN;
	private final int PICK_NUMBER_MAX = ConfigBaseball.PICK_NUMBER_MAX;
	private final String HINT_STRIKE_MESSAGE = ConfigBaseball.HINT_STRIKE_MESSAGE;
	private final String HINT_BALL_MESSAGE = ConfigBaseball.HINT_BALL_MESSAGE;
	private final String HINT_NOTHING_MESSAGE = ConfigBaseball.HINT_NOTHING_MESSAGE;
	private final String GAME_CLEAR_FIRST_MESSAGE = ConfigBaseball.GAME_CLEAR_FIRST_MESSAGE;
	private final String GAME_CLEAR_SECOND_MESSAGE = ConfigBaseball.GAME_CLEAR_SECOND_MESSAGE;
	private final List newGameSelector = Arrays.asList('1', '2');
	private String hint = "";
	private int strike = 0;
	private int ball = 0;

	public List getClearRandomValue() {
		clear();
		init();
		return getRandomValue();
	}

	public boolean isGameClear() {
		boolean isSuccess = getStrike() == INPUT_SIZE;
		clearStrikeBall();

		if (isSuccess && isNewGame()) {
			getClearRandomValue();
			isSuccess = false;
		}

		return isSuccess;
	}

	private boolean isNewGame() {
		System.out.println(GAME_CLEAR_FIRST_MESSAGE);
		System.out.println(GAME_CLEAR_SECOND_MESSAGE);
		String readLine = Console.readLine();

		while (readLine.length() != 1 || !newGameSelector.contains(readLine.charAt(0))) {
			System.out.println(GAME_CLEAR_SECOND_MESSAGE);
			readLine = Console.readLine();
		}

		return "1".equals(String.valueOf(readLine.charAt(0)));
	}

	public boolean checkNothing() {
		if (getStrike() == 0 && getBall() == 0) {
			return true;
		}

		return false;
	}

	public int checkBall(List randomValue, List userInput) {
		for (int i = 0; i < INPUT_SIZE; i++) {
			countBall(randomValue, userInput, i);
		}

		return getBall();
	}

	public int checkStrike(List randomValue, List userInput) {
		if (isThreeStrike(randomValue, userInput)) {
			setStrike(INPUT_SIZE);
			return getStrike();
		}

		for (int i = 0; i < INPUT_SIZE; i++) {
			countStrike((int)randomValue.get(i), (int)userInput.get(i));
		}
		return getStrike();
	}

	public String makeHint() {
		StringBuilder hintBuilder = new StringBuilder();

		if (!isNothing(hintBuilder)) {
			appendHint(hintBuilder);
		}

		setHint(hintBuilder.toString());

		return getHint();
	}

	private boolean isNothing(StringBuilder hintBuilder) {
		if (checkNothing()) {
			hintBuilder.append(HINT_NOTHING_MESSAGE);
			return true;
		}

		return false;
	}

	private boolean isThreeStrike(List randomValue, List userInput) {
		return Arrays.equals(randomValue.toArray(), userInput.toArray());
	}

	private void countBall(List randomValue, List userInput, int i) {
		if (randomValue.contains(userInput.get(i)) && !randomValue.get(i).equals(userInput.get(i))) {
			ball++;
		}
	}

	private void countStrike(int randomValue, int userInput) {
		if (randomValue == userInput) {
			strike++;
		}
	}

	private void appendHint(StringBuilder hintBuilder) {
		if (getStrike() != 0) {
			hintBuilder.append(getStrike()).append(HINT_STRIKE_MESSAGE);
		}

		appendHintDelimiter(hintBuilder);

		if (getBall() != 0) {
			hintBuilder.append(getBall()).append(HINT_BALL_MESSAGE);
		}
	}

	private void appendHintDelimiter(StringBuilder hintBuilder) {
		if (getStrike() != 0 && getBall() != 0) {
			hintBuilder.append(" ");
		}
	}

	private void init() {
		while (randomValue.size() != INPUT_SIZE) {
			int random = Randoms.pickNumberInRange(PICK_NUMBER_MIN, PICK_NUMBER_MAX);
			addRandomValue(random);
		}

	}

	private void addRandomValue(int random) {
		if (!randomValue.contains(random)) {
			randomValue.add(random);
		}
	}

	private void clear() {
		if (!randomValue.isEmpty()) {
			randomValue.clear();
		}
		setHint("");
		clearStrikeBall();
	}

	private void clearStrikeBall() {
		setStrike(0);
		setBall(0);
	}

	private void setStrike(int strike) {
		this.strike = strike;
	}

	private void setBall(int ball) {
		this.ball = ball;
	}

	private void setHint(String hint) {
		this.hint = hint;
	}

	public List getRandomValue() {
		return randomValue;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public String getHint() {
		return hint;
	}
}
