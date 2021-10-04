package baseball;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class BaseballGame {

	//게임 세팅 기능
	public List<Integer> pitcher() {
		List<Integer> ballList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			ballList.add(Randoms.pickNumberInRange(1, 9));
		}
		return ballList;
	}

	//게임 입력 기능
	public List<Integer> swing() {
		System.out.println("숫자를 입력해주세요.");
		String swing = "";
		boolean isSwingValid = false;
		while (!isSwingValid == false) {
			swing = Console.readLine();
			isSwingValid = swingValid(swing);
			if (!isSwingValid == false) {
				System.out.println("[ERROR] 올바른 숫자를 다시 입력해주세요.");
			}
		}
		List<Integer> swingList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			swingList.add(Character.getNumericValue(swing.charAt(i)));
		}
		return swingList;
	}

	private boolean swingValid(String swing) {
		if (swing == null || swing.length() != 3 || swing.matches("-?\\d+") == false) {
			return false;
		}
		return true;
	}
}
