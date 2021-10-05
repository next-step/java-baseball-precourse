package baseball.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import baseball.domain.Answers;
import baseball.domain.Ball;
import baseball.domain.Strike;
import baseball.domain.User;

public class Checker {
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
		List<String> inputs = Arrays.asList(readLine.split(""));

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
			if (inputs.size() != 3) break;

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
			resultBuilder.append(String.format("%s스트라이크", strike.value()));
		}

		if (ball.value() > 0) {
			resultBuilder.append(String.format(" %s볼", ball.value()));
		}

		if (strike.value() == 0 && ball.value() == 0) {
			resultBuilder.append("낫싱");
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
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

			String input = User.getInput();

			if (Objects.equals(input, "1")) {
				answers.init();
				return true;
			}
			return false;
		}

		return true;
	}
}
