package baseball;

import nextstep.utils.Console;

public class BaseballUi {

	public void printGameResult(GameResult gameResult) {
		System.out.println(gameResult.toString());
	}

	public void printExceptionMessage(Exception e) {
		System.out.println("[ERROR]" + e.getMessage());
	}

	public String askForNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		return Console.readLine();
	}

	public boolean askForRestart() {
		System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		return "1".equals(Console.readLine()) ? true : false;
	}

	public void printEnd() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
	}

}
