package baseball.service;

import baseball.model.GuessResult;

public class GuessService {

	public GuessResult guess(String value) {
		NumberService numberService = new NumberService();
		GuessResult result = new GuessResult();

		for (int i = 0; i < 3; i++) {
			guessDetail(result, value, i);
		}
		return result;
	}

	public void guessDetail(GuessResult result, String value, int index) {
		NumberService numberService = new NumberService();

		int num = Integer.valueOf(value.substring(index, index + 1));
		if (numberService.isStrike(index, num)) {
			result.setStrikeCount(result.getStrikeCount() + 1);
			return;
		}
		if (numberService.isBall(num)) {
			result.setBallCount(result.getBallCount() + 1);
		}
	}

	public void guessResultPrint(GuessResult result) {
		if (result.getBallCount() + result.getStrikeCount() == 0) {
			System.out.println("낫싱");
			return;
		}
		String str = getBallCountPrint(result);
		str += getStrikeCountPrint(result);
		System.out.println(str);
	}

	private String getBallCountPrint(GuessResult result) {
		String str = "";
		if (result.getBallCount() != 0) {
			str += result.getBallCount() + "볼 ";
		}
		return str;
	}

	private String getStrikeCountPrint(GuessResult result) {
		String str = "";
		if (result.getStrikeCount() != 0) {
			str += result.getStrikeCount() + "스트라이크 ";
		}
		return str;
	}

	public void checkUserInput(String input) {
		if (input.length() > 3) {
			throw new IllegalArgumentException();
		}
	}


}
