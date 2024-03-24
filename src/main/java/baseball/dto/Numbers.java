package baseball.dto;

import java.util.ArrayList;

public class Numbers {
	public ArrayList<Integer> numbers;

	public Numbers() {
		numbers = new ArrayList<Integer>();

		while (numbers.size() < 3) {
			int randomNumber = (int)(Math.random() * 8) + 1;
			if (!numbers.contains(randomNumber)) {
				numbers.add(randomNumber);
			}
		}
	}

	public Numbers(ArrayList<Integer> num) {
		numbers = num;
	}
}
