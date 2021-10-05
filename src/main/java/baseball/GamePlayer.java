package baseball;

import baseball.utils.BaseballGameNumber;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class GamePlayer {

	private static Boolean replayYn = true;

	public static void start() {
		// 상대방(컴퓨터)의 임의의 랜덤 수 생성
		int pickNumber = getPickNumber();

		do {
			// 숫자입력
			int playerNumber = getPlayerNumber();

			// 숫자 비교
			String resultValue = BaseballGameNumber.comparingNumbers(pickNumber, playerNumber);
			System.out.println(resultValue);
			// 지속여부 체크
			if (resultValue.equals("3스트라이크")) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
				System.out.println("게임을 새로  시작하려면 1, 종료하려면 2를 입력하세요.");
				if (!checkGameReplay(Console.readLine())) {
					replayYn = false;
				}

				if (replayYn) {
					pickNumber = getPickNumber();
				}
			}

		} while (replayYn);
	}

	private static int getPickNumber() {
		Boolean rePickNumberYn = false;
		int pickNumber = 0;

		do {
			String tempNumber = "";
			for (int index = 0; index < 3; index++) {
				tempNumber += Randoms.pickNumberInRange(1, 9);
			}

			pickNumber = Integer.parseInt(tempNumber);

			rePickNumberYn = !BaseballGameNumber.validatePickNumber(pickNumber);
		} while (rePickNumberYn);

		return pickNumber;
	}

	private static int getPlayerNumber() {
		Boolean replayEnterYn = false;
		int inputNumber = 0;

		do {
			replayEnterYn = false;
			System.out.print("숫자를 입력해주세요 : ");
			inputNumber = Integer.parseInt(Console.readLine());

			if (!BaseballGameNumber.validatePickNumber(inputNumber)) {
				System.out.println("[ERROR]서로 다른 수로 이루어진 3자리의 수를 입력해주세요");
				replayEnterYn = true;
			}

		} while (replayEnterYn);

		return inputNumber;
	}

	private static Boolean checkGameReplay(String replayNumber) {
		if (replayNumber.equals("1")) {
			return true;
		}

		return false;
	}

}
