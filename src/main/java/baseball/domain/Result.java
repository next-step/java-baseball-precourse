package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
	private List<Status> result = new ArrayList<>();
	private int strike = 0;
	private int ball = 0;

	public Result(){}

	public void addResult(Status gameResult) {
		this.result.add(gameResult);
	}

	public String getResultString() {
		updateResult();
		StringBuilder outputString = new StringBuilder();
		if(ball > 0) {
			outputString.append(ball + "볼");
		}
		if(strike > 0) {
			outputString = appendBlank(outputString);
			outputString.append(strike + "스트라이크");
		}
		if(ball == 0 && strike == 0) {
			outputString.append("낫싱");
		}
		return outputString.toString();
	}

	public StringBuilder appendBlank(StringBuilder outputString) {
		if(outputString.length() != 0) {
			outputString.append(" ");
		}
		return outputString;
	}

	public void updateResult() {
		for(Status status : result) {
			addCount(status);
		}
	}

	void addCount(Status status) {
		if(status == Status.STRIKE) {
			strike++;
		}
		if(status == Status.BALL) {
			ball++;
		}
	}


}
