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

	//게임 실행
	public BaseBall run(List<Integer> ballList, List<Integer> swingList) {
		BaseBall baseBall = new BaseBall();
		for (int i = 0; i < ballList.size(); i++) {
			int ball = ballList.get(i);
			int swing = swingList.get(i);
			if (ball == swing) {
				baseBall.setStrike(baseBall.getStrike() + 1);
				continue;
			}
			for (int j = 0; j < swingList.size(); j++) {
				if (i != j) {
					swing = swingList.get(j);
					if (ball == swing) {
						baseBall.setBall(baseBall.getBall() + 1);
						break;
					}
				}
			}
		}
		return baseBall;
	}

	public boolean result(BaseBall baseBall) {
		String resultStr = "";
		if (baseBall.getStrike() > 0) {
			resultStr = String.format("%s스트라이크 ", baseBall.getStrike());
		}
		if (baseBall.getBall() > 0) {
			resultStr += String.format("%s볼", baseBall.getBall());
		}
		if (baseBall.getBall() == 0 && baseBall.getStrike() == 0) {
			resultStr = "낫싱";
		}
		System.out.println(resultStr);
		if (baseBall.getStrike() == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
			return true;
		}
		return false;
	}
}
