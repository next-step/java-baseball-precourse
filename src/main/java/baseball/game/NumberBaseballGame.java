package baseball.game;

import baseball.util.Checker;
import baseball.domain.User;

public class NumberBaseballGame {
	private static final String ENTER_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

	private Checker checker;

	private NumberBaseballGame() {
		this.checker = Checker.init();
	}

	public static NumberBaseballGame init() {
		return new NumberBaseballGame();
	}

	/**
	 * @author : yh.kim
	 * @Date : 2021/10/03 1:47 오전
	 * @Description : 게임 시작
	 *
	 **/
	public boolean start() {
		System.out.print(ENTER_NUMBERS_MESSAGE);

		String readLine = User.getInput();

		return checker.checkInput(readLine);
	}
}
