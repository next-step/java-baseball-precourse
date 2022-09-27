package baseball;

import baseball.model.GuessResult;
import baseball.service.GuessService;
import baseball.service.NumberService;
import camp.nextstep.edu.missionutils.Console;

public class Application {

	public static void main(String[] args) {
		boolean gameContinue = true;
		while (gameContinue) {
			game();

			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
			String input = Console.readLine();
			gameContinue = setContinue(input);
		}
	}

	public static boolean setContinue(String input) {
		boolean gameContinue = true;
		if ("2".equals(input)) {
			gameContinue = false;
		}
		return gameContinue;
	}

	public static void game() {
		NumberService numberService = new NumberService();

		numberService.resetGame();
		gameGuess();

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public static void gameGuess() {
		GuessResult guess = new GuessResult();
		GuessService guessService = new GuessService();
		while (!(guess.getStrikeCount() == 3)) {
			System.out.print("숫자를 입력해주세요 : ");
			String input = Console.readLine();
			guessService.checkUserInput(input);
			
			guess = guessService.guess(input);
			guessService.guessResultPrint(guess);
		}
	}

}
