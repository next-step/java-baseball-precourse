import java.util.Random;

public class Baseball {
	private int[] computerNumber;

	public Baseball() {
		computerNumber = null;
	}

	public void init() {
		computerNumber = new int[10];
		for (int i = 0; i < 10; ++i) {
			computerNumber[i] = -1;
		}
		Random randomGenerator = new Random();
		for (int i = 0; i < 3; ++i) {
			int digit = generateRandomValidDigit(randomGenerator);
			while (computerNumber[digit] != -1) {
				digit = generateRandomValidDigit(randomGenerator);
			}
			computerNumber[digit] = i;
		}
	}

	private int generateRandomValidDigit(Random generator) {
		return generator.nextInt(9) + 1;
	}

	public boolean isValidControl(int control) {
		return control == 1 || control == 2;
	}

	public boolean isQuit(int control) {
		return control == 2;
	}

	public boolean isValidNumber(int number) {
		boolean[] isDigitUsed = { false, false, false, false, false, false, false, false, false, false };
		int digitCount;
		for (digitCount = 0; number > 0; ++digitCount, number /= 10) {
			int digit = number % 10;
			if (digit == 0 || isDigitUsed[digit]) {
				return false;
			}
			isDigitUsed[digit] = true;
		}
		return digitCount == 3;
	}

	public BaseballResult compareNumber(int number) {
		BaseballResult result = new BaseballResult();
		for (int position = 0; number > 0; ++position, number /= 10) {
			int digit = number % 10;
			updateResult(result, digit, position);
		}
		return result;
	}

	private void updateResult(BaseballResult result, int digit, int position) {
		if (computerNumber[digit] == -1) {
			return;
		}
		if (computerNumber[digit] == position) {
			result.addOneStrike();
			return;
		}
		result.addOneBall();
	}

	public int getComputerNumber() {
		int number = 0;
		for (int i = 0; i < 10; ++i) {
			if (computerNumber[i] == -1) {
				continue;
			}
			number += i * (int)Math.pow(10, computerNumber[i]);
		}
		return number;
	}

	public void setComputerNumber(int number) {
		for (int i = 0; i < 10; ++i) {
			computerNumber[i] = -1;
		}
		for (int position = 0; position < 3 && number > 0; ++position, number /= 10) {
			int digit = number % 10;
			computerNumber[digit] = position;
		}
	}
}
