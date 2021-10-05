package baseball.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import baseball.domain.Answers;
import baseball.domain.Ball;
import baseball.domain.Strike;
import baseball.domain.User;

public class Checker {
	private static final String INPUT_DELIMITER = "";
	private static final int INPUT_MIN_SIZE = 3;
	private static final String STRIKE_MESSAGE = "%s스트라이크";
	private static final String BALL_MESSAGE = " %s볼";
	private static final String NOTHING_MESSAGE = "낫싱";
	private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
	private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String RESTART_TRUE = "1";
	private static Answers answers;
	private Strike strike;
	private Ball ball;

	private Checker() {
	}

	public static Checker init() {
		answers = Answers.init();
		return new Checker();
	}

	/**
	 * @author : yh.kim
	 * @Date : 2021/10/03 1:50 오전
	 * @Description : 스트라이크, 볼, 낫싱 판단
	 *
	 **/
	public boolean checkInput(String readLine) {
		List<String> inputs = Arrays.asList(readLine.split(INPUT_DELIMITER));

		strike = Strike.init();
		ball = Ball.init();

		addResult(inputs);

		printResult();

		return startOrExitByResult();
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/03 9:46 오후
	 * @Description : 스트라이크, 볼 개수 구하기
	 *
	 **/
	private void addResult(List<String> inputs) {
		for (int i = 0; i < inputs.size(); i++) {
			if (inputs.size() != INPUT_MIN_SIZE) break;

			if (answers.isStrike(inputs, i)) {
				strike.add();
				continue;
			}

			if (answers.isBall(inputs.get(i))) {
				ball.add();
				continue;
			}
		}
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/03 9:24 오후
	 * @Description : 판단 결과 출력
	 *
	 **/
	private void printResult() {
		StringBuilder resultBuilder = new StringBuilder();

		if (strike.value() > 0) {
			resultBuilder.append(String.format(STRIKE_MESSAGE, strike.value()));
		}

		if (ball.value() > 0) {
			resultBuilder.append(String.format(BALL_MESSAGE, ball.value()));
		}

		if (strike.value() == 0 && ball.value() == 0) {
			resultBuilder.append(NOTHING_MESSAGE);
		}

		System.out.println(resultBuilder.toString().trim());
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/03 10:12 오후
	 * @Description : 3스트라이크 여부 판단 - (true : 입력값에 따라 다시 시작 or 완전 종료 / false : 다시 시작)
	 *
	 **/
	private boolean startOrExitByResult() {
		if (strike.isThreeStrike()) {
			System.out.println(END_MESSAGE);
			System.out.println(RESTART_MESSAGE);

			String input = User.getInput();

			if (Objects.equals(input, RESTART_TRUE)) {
				answers.init();
				return true;
			}
			return false;
		}

		return true;
	}
}
