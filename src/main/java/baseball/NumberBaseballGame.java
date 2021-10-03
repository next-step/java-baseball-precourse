package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class NumberBaseballGame {
	private List<String> answers;
	private int strike = 0;
	private int ball = 0;

	NumberBaseballGame() {
	}

	/**
	 * @author : yh.kim
	 * @Date : 2021/10/03 1:47 오전
	 * @Description : 게임 시작
	 *
	 **/
	void start() {
		System.out.print("숫자를 입력해주세요 : ");

		String readLine = getInput();

		checkInput(readLine);
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/03 1:20 오전
	 * @Description : 임의의 수 선택
	 * @History :
	 *
	 **/
	void initAnswers() {
		answers = Arrays.asList(
			new String[] {
				String.valueOf(Randoms.pickNumberInRange(1, 9))
				, String.valueOf(Randoms.pickNumberInRange(1, 9))
				, String.valueOf(Randoms.pickNumberInRange(1, 9))
			}
		);
	}

	/**
	 * @author : yh.kim
	 * @Date : 2021/10/03 1:50 오전
	 * @Description : 스트라이크, 볼, 낫싱 판단
	 *
	 **/
	private void checkInput(String readLine) {
		List<String> inputs = Arrays.asList(readLine.split(""));

		strike = 0;
		ball = 0;

		addResult(inputs);

		printResult();

		if (strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

			String input = getInput();

			if (Objects.equals(input, "1")) {
				initAnswers();

				start();
			}
		}

		if (strike != 3) {
			start();
		}
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

			if (Objects.equals(inputs.get(i), answers.get(i))) {
				strike++;
				continue;
			}

			if (answers.contains(inputs.get(i))) {
				ball++;
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

		if (strike > 0) {
			resultBuilder.append(String.format("%s스트라이크", strike));
		}

		if (ball > 0) {
			resultBuilder.append(String.format(" %s볼", strike));
		}

		if (strike == 0 && ball == 0) {
			resultBuilder.append("낫싱");
		}

		System.out.println(resultBuilder);
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/02 11:06 오후
	 * @Description : 사용자가 입력한 문자열을 반환하는 메소드
	 * @return {@link Console#readLine()}
	 * @throws NoSuchElementException 입력값이 없을 때
	 * @throws IllegalStateException 스캐너가 닫혔을 때
	 *
	 **/
	private String getInput() throws NoSuchElementException, IllegalStateException {
		String input = Console.readLine();

		return input;
	}
}
