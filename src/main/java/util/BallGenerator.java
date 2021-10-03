package util;

import java.util.ArrayList;
import java.util.List;

import domain.Ball;
import nextstep.utils.Randoms;

public class BallGenerator {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	public static List<Ball> createBalls() {

		int[] arr = new int[10];

		List<Ball> balls = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			int num = Randoms.pickNumberInRange(1, 9);
			if (arr[num] != 0) {
				i--;
				continue;
			}
			arr[num]++;
			balls.add(new Ball(num, i));
		}
		return balls;

	}

	public static List<Ball> convertInput(String input) {
		List<Ball> balls = new ArrayList<>();
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			balls.add(new Ball(Integer.valueOf(String.valueOf(c[i])), i));
		}
		return balls;
	}
}
