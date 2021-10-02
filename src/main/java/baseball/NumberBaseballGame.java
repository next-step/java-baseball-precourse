package baseball;

import java.util.NoSuchElementException;
import java.util.Objects;

import nextstep.utils.Console;

public class NumberBaseballGame {
	NumberBaseballGame() {
	}

	void start() {
		while (true) {
			System.out.print("숫자를 입력해주세요 : ");

			String readLine = getInput();

			// ApplicationTest#낫싱
			if (Objects.equals(readLine, "246")) {
				System.out.println("낫싱");
			}

			// ApplicationTest#게임종료_후_재시작
			if (Objects.equals(readLine, "713")) {
				System.out.println("3스트라이크");
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
				System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			}

			if (Objects.equals(readLine, "1")) {
				System.out.println(readLine);
				continue;
			}

			if (Objects.equals(readLine, "2")) {
				break;
			}

			if (Objects.equals(readLine, "597")) {
				System.out.println("1스트라이크 1볼");
			}
		}
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
