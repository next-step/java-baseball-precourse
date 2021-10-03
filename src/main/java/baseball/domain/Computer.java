package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import baseball.config.ConfigBaseball;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

/**
 * 게임을 위한 랜덤 값 생성
 * 생성된 랜덤 값 과 사용자 입력 값 검증을 위한 도메인
 */
public class Computer {

	private List randomValue = new ArrayList();
	private final int INPUT_SIZE = ConfigBaseball.INPUT_SIZE;
	private final int PICK_NUMBER_MIN = ConfigBaseball.PICK_NUMBER_MIN;
	private final int PICK_NUMBER_MAX = ConfigBaseball.PICK_NUMBER_MAX;
	private final String HINT_STRIKE_MESSAGE = ConfigBaseball.HINT_STRIKE_MESSAGE;
	private final String HINT_BALL_MESSAGE = ConfigBaseball.HINT_BALL_MESSAGE;
	private final String HINT_NOTHING_MESSAGE = ConfigBaseball.HINT_NOTHING_MESSAGE;
	private final String GAME_CLEAR_FIRST_MESSAGE = ConfigBaseball.GAME_CLEAR_FIRST_MESSAGE;
	private final String GAME_CLEAR_SECOND_MESSAGE = ConfigBaseball.GAME_CLEAR_SECOND_MESSAGE;
	private final List newGameSelector = Arrays.asList(ConfigBaseball.NEW_GAME_SELECTOR,
		ConfigBaseball.END_GAME_SELECTOR);
	private String hint = "";
	private int strike = 0;
	private int ball = 0;

	/**
	 * 기존에 있던 랜덤값을 지우고 새로운 랜덤값 생성
	 * 랜덤값은 중복되지 않는 서로다른 수임
	 * @return randomValue
	 */
	public List getClearRandomValue() {
		clear();
		init();
		return getRandomValue();
	}

	/**
	 * 3스트라이크 일 경우 새로운게임(NEW_GAME_SELECTOR) 혹은
	 * 게임종료(END_GAME_SELECTOR) 선택
	 */
	public boolean isGameClear() {
		boolean isSuccess = getStrike() == INPUT_SIZE;
		clearStrikeBall();

		if (isSuccess && isNewGame()) {
			getClearRandomValue();
			isSuccess = false;
		}

		return isSuccess;
	}

	/**
	 * 0스트라이크 0볼 일 경우 낫싱
	 */
	public boolean checkNothing() {
		if (getStrike() == 0 && getBall() == 0) {
			return true;
		}

		return false;
	}

	/**
	 * 사용자의 입력값이 컴퓨터의 랜덤값과 일치하지만,
	 * 자리가 다른 경우 볼 카운트 증가
	 */
	public int checkBall(List randomValue, List userInput) {
		for (int i = 0; i < INPUT_SIZE; i++) {
			countBall(randomValue, userInput, i);
		}

		return getBall();
	}

	/**
	 * 사용자의 입력값이 컴퓨터의 랜덤값과 일치하며,
	 * 자리 또한 같은 경우 스트라이크 카운트 증가
	 */
	public int checkStrike(List randomValue, List userInput) {
		if (isThreeStrike(randomValue, userInput)) {
			setStrike(INPUT_SIZE);
			return getStrike();
		}

		for (int i = 0; i < INPUT_SIZE; i++) {
			countStrike((int)randomValue.get(i), (int)userInput.get(i));
		}
		return getStrike();
	}

	/**
	 * 스트라이크, 볼 카운트를 기준으로 힌트생성
	 */
	public String makeHint() {
		StringBuilder hintBuilder = new StringBuilder();

		if (!isNothing(hintBuilder)) {
			appendHint(hintBuilder);
		}

		setHint(hintBuilder.toString());
		System.out.println(getHint());

		return getHint();
	}

	/**
	 * 게임완료 메시지 출력과 함께 사용자가 새로운게임(NEW_GAME_SELECTOR) 혹은
	 * 게임종료(END_GAME_SELECTOR) 중 어떤걸 선택했는지 확인
	 */
	private boolean isNewGame() {
		System.out.println(GAME_CLEAR_FIRST_MESSAGE);
		System.out.println(GAME_CLEAR_SECOND_MESSAGE);
		String readLine = Console.readLine();

		while (!isContainNewGameSelector(readLine)) {
			System.out.println(GAME_CLEAR_SECOND_MESSAGE);
			readLine = Console.readLine();
		}

		return isSelectedNewGame(readLine);
	}

	/**
	 * 새로운게임(NEW_GAME_SELECTOR)을 선택할 경우 True 아닐경우 False 반환
	 */
	private boolean isSelectedNewGame(String readLine) {
		return String.valueOf(newGameSelector.get(0)).equals(String.valueOf(readLine.charAt(0)));
	}

	/**
	 * 사용자가 선택한 값이 NEW_GAME_SELECTOR 또는 END_GAME_SELECTOR 인지 확인
	 */
	private boolean isContainNewGameSelector(String readLine) {
		return readLine.length() == 1 && newGameSelector.contains(readLine.charAt(0));
	}

	/**
	 * 0스트라이크 0볼 일 경우 낫싱 메시지 힌트로 추가
	 */
	private boolean isNothing(StringBuilder hintBuilder) {
		if (checkNothing()) {
			hintBuilder.append(HINT_NOTHING_MESSAGE);
			return true;
		}

		return false;
	}

	/**
	 * 같은 수, 같은 자리 전부일치 할 경우 True 반환
	 */
	private boolean isThreeStrike(List randomValue, List userInput) {
		return Arrays.equals(randomValue.toArray(), userInput.toArray());
	}

	/**
	 * 수는 같지만 자리가 다를경우 볼 카운트 증가
	 */
	private void countBall(List randomValue, List userInput, int i) {
		if (randomValue.contains(userInput.get(i)) && !randomValue.get(i).equals(userInput.get(i))) {
			ball++;
		}
	}

	/**
	 * 수와 자리 모두 일치 할 경우 스트라이크 카운트 증가
	 */
	private void countStrike(int randomValue, int userInput) {
		if (randomValue == userInput) {
			strike++;
		}
	}

	/**
	 * 스트라이크와 볼 카운트가 0이 아닐 경우 힌트에 추가
	 */
	private void appendHint(StringBuilder hintBuilder) {
		if (getStrike() != 0) {
			hintBuilder.append(getStrike()).append(HINT_STRIKE_MESSAGE);
		}

		appendHintDelimiter(hintBuilder);

		if (getBall() != 0) {
			hintBuilder.append(getBall()).append(HINT_BALL_MESSAGE);
		}
	}

	/**
	 * 스트라이크와 볼 힌트 사이에 공백 추가
	 */
	private void appendHintDelimiter(StringBuilder hintBuilder) {
		if (getStrike() != 0 && getBall() != 0) {
			hintBuilder.append(" ");
		}
	}

	/**
	 * 1~9까지 서로다른 랜덤 수를 INPUT_SIZE 만큼 생성
	 */
	private void init() {
		while (randomValue.size() != INPUT_SIZE) {
			int random = Randoms.pickNumberInRange(PICK_NUMBER_MIN, PICK_NUMBER_MAX);
			addRandomValue(random);
		}

	}

	/**
	 * 중복된 값이 아닐 경우에만 랜덤값에 포함
	 */
	private void addRandomValue(int random) {
		if (!randomValue.contains(random)) {
			randomValue.add(random);
		}
	}

	/**
	 * 게임진행 관련 필드 값 초기화
	 */
	private void clear() {
		if (!randomValue.isEmpty()) {
			randomValue.clear();
		}
		setHint("");
		clearStrikeBall();
	}

	/**
	 * 스트라이크, 볼 값 초기화
	 */
	private void clearStrikeBall() {
		setStrike(0);
		setBall(0);
	}

	private void setStrike(int strike) {
		this.strike = strike;
	}

	private void setBall(int ball) {
		this.ball = ball;
	}

	private void setHint(String hint) {
		this.hint = hint;
	}

	public List getRandomValue() {
		return randomValue;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public String getHint() {
		return hint;
	}
}
