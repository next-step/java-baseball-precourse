package baseball.model;

import java.util.ArrayList;
import java.util.List;

import baseball.model.result.Fail;
import baseball.model.result.Result;
import baseball.model.result.Success;
import nextstep.utils.Randoms;

public class Baseball {
	private List<Integer> numbers = new ArrayList<>();
	private final int sizeOfNumbers = 3;
	private int strike = 0;
	private int ball = 0;

	private static final Baseball instance = new Baseball();

	public static Baseball getInstance() {
		return instance;
	}

	public void initialize() {
		initNumbers();
	}

	private void initNumbers() {
		numbers.clear();

		while (numbers.size() < sizeOfNumbers) {
			addRandomNumber();
		}
	}

	private void initStrikeAndBall() {
		strike = 0;
		ball = 0;
	}

	private void addRandomNumber() {
		int randomNumber = Randoms.pickNumberInRange(1, 9);
		if (!numbers.contains(randomNumber)) {
			numbers.add(randomNumber);
		}
	}

	public Result checkIfTheAnswerIsCorrect(List<Integer> inputNumbers) {
		numbersCompareTo(inputNumbers);

		if (strike == sizeOfNumbers) {
			return new Success("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! ");
		}

		return new Fail(getFailMessage());
	}

	private void numbersCompareTo(List<Integer> inputNumbers) {
		initStrikeAndBall();

		for (int i = 0; i < this.numbers.size(); i++) {
			int number = inputNumbers.get(i);
			updateStrikeOrBall(i, number);
		}
	}

	private void updateStrikeOrBall(int idx, int number) {
		if (this.numbers.get(idx) == number) {
			strike++;
			return;
		}

		if (this.numbers.contains(number)) {
			ball++;
		}
	}

	private String getFailMessage() {
		if (!existsStrike() && !existsBall()) {
			return "낫싱";
		}

		return makeHint();
	}

	private String makeHint() {
		StringBuilder message = new StringBuilder();

		if (existsStrike()) {
			message.append(String.format("%d스트라이크", strike)).append(" ");
		}

		if (existsBall()) {
			message.append(String.format("%d볼", ball));
		}

		return message.toString();
	}

	private boolean existsStrike() {
		return 0 < strike;
	}

	private boolean existsBall() {
		return 0 < ball;
	}
}
