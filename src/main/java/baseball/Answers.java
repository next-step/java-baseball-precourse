package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import nextstep.utils.Randoms;

public class Answers {
	private List<String> answers;

	Answers() {
		this.answers = new ArrayList<>();
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/03 1:20 오전
	 * @Description : 임의의 수 선택
	 *
	 **/
	void initAnswers() {
		answers = Arrays.asList(
			new String[] {
				String.valueOf(Randoms.pickNumberInRange(1, 9))
				, String.valueOf(Randoms.pickNumberInRange(1, 9))
				, String.valueOf(Randoms.pickNumberInRange(1, 9))
			}
		);
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/04 10:35 오후
	 * @Description : 스트라이크 판단
	 *
	 **/
	boolean isStrike(List<String> inputs, int i) {
		return Objects.equals(inputs.get(i), answers.get(i));
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/04 10:36 오후
	 * @Description : 볼 판단
	 *
	 **/
	boolean isBall(String input) {
		return answers.contains(input);
	}
}
