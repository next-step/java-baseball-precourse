package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class NumberBaseballGame {
	private List<String> answers;

	NumberBaseballGame() {
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/03 1:20 오전
	 * @Description : 임의의 수 선택
	 * @History :
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
	 * @Date : 2021/10/02 11:06 오후
	 * @Description : 사용자가 입력한 문자열을 반환하는 메소드
	 * @return {@link Console#readLine()}
	 * @throws NoSuchElementException 입력값이 없을 때
	 * @throws IllegalStateException 스캐너가 닫혔을 때
	 *
	 **/
	private String getInput() throws NoSuchElementException, IllegalStateException {
		String input = Console.readLine();

		return input;
	}
}
