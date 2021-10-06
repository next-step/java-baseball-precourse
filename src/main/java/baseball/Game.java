package baseball;

import java.util.LinkedHashSet;

import static config.Constant.*;
import static config.Message.*;
import static nextstep.utils.Console.readLine;
import static nextstep.utils.Randoms.pickNumberInRange;

public class Game {
	public void run() {
		int strike = 0;
		int ball = 0;
		String result = "";
		LinkedHashSet<Integer> comSet = getComLinkedHashSet();
		LinkedHashSet<Integer> userInputSet = getUserLinkedHashSet();

		// 제시된 숫자에서 중복값이 있는지 체크
		if(userInputSet.size() < INPUT_SIZE){
			System.out.println(ERROR_SIZE);
			getInput();
		}

		// 제시된 숫자와 순서가 다를때
		if(!comSet.toString().equals(userInputSet.toString())){
			strikeballCheck(strike, ball);
		}

		// 제시된 숫자와 순서가 동일할 때 (게임완료)
		if(comSet.toString().equals(userInputSet.toString())){
			System.out.println(GAME_END_MESSAGE);

			if(getRetry().equals("1")){
				run();
			}
		}
	}

	private void strikeballCheck(int strike, int ball) {
		String result;
		if(strike > 0){
			result = strike + STRIKE;
			System.out.println(result);
		}

		if(ball > 0){
			result = ball + BALL;
			System.out.println(result);
		}

		if(strike > 0 && ball > 0){
			result = strike + STRIKE + ball + BALL;
			System.out.println(result);
		}
		getInput();
	}

	private LinkedHashSet<Integer> getUserLinkedHashSet() {
		String input = getInput();
		LinkedHashSet<Integer> userInputSet = new LinkedHashSet<Integer>();
		userInputSet.add(Character.getNumericValue(input.charAt(0)));
		userInputSet.add(Character.getNumericValue(input.charAt(1)));
		userInputSet.add(Character.getNumericValue(input.charAt(2)));
		return userInputSet;
	}

	private static LinkedHashSet<Integer> getComLinkedHashSet() {
		LinkedHashSet<Integer> comSet = new LinkedHashSet<Integer>();
		while(comSet.size() < 3){
			comSet.add(pickNumberInRange(MIN, MAX));
		}
		return comSet;
	}

	private static String getInput() {
		System.out.println(INPUT_MESSAGE);
		String input = readLine();
		return input;
	}

	private static String getRetry() {
		System.out.println(CHOOSE_MESSAGE);
		String chooseInput = readLine();
		return chooseInput;
	}
}
