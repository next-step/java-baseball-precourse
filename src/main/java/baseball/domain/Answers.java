package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import nextstep.utils.Randoms;

public class Answers {
	private static final int ANSWER_SIZE = 3;
	private static final int RANGE_MIN = 1;
	private static final int RANGE_MAX = 9;
	private static List<String> answers;

	private Answers() {
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/03 1:20 오전
	 * @Description : 임의의 수 선택
	 *
	 **/
	public static Answers init() {
		answers = new ArrayList<>();

		while (answers.size() < ANSWER_SIZE) {
			String pickedNumber = String.valueOf(Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX));

			if (!answers.contains(pickedNumber)) {
				answers.add(pickedNumber);
			}
		}

		return new Answers();
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/04 11:00 오후
	 * @Description : 단위 테스트를 위한 Getter 메소드
	 *
	 **/
	public List<String> getAnswers() {
		return answers;
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/04 10:35 오후
	 * @Description : 스트라이크 판단
	 *
	 **/
	public boolean isStrike(List<String> inputs, int index) {
		return Objects.equals(inputs.get(index), answers.get(index));
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/04 10:36 오후
	 * @Description : 볼 판단
	 *
	 **/
	public boolean isBall(String input) {
		return answers.contains(input);
	}
}
