package baseball.model;

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
}
