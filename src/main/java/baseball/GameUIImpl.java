package baseball;

import baseball.dto.MatchResult;

public class GameUIImpl implements GameUI {
	public void printStartOrStop() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	public void printRequireUserInput() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	public void printMatchResult(MatchResult matchResult) {
		String textToPrint = "낫싱";

		if (matchResult.ball != 0) {
			textToPrint = String.format("%d볼", matchResult.ball);
		}
		if (matchResult.strike != 0) {
			textToPrint = String.format("%d스트라이크", matchResult.strike);
		}
		if (matchResult.strike != 0 && matchResult.ball != 0) {
			textToPrint = String.format("%d스트라이크, %d볼", matchResult.strike, matchResult.ball);
		}

		System.out.println(textToPrint);
	}

	public void printFinished() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
	}

	public void printError() {
		System.out.println("ERROR : 유효한 값을 입력해 주세요.");
	}

}
