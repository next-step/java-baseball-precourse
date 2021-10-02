package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.config.ConfigBaseball;
import nextstep.utils.Randoms;

/**
 * 게임을 위한 랜덤 값 생성
 * 생성된 랜덤 값 과 사용자 입력 값 검증을 위한 도메인
 */
public class Computer {

	private Set randomSet = new HashSet<Integer>();
	private List randomValue = new ArrayList();
	private final int INPUT_SIZE = ConfigBaseball.INPUT_SIZE;
	private final int PICK_NUMBER_MIN = ConfigBaseball.PICK_NUMBER_MIN;
	private final int PICK_NUMBER_MAX = ConfigBaseball.PICK_NUMBER_MAX;
	private final String HINT_STRIKE_MESSAGE = ConfigBaseball.HINT_STRIKE_MESSAGE;
	private final String HINT_BALL_MESSAGE = ConfigBaseball.HINT_BALL_MESSAGE;
	private String hint = "";
	private int strike = 0;
	private int ball = 0;

	public List getClearRandomValue() {
		clear();
		init();
		return getRandomValue();
	}

	public int checkBall(List randomValue, List userInput) {
		for (int i = 0; i < INPUT_SIZE; i++) {
			countBall(randomValue, userInput, i);
		}

		return getBall();
	}

	public int checkStrike(List randomValue, List userInput) {
		if (Arrays.equals(randomValue.toArray(), userInput.toArray())) {
			setStrike(INPUT_SIZE);
			return getStrike();
		}

		for (int i = 0; i < INPUT_SIZE; i++) {
			countStrike((int)randomValue.get(i), (int)userInput.get(i));
		}
		return getStrike();
	}

	public String makeHint() {
		StringBuilder builder = new StringBuilder();

		appendHint(builder);

		setHint(builder.toString());

		return getHint();
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

	private void appendHint(StringBuilder builder) {
		if (getStrike() != 0) {
			builder.append(getStrike()).append(HINT_STRIKE_MESSAGE);
		}

		appendHintDelimiter(builder);

		if (getBall() != 0) {
			builder.append(getBall()).append(HINT_BALL_MESSAGE);
		}
	}

	private void appendHintDelimiter(StringBuilder builder) {
		if (getStrike() != 0 && getBall() != 0) {
			builder.append(" ");
		}
	}

	private void init() {
		while (randomSet.size() != INPUT_SIZE) {
			int random = Randoms.pickNumberInRange(PICK_NUMBER_MIN, PICK_NUMBER_MAX);
			randomSet.add(random);
		}

		for (Object randomNumber : randomSet) {
			randomValue.add(randomNumber);
		}
	}

	private void clear() {
		if (!randomSet.isEmpty()) {
			randomSet.clear();
		}

		if (!randomValue.isEmpty()) {
			randomValue.clear();
		}
		setHint("");
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
