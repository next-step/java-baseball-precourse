package baseball.model;

import baseball.dto.ResultDto;
import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Game {

	private final Set<Target> targets = new LinkedHashSet<>();

	public Game() {
		setTargets();
	}

	private void setTargets() {
		targets.clear();
		while (targets.size() < 3) {
			targets.add(new Target(targets.size(), Randoms.pickNumberInRange(1, 9)));
		}
	}

	public ResultDto check(Set<Input> inputs) {
		for (Input input : inputs) {
			check(input);
		}
		return ResultDto.of(inputs);
	}

	private void check(Input input) {
		input.hit(targets);
	}
}
