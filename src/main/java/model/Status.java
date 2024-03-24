package model;

import java.util.Arrays;
import java.util.Random;

public class Status {
	private int strikeCount;
	private int ballCount;

	public void initCount() {
		strikeCount = 0;
		ballCount = 0;
	}

	public void increaseStrikeCount() {
		strikeCount++;
	}

	public void increaseBallCount() {
		ballCount++;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public boolean isFinish() {
		return strikeCount == 3;
	}
}