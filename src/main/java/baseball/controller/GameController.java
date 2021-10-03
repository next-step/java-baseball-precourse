package baseball.controller;

import baseball.dto.ResponseDto;
import baseball.dto.ResultDto;
import baseball.model.Game;
import baseball.model.Input;

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
}
