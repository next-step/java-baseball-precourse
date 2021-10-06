package baseball;

public class BaseballGame {
	private BaseballNumbers playerNumbers;
	private BaseballNumbers computerNumbers;

	public void start() {
		Computer computer = new Computer();
		computerNumbers = computer.createBaseballNumbers();
		System.out.println(computerNumbers.getBaseballNumbers());

		do {
			readPlayerBaseballNumbers();
			Output.printGameResult(judgment(playerNumbers, computerNumbers));
		} while (isEndGame(playerNumbers, computerNumbers));
		Output.printEndOfGameMessage();
	}

	private void readPlayerBaseballNumbers() {
		try {
			Output.printInputNumberMessage();
			playerNumbers = Input.readPlayerBaseballNumbers();
		} catch (IllegalArgumentException exception) {
			Output.printExceptionMessage(exception.getMessage());
			readPlayerBaseballNumbers();
		}
	}

	private boolean isEndGame(BaseballNumbers playerNumbers, BaseballNumbers computerNumbers) {
		if (playerNumbers.equals(computerNumbers)) {
			return false;
		}
		return true;
	}

	public String judgment(BaseballNumbers playerNumbers, BaseballNumbers computerNumbers) {
		int countOfSameNumber = playerNumbers.countSameNumber(computerNumbers);
		int countOfStrike = playerNumbers.countSameNumberAndLocation(computerNumbers);
		int countOfBall = countOfSameNumber - countOfStrike;

		if (countOfSameNumber == 0)
			return "낫싱";

		StringBuffer buffer = new StringBuffer();
		if (countOfStrike != 0) {
			buffer.append(countOfStrike)
				.append("스트라이크");
		}

		if (countOfBall != 0) {
			if (buffer.length() > 0) {
				buffer.append(" ");
			}
			buffer.append(countOfBall)
				.append("볼");
		}
		return buffer.toString();
	}
}
