package baseball;

import nextstep.utils.Console;

public class BaseBall {

	private String inNumber() {
		System.out.print("\n숫자를 입력해 주세요 : ");
		return Console.readLine();
	}

	private String restartQuestion() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		return Console.readLine();
	}
}
