package baseball.logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGameLogic implements GameLogic {

	@Override
	public boolean process(Collection origin, Collection value) {

		int strike = getStrikeCount((List<Integer>)origin, (List<Integer>)value);
		int ball = getBallCount((List<Integer>)origin, (List<Integer>)value, strike);

		StringBuilder sb = new StringBuilder();
		if (ball == 0 && strike == 0)
			sb.append("낫싱");
		if (ball > 0)
			sb.append(ball + "볼 ");
		if (strike > 0)
			sb.append(strike + "스트라이크");
		System.out.println(sb.toString());
		return strike == 3 ? true : false;
	}

	@Override
	public Object generateNumbers() {

		// Generate Random distinct 3 Numbers (1-9)
		List<Integer> randNum = new ArrayList<>();
		while (true) {
			int n = Randoms.pickNumberInRange(1, 9);
			if (!randNum.contains(n))
				randNum.add(n);
			if (randNum.size() == 3)
				break;
		}
		return randNum;
	}

	private int getStrikeCount(List<Integer> input1, List<Integer> input2) {
		int strike = 0;
		for (int i = 0; i < input1.size(); i++) {
			if (input1.get(i).equals(input2.get(i)))
				strike++;
		}
		return strike;
	}

	private int getBallCount(List<Integer> input1, List<Integer> input2, int strike) {
		List<Integer> origin = new ArrayList<>(input1);
		// 기존 생성된 숫자에서 입력 받은 숫자를 제거
		origin.retainAll(input2);
		return origin.size() - strike;
	}

}
