package baseball.controller;

import baseball.dto.ResponseDto;
import baseball.dto.ResultDto;
import baseball.model.Game;
import baseball.model.Input;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class GameController {

	private Game game;

	private GameController() {
	}

	public static GameController getInstance() {
		return new GameController();
	}

	public void start() {
		game = new Game();
	}

	public void end() {
		game = null;
	}

	public ResponseDto check(String number) {
		try {
			validate(number);
		} catch (IllegalArgumentException e) {
			return ResponseDto.error(e.getMessage());
		}
		ResultDto result = game.check(inputsFrom(number));
		if (result.isEnd()) {
			return ResponseDto.ok(result.getMessage());
		}
		return ResponseDto.error(result.getMessage());
	}

	private Set<Input> inputsFrom(String number) {
		Set<Input> inputs = new LinkedHashSet<>();
		for (char input : number.toCharArray()) {
			inputs.add(new Input(inputs.size(), Character.getNumericValue(input)));
		}
		return inputs;
	}

	private void validate(String number) throws IllegalArgumentException {
		if (!isNumber(number)) {
			throw new IllegalArgumentException("[ERROR]1~9 사이의 숫자만 입력해주세요");
		}
		if (number.length() != 3) {
			throw new IllegalArgumentException("[ERROR]3개의 숫자를 입력해주세요");
		}
		if (!isUniqueNumber(number)) {
			throw new IllegalArgumentException("[ERROR]중복되지 않은 숫자를 입력해주세요");
		}
	}

	private boolean isNumber(String number) {
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	private boolean isUniqueNumber(String number) {
		Set<Character> set = new HashSet<>();
		for (char c : number.toCharArray()) {
			set.add(c);
		}
		return set.size() == 3;
	}
}
