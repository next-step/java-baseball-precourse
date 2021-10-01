package baseball;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Application {

	public static void main(String[] args) {
		start();
	}

	public static void start() {

		List<Integer> answer = createNumber();
		System.out.println(answer.toString());

		while (true) {

			System.out.print("숫자를 입력해주세요 : ");
			String input = Console.readLine();

			if (!validate(input)) {
				System.out.println("[ERROR] 입력이 잘못되었습니다.");
				continue;
			}

			List<Integer> inputNumbers = createNumber(input);

			if (start(answer, inputNumbers)) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임끝");
				System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

				while (true) {

					input = Console.readLine();
					if (input.equals("1")) {
						answer = createNumber();
						System.out.println(answer.toString());
						break;
					} else if (input.equals("2")) {
						System.out.println("게임끝");
						return;
					}
					System.out.println("잘못입력하셨습니다. 다시 입력하세요");
				}
			}
		}
	}

	public static List<Integer> createNumber(String input) {

		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			numbers.add(Integer.valueOf(input.charAt(i) + ""));
		}
		return numbers;
	}

	public static List<Integer> createNumber() {

		int[] arr = new int[10];

		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			int num = Randoms.pickNumberInRange(1, 9);
			if (arr[num] != 0) {
				i--;
				continue;
			}
			arr[num]++;
			numbers.add(num);
		}
		return numbers;
	}

	public static boolean start(List<Integer> answer, List<Integer> input) {

		int ball = 0;
		int strike = 0;

		for (int i = 0; i < answer.size(); i++) {

			for (int j = 0; j < input.size(); j++) {

				if (answer.get(i) == input.get(j) && i == j) {
					strike++;
				} else if (answer.get(i) == input.get(j)) {
					ball++;
				}
			}
		}
		String strikeMessage = strike + "스트라이크";
		String ballMessage = ball + "볼";
		System.out.println(strikeMessage + " " + ballMessage);
		return strike == 3;
	}

	public static boolean validate(String input) {

		if (input.length() != 3) {
			return false;
		}

		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
