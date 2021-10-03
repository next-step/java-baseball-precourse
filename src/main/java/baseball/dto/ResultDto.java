package baseball.dto;

import baseball.model.Input;

import java.util.Set;

public class ResultDto {

	private int strike = 0;
	private int ball = 0;
	private String message = "낫싱";
	private boolean end = false;

	private ResultDto(Set<Input> inputs) {
		count(inputs);
		setMessage();
		if (strike == 3) {
			end = true;
		}
	}

	public static ResultDto of(Set<Input> inputs) {
		return new ResultDto(inputs);
	}

	private void count(Set<Input> inputs) {
		for (Input input : inputs) {
			count(input);
		}
	}

	private void count(Input input) {
		if (input.isStrike()) {
			strike++;
		} else if (input.isBall()) {
			ball++;
		}
	}

	private void setMessage() {
		if (strike != 0 && ball != 0) {
			message = strike+"스트라이크 "+ball+"볼";
		} else if (strike != 0) {
			message = strike+"스트라이크";
		} else if (ball != 0) {
			message = ball+"볼";
		}
		if (strike == 3) {
			message += "\n3개의 숫자를 모두 맞히셨습니다! 게임 끝";
		}
	}

	public String getMessage() {
		return message;
	}

	public boolean isEnd() {
		return this.end;
	}
}
