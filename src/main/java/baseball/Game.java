package baseball;

import java.util.ArrayList;
import java.util.List;

import baseball.Constants.ResultEnum;
import nextstep.utils.Console;

/**
 * 게임 클래스
 * @author Lee JeongHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Game {

	static final String ENDING_MESSAGE = " 번만에 승리했습니다.";
	List<Integer> answer;
	List<TryResult> tryResultList;

	public Game(List<Integer> answer) {
		this.answer = answer;
		this.tryResultList = new ArrayList<>();
	}

	/**
	 * 게임 시작 메소드
	 * 승리 할 때 까지 입력을 계속 받고 승리 이후 메세지 출력
	 */
	public void startGame() {
		boolean isWin = false;
		while (!isWin) {
			String input = Console.readLine();
			isWin = tryTyping(input);
		}
		endGame();
	}

	/**
	 * 입력에 대한 결과를 도출 하는 메소드
	 * 한번 입력 시 마다 일어나며 입력 결과를 저장
	 *
	 * @param input 타이핑되어 입력된 값
	 * @return 승리 여부
	 */
	public boolean tryTyping(String input) {
		List<Integer> numberList = convertToList(input);
		TryResult tryResult = new TryResult();
		for (int i = 0; i < numberList.size(); i++) {
			ResultEnum result = checkAnswer(numberList.get(i), i);
			tryResult.addResultEnum(result);
		}
		addTryResult(tryResult);
		return tryResult.isWin();
	}

	/**
	 * 입력 시도 결과를 저장하고 내용을 출력
	 *
	 * @param tryResult 입력 시도 결과
	 */
	private void addTryResult(TryResult tryResult) {
		tryResultList.add(tryResult);
		System.out.println(tryResult);
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

	public void endGame() {
		System.out.println(tryResultList.size() + ENDING_MESSAGE);
	}

}
