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
	 * @Date : 2021/10/04 11:00 오후
	 * @Description : 단위 테스트를 위한 Getter 메소드
	 *
	 **/
	List<String> getAnswers() {
		return answers;
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/03 1:20 오전
	 * @Description : 임의의 수 선택
	 *
	 **/
	void initAnswers() {
		answers.clear();

		while (answers.size() < 3) {
			String pickedNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));

			if (!answers.contains(pickedNumber)) {
				answers.add(pickedNumber);
			}
		}
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/04 10:35 오후
	 * @Description : 스트라이크 판단
	 *
	 **/
	boolean isStrike(List<String> inputs, int index) {
		return Objects.equals(inputs.get(index), answers.get(index));
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
