package baseball;

import static baseball.constants.MessageConstant.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import nextstep.utils.Console;

/**
 * 게임을 진행해주는 클래스
 * @author Lee JeongHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Computer {

	private final String yes = "1";
	private final String no = "2";
	private final List<Game> gameList;
	private final Validator validator;

	public Computer() {
		gameList = new ArrayList<>();
		validator = new Validator();
	}

	/**
	 * 전체적인 게임을 시작
	 */
	public void play() {
		startGame();
		while (true) {
			System.out.println(NEW_GAME_MESSAGE);
			String input = Console.readLine();
			retryTyping(input);
		}
	}

	/**
	 * 게임 종료 후 다시 게임을 시작할지 확인
	 *
	 * @param input 입력받은 내용
	 */
	public void retryTyping(String input) {
		try {
			validator.validInputNewGame(input);
			selectNewGame(input);
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 1인 경우 게임시작
	 * 2인 경우 프로그램 종료
	 *
	 * @param input 입력받은 내용
	 */
	public void selectNewGame(String input) {
		if (yes.equals(input)) {
			startGame();
		}
		if (no.equals(input)) {
			exitProgram();
		}
	}

	/**
	 * 새로운 게임을 시작
	 */
	private void startGame() {
		Game game = new Game();
		gameList.add(game);
		boolean result;
		do {
			System.out.print(INPUT_MESSAGE);
			String input = Console.readLine();
			result = validAndTry(game, input);
		} while (!result);
	}

	/**
	 * 입력된 값의 유효성을 확인하고
	 * 게임의 입력시도를 진행하는 메소드
	 *
	 * @param game 진행되는 게임
	 * @param input 입력된 값
	 *
	 * @return 사용자가 정답을 맞춘 경우 true, 못맞추거나 예외사항 발생시 false
	 */
	private boolean validAndTry(Game game, String input) {
		try {
			validator.validInputInGame(input);
			TryResult tryResult = game.tryInput(input);
			System.out.println(tryResult);
			return tryResult.isWin();
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * 총 결과를 출력하고 프로그램을 종료
	 */
	private void exitProgram() {
		int trySize = 0;
		for (Game game : gameList) {
			trySize += game.getTryResultList().size();
		}
		String rate = ((float)gameList.size() / (float)trySize * 100f) + "%";
		System.out.printf((ENDING_MESSAGE_FORMAT) + "%n", gameList.size(), rate);
		System.exit(0);
	}

}
