package baseball.view;

import baseball.controller.BaseballGameConrtoller;
import baseball.vo.GameResultVo;
import baseball.vo.SubmitBallNumberResponseVo;
import nextstep.utils.Console;

public class BaseballGameView {
	private BaseballGameConrtoller baseballGameConrtoller;

	public BaseballGameView() {
		this.baseballGameConrtoller = new BaseballGameConrtoller();
	}

	public void play() {
		while (true) {
			baseballGameConrtoller.initGame();
			while (true) {
				System.out.print("숫자를입력해주세요 : ");
				SubmitBallNumberResponseVo response = baseballGameConrtoller.submitBallNumberStr(Console.readLine());
				if (!response.getStatus().equals("SUCCESS")) {
					System.out.println("[ERROR] 숫자 제출중 에러가 발생하였습니다.");
					continue;
				}

				GameResultVo gameResult = response.getGameResult();
				if (gameResult.getStrike() > 0) {
					System.out.print(gameResult.getStrike() + "스트라이크 ");
				}
				if (gameResult.getBall() > 0) {
					System.out.print(gameResult.getBall() + "볼");
				}
				if (gameResult.getStrike() + gameResult.getBall() == 0) {
					System.out.print("낫싱");
				}
				System.out.println();

				if (gameResult.getStrike() == 3) {
					System.out.println("3개의숫자를모두맞히셨습니다! 게임 끝");
					break;
				}
			}
			System.out.println("게임을새로시작하려면1,종료하려면2를입력하세요.");
			if (Console.readLine().equals("2")) {
				break;
			}
		}
	}
}
