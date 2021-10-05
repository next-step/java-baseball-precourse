package baseball.domain;

import java.util.NoSuchElementException;

import nextstep.utils.Console;

public class User {
	private User() {
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/02 11:06 오후
	 * @Description : 정상 입력 - 숫자 입력
	 * @return {@link Console#readLine()}
	 * @throws NoSuchElementException 입력값이 없을 때
	 * @throws IllegalStateException 스캐너가 닫혔을 때
	 *
	 **/
	public static String getNumberInput() throws NoSuchElementException, IllegalStateException {
		String input = Console.readLine();

		return input;
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/05 10:03 오후
	 * @Description : 정상 입력 - 다시 시작(1) or 완전 종료(2) 여부 입력
	 * @return {@link Console#readLine()}
	 * @throws NoSuchElementException 입력값이 없을 때
	 * @throws IllegalStateException 스캐너가 닫혔을 때
	 *
	 **/
	public static String getRestartInput() throws NoSuchElementException, IllegalStateException {
		String input = Console.readLine();

		return input;
	}
}
