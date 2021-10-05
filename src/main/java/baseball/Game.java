package baseball;

import static baseball.constants.CommonConstant.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import baseball.constants.ResultEnum;
import nextstep.utils.Randoms;

/**
 * 게임 클래스
 * @author Lee JeongHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Game {

	private final List<Integer> answer;
	private final List<TryResult> tryResultList;

	public Game() {
		this.answer = getAnswer();
		this.tryResultList = new ArrayList<>();
	}

	public Game(List<Integer> answer) {
		this.answer = answer;
		this.tryResultList = new ArrayList<>();
	}

	public List<TryResult> getTryResultList() {
		return tryResultList;
	}

	public List<Integer> getAnswer() {
		Set<Integer> numberSet = new LinkedHashSet<>();
		while (numberSet.size() < INPUT_MAX_COUNT) {
			numberSet.add(Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE));
		}
		List<Integer> numbers = new ArrayList<>(numberSet);
		return numbers;
	}

	/**
	 * 입력에 대한 결과를 도출 하는 메소드
	 * 한번 입력 시 마다 일어나며 입력 결과를 저장
	 *
	 * @param input 타이핑되어 입력된 값
	 * @return 승리 여부
	 */
	public TryResult tryInput(String input) {
		List<Integer> numberList = convertToList(input);
		TryResult tryResult = new TryResult();
		for (int i = 0; i < numberList.size(); i++) {
			ResultEnum result = checkAnswer(numberList.get(i), i);
			tryResult.addResultEnum(result);
		}
		tryResultList.add(tryResult);
		return tryResult;
	}

	/**
	 * String으로 입력된 값을 IntegerList로 변환하는 메소드
	 *
	 * @param input 입력된 값
	 * @return 변환된 리스트 값을 반환
	 */
	public List<Integer> convertToList(String input) throws ClassCastException {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			list.add(Character.getNumericValue(input.charAt(i)));
		}
		return list;
	}

	/**
	 * 입력된 값과 위치를 정답과 비교하는 메소드
	 *
	 * @param value 입력된 값
	 * @param idx 입력된 값의 위치
	 * @return 입력 시도에 대한 결과를 반환
	 */
	public ResultEnum checkAnswer(int value, int idx) {
		int match = answer.indexOf(value);
		if (match == -1) {
			return ResultEnum.NOT;
		}
		if (match == idx) {
			return ResultEnum.STRIKE;
		}
		return ResultEnum.BALL;
	}

}
