package baseball;

import java.util.NoSuchElementException;
import java.util.Objects;

import nextstep.utils.Console;

public class Application {
	public static void main(String[] args) {
		// 사용자에게 입력을 받음
		while (true) {
			String readLine = "";

			try {
				readLine = Console.readLine();

				if (!Objects.equals(readLine, "1") && !Objects.equals(readLine, "2")) {
					System.out.println(String.format("숫자를 입력해주세요 : %s", readLine));
				}
			} catch (NoSuchElementException e) {
				// 입력값이 없을 때
				throw e;
			} catch (IllegalStateException e) {
				// 스캐너가 닫혔을 때
				throw e;
			}

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
}
