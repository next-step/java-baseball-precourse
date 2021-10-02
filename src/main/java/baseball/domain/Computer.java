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

	private String hint = "";
	private int strike = 0;
	private int ball = 0;

	public List getClearRandomValue() {
		clear();
		init();
		return getRandomValue();
	}

	public void checkStrike(List randomValue, List userInput) {
		if (Arrays.equals(randomValue.toArray(), userInput.toArray())) {
			setStrike(INPUT_SIZE);
			return;
		}

		for (int i = 0; i < INPUT_SIZE; i++) {
			countStrike((int)randomValue.get(i), (int)userInput.get(i));
		}
	}

	private void countStrike(int randomValue, int userInput) {
		if (randomValue == userInput) {
			strike++;
		}
	}

	public void makeHint() {
		StringBuilder builder = new StringBuilder();

		if (getStrike() != 0) {
			builder.append(getStrike()).append("스트라이크 ");
		}

		if (getBall() != 0) {
			builder.append(getBall()).append("볼 ");
		}
		setHint(builder.toString());
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
