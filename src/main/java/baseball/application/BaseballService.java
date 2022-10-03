package baseball.application;

import baseball.domain.Baseballs;
import baseball.infrastructure.BaseballMessages;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballService {
	private Baseballs userBaseballs;
	private Baseballs computerBaseballs;

	public void playBaseball() {
		computerBaseballs = Baseballs.createRandomBaseballs();

		do {
			playBaseballOnce();
		} while(!isCorrectAnswer());
		System.out.println(BaseballMessages.GAME_SET.getMessage());
	}

	private void playBaseballOnce() {
		System.out.print(BaseballMessages.INPUT_NUMBERS.getMessage());
		userBaseballs = receiveUserBaseballs();
		BaseballResult baseballResult = BaseballResult.of(computerBaseballs, userBaseballs);
		System.out.println(baseballResult.getResult());
	}

	private Baseballs receiveUserBaseballs() {
		return Baseballs.createBaseballs(readLine());
	}

	private boolean isCorrectAnswer() {
		return userBaseballs.equals(computerBaseballs);
	}
}