package baseball;

import nextstep.utils.Console;

public class Input {
	public static BaseballNumbers readPlayerBaseballNumbers() {
		return BaseballNumbersGenerator.createBaseballNumbers(Console.readLine());
	}

	public static String readPlayerInput(){
		return Console.readLine();
	}
}
