package baseball.domain;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Baseballs {
	private final List<Baseball> baseballs;

	private Baseballs(List<Baseball> baseballs) {
		isValidSize(baseballs);
		isDuplicate(baseballs);
		this.baseballs = baseballs;
	}

	private void isValidSize(List<Baseball> baseballs) {
		if (baseballs.size() != 3) {
			throw new IllegalArgumentException();
		}
	}

	private void isDuplicate(List<Baseball> baseballs) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < i; j++) {
				if (baseballs.get(i).equals(baseballs.get(j))) {
					throw new IllegalArgumentException();
				}
			}
		}
	}

	public static Baseballs createBaseballs(String baseballNumbers) {
		List<Baseball> baseballs = new ArrayList<>();

		for (int i = 0; i < baseballNumbers.length(); i++) {
			baseballs.add(Baseball.of(baseballNumbers.charAt(i) - '0'));
		}
		return new Baseballs(baseballs);
	}

	public static Baseballs createRandomBaseballs() {
		Set<Baseball> baseballsSet = new HashSet<>();
		do{
			baseballsSet.add(Baseball.of(pickNumberInRange(1, 9)));
			if (baseballsSet.size() == 3) {
				break;
			}
		}while (true);
		List<Baseball> baseballs =new ArrayList<>(baseballsSet);
		return new Baseballs(baseballs);
	}

	public int countStrike(Baseballs cmpBaseballs) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (baseballs.get(i).equals(cmpBaseballs.baseballs.get(i))) {
				count++;
			}
		}
		return count;
	}

	public int countBall(Baseballs cmpBaseballs) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (baseballs.get(i).equals(cmpBaseballs.baseballs.get(j)) && (i != j)) {
					count++;
				}
			}
		}
		return count;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Baseballs baseballs = (Baseballs) o;
		return Objects.equals(this.baseballs, baseballs.baseballs);
	}

	@Override
	public int hashCode() {
		return Objects.hash(baseballs);
	}
}
